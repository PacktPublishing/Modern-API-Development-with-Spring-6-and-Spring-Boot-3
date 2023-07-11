package com.packt.modern.api.service;

import com.packt.modern.api.entity.CardEntity;
import com.packt.modern.api.model.AddCardReq;
import jakarta.validation.Valid;
import java.util.Optional;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public interface CardService {
  void deleteCardById(String id);
  Iterable<CardEntity> getAllCards();
  Optional<CardEntity> getCardById(String id);
  Optional<CardEntity> registerCard(@Valid AddCardReq addCardReq);
}
