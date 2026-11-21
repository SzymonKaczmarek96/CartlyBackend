package org.example.cartlybackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.cartlybackend.domain.Registration;

import java.io.Serializable;

public record RegistrationRequest(
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("email")
        String email,
        @JsonProperty("password")
        String password
) implements Serializable {

        public Registration toDomain(){
                return new Registration(email, password, firstName, lastName);
        }
}
