package org.example.cartlybackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record RefreshRequest(
        @JsonProperty("refresh_token")
        String refreshToken
) implements Serializable {

}
