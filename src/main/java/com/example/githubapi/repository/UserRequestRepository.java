package com.example.githubapi.repository;

import com.example.githubapi.entity.UserRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRequestRepository extends JpaRepository<UserRequestEntity, String> {

    UserRequestEntity findByLogin(String login);
}
