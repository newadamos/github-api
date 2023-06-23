package com.example.githubapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public record GithubResponse(int id, String login, String name, String type,
                             @JsonProperty("avatar_url") String avatarUrl,
                             @JsonProperty("created_at") Timestamp createdAt, int followers,
                             @JsonProperty("public_repos") int publicRepos) {
}
