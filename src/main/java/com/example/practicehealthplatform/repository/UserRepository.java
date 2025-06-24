package com.example.practicehealthplatform.repository;

import com.example.practicehealthplatform.model.UserEntity;
import com.example.practicehealthplatform.model.UserResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findByUserNameContaining(String userName);

    Optional<UserEntity> findByUserNumber(String userNumber);



    List<UserEntity> findByUserName(String userName);

}
