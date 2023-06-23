package com.example.githubapi.service;

import com.example.githubapi.entity.UserRequestEntity;
import com.example.githubapi.repository.UserRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRequestService {

    private final UserRequestRepository repository;

    public boolean isUserExistsByLogin(String login) {

        return repository.existsById(login);
    }

    public void createNewUserData(UserRequestEntity userRequestEntity) {

        repository.save(userRequestEntity);
    }

    public void addOneRequestCountForUser(String login) {

        UserRequestEntity userRequestEntity = repository.findByLogin(login);
        int requestCount = userRequestEntity.getRequestCount();
        userRequestEntity.setRequestCount(requestCount + 1);
        repository.save(userRequestEntity);
    }
}
