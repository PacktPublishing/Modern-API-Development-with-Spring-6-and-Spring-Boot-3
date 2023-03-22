package com.packt.modern.api.repository;

import com.packt.modern.api.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter08 - Modern API Development with Spring and Spring Boot Ed 2
 */
public interface UserRepository extends CrudRepository<UserEntity, UUID> {

  Optional<UserEntity> findByUsername(String username);

  @Query(
      value =
          "select count(u.*) from ecomm.\"user\" u where u.username = :username or u.email = :email",
      nativeQuery = true)
  Integer findByUsernameOrEmail(String username, String email);
}
