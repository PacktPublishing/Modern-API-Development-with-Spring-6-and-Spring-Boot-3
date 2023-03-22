package com.packt.modern.api.repository;

import com.packt.modern.api.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter09 - Modern API Development with Spring and Spring Boot Ed 2
 */
public interface CardRepository extends CrudRepository<CardEntity, UUID> {}
