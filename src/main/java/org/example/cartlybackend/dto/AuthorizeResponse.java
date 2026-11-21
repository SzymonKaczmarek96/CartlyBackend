package org.example.cartlybackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorizeResponse(
        @JsonProperty("message")
        String message,
        @JsonProperty("is_authorized")
        boolean isAuthorized
) {
}
