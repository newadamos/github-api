package com.example.githubapi.api;

import com.example.githubapi.dto.UserDTO;
import com.example.githubapi.service.GithubUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class GithubUserController {

    private final GithubUserService service;

    @GetMapping("/users/{login}")
    public ResponseEntity<UserDTO> getInfoAboutUser(@PathVariable("login") String login) {

        return ResponseEntity.ok(service.getInfoAboutTheUser(login));
    }
}
