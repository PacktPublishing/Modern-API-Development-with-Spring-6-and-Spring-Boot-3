package com.packt.modern.api.repository;

import com.packt.modern.api.entity.UserTokenEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter06 - Modern API Development with Spring and Spring Boot Ed 2
 */
public interface UserTokenRepository extends CrudRepository<UserTokenEntity, UUID> {

  Optional<UserTokenEntity> findByRefreshToken(String refreshToken);

  Optional<UserTokenEntity> deleteByUserId(UUID userId);
}
