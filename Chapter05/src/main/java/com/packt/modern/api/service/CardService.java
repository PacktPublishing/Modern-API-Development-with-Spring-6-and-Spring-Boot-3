package com.packt.modern.api.service;

import com.packt.modern.api.entity.CardEntity;
import com.packt.modern.api.model.AddCardReq;
import java.util.Optional;
import java.util.UUID;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter05 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public interface CardService {
  Mono<Void> deleteCardById(String id);
  Mono<Void> deleteCardById(UUID id);
  Flux<CardEntity> getAllCards();
  Mono<CardEntity> getCardById(String id);
  Mono<CardEntity> registerCard(@Valid Mono<AddCardReq> addCardReq);
  CardEntity toEntity(AddCardReq model);
}
