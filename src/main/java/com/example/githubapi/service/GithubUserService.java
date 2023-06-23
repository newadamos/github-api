package com.example.githubapi.service;

import com.example.githubapi.dto.GithubResponse;
import com.example.githubapi.dto.UserDTO;
import com.example.githubapi.entity.UserRequestEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class GithubUserService {

    private final UserRequestService userRequestService;
    private final RestTemplate restTemplate;
    private static final String API_URL = "https://api.github.com/users/{login}";

    public UserDTO getInfoAboutTheUser(String login) {

        GithubResponse githubResponse = restTemplate.getForObject(API_URL, GithubResponse.class, login);
        adjustUserRequestCount(login);
        return mapGHResponseToUserDTO(githubResponse, getCalculations(githubResponse));
    }

    private float getCalculations(GithubResponse githubResponse) {
        return (float) 6 / githubResponse.followers() * (2 + githubResponse.publicRepos());
    }

    private void adjustUserRequestCount(String login) {
        if (userRequestService.isUserExistsByLogin(login)) {
            userRequestService.addOneRequestCountForUser(login);
        } else {
            userRequestService.createNewUserData(new UserRequestEntity(login, 1));
        }
    }

    private UserDTO mapGHResponseToUserDTO(GithubResponse response, float calculations) {

        return new UserDTO(response.id(), response.login(), response.name(), response.type(), response.avatarUrl(), response.createdAt(), calculations);
    }
}
