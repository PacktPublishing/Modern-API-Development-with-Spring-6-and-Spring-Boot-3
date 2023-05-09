package com.packt.modern.api.repository;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import com.packt.modern.api.generated.types.Product;
import com.packt.modern.api.generated.types.Tag;
import com.packt.modern.api.generated.types.TagInput;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import net.datafaker.Faker;
import org.apache.logging.log4j.util.Strings;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

/**
 * @author : github.com/sharmasourabh
 * @project : chapter14 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@org.springframework.stereotype.Repository
public class InMemRepository implements Repository {

  private static final Map<String, Product> productEntities = new ConcurrentHashMap<>();
  private static final Map<String, Tag> tagEntities = new ConcurrentHashMap<>();
  private final Logger LOG = LoggerFactory.getLogger(getClass());
  private FluxSink<Product> productsStream;
  private final ConnectableFlux<Product> productPublisher;

  public InMemRepository() {
    // Seed data for development purpose, real application must use database
    Faker faker = new Faker();
    IntStream.range(0, faker.number().numberBetween(20, 50)).forEach(number -> {
      String tag = faker.book().genre();
      tagEntities
          .putIfAbsent(tag, Tag.newBuilder().id(UUID.randomUUID().toString()).name(tag).build());
    });
    IntStream.range(0, faker.number().numberBetween(4, 20)).forEach(number -> {
      String id = String.format("a1s2d3f4-%d", number);
      String title = faker.book().title();
      List<Tag> tags = tagEntities.entrySet().stream()
          .filter(t -> t.getKey().startsWith(faker.book().genre().substring(0, 1)))
          .map(Entry::getValue).collect(toList());
      if (tags.isEmpty()) {
        tags.add(tagEntities.entrySet().stream().findAny().get().getValue());
      }
      Product product = Product.newBuilder().id(id).name(title)
          .description(faker.lorem().sentence()).count(faker.number().numberBetween(10, 100))
          .price(BigDecimal.valueOf(faker.number().randomDigitNotZero()))
          .imageUrl(String.format("/images/%s.jpeg", title.replace(" ", "")))
          .tags(tags).build();
      productEntities.put(id, product);
    });
    LOG.info("Seed Data: \n{}", productEntities);
    Sinks.many().multicast().onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);
    Flux<Product> publisher = Flux.create(emitter -> {
      productsStream = emitter;
    });
    productPublisher = publisher.publish();
    productPublisher.connect();
  }

  @Override
  public Product getProduct(String id) {
    if (Strings.isBlank(id)) {
      throw new RuntimeException("Invalid Product ID.");
    }
    Product product = productEntities.get(id);
    if (Objects.isNull(product)) {
      throw new RuntimeException("Product not found.");
    }
    return product;
  }

  @Override
  public List<Product> getProducts() {
    return new ArrayList<>(productEntities.values());
  }

  @Override
  public Map<String, List<Tag>> getProductTagMappings(List<String> productIds) {
    return productEntities.entrySet().stream().filter(e -> productIds.contains(e.getKey()))
        .collect(toMap(Entry::getKey, e -> e.getValue().getTags()));
  }

  @Override
  public Product addTags(String productId, List<TagInput> tags) {
    LOG.info("Argument productId: {}", productId);
    LOG.info("Argument tag: {}", tags);
    if (Strings.isBlank(productId)) {
      throw new RuntimeException("Invalid Product ID.");
    }
    Product product = productEntities.get(productId);
    if (Objects.isNull(product)) {
      throw new RuntimeException("Product not found.");
    }
    if (tags != null && !tags.isEmpty()) {
      List<String> newTags = tags.stream().map(TagInput::getName).toList();
      List<String> existingTags = product.getTags().stream().map(Tag::getName).toList();
      newTags.forEach(nt -> {
        if (!existingTags.contains(nt)) {
          product.getTags()
              .add(Tag.newBuilder().id(UUID.randomUUID().toString()).name(nt).build());
        }
      });
      productEntities.put(product.getId(), product);
    }
    return product;
  }

  @Override
  public Product addQuantity(String productId, int qty) {
    LOG.info("Argument productId: {}", productId);
    LOG.info("Argument qty: {}", qty);
    if (Strings.isBlank(productId)) {
      throw new RuntimeException("Invalid Product ID.");
    }
    if (qty < 1) {
      throw new RuntimeException("Quantity argument can't be less than one");
    }
    Product product = productEntities.get(productId);
    if (Objects.isNull(product)) {
      throw new RuntimeException("Product not found.");
    }
    product.setCount(product.getCount() + qty);
    productEntities.put(product.getId(), product);
    productsStream.next(product);
    LOG.info("Updated qty in product: " + product);
    return product;
  }

  public Publisher<Product> getProductPublisher() {
    return productPublisher;
  }
}
