package org.example.cartlybackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.cartlybackend.dto.RegistrationRequest;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Registration{
  private String email;
  private String password;
  private String firstName;
  private String lastName;
}