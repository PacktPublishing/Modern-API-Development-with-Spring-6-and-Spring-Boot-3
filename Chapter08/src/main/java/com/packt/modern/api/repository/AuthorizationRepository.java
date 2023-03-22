package com.packt.modern.api.repository;

import com.packt.modern.api.entity.AuthorizationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter08 - Modern API Development with Spring and Spring Boot Ed 2
 */
public interface AuthorizationRepository extends CrudRepository<AuthorizationEntity, UUID> {}
