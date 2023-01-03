package com.packt.modern.api.service;

import com.packt.modern.api.entity.AddressEntity;
import com.packt.modern.api.entity.CardEntity;
import com.packt.modern.api.entity.UserEntity;
import java.util.Optional;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public interface UserService {
  void deleteCustomerById(String id);
  Optional<Iterable<AddressEntity>> getAddressesByCustomerId(String id);
  Iterable<UserEntity> getAllCustomers();
  Optional<CardEntity> getCardByCustomerId(String id);
  Optional<UserEntity> getCustomerById(String id);
}
