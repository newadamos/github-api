package com.example.githubapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private Timestamp createdAt;
    private float calculations;
}
