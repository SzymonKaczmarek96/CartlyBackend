package org.example.cartlybackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record LoginRequest(
        @JsonProperty("username")
        String username,
        @JsonProperty("password")
        String password
) implements Serializable {
}
