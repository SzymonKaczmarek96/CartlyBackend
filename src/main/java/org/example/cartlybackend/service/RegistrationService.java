package org.example.cartlybackend.service;

import org.example.cartlybackend.domain.Registration;
import org.example.cartlybackend.excpetion.InvalidEmailOrPasswordException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class RegistrationService {

    private final UserMockService userMockService;

    public RegistrationService(UserMockService userMockService) {
        this.userMockService = userMockService;
    }

    public void registerUser(Registration registration) {

        if(!isValidEmail(registration.getEmail()) && !isValidPassword(registration.getPassword())){
            throw new InvalidEmailOrPasswordException("Invalid email or password");
        }
//        if(userMockService.isEmailExisting(registration.getEmail())){
//            throw new UserAlreadyExistsException("User already exists");
//        }
        createNewUser(registration);
    }

    private void createNewUser(Registration registration){
        userMockService.createUser(registration);
    }

    private boolean isValidEmail(String email) {
        if(email == null || email.isEmpty()){
            return false;
        }
        String trimmedEmail = email.trim();

        return Pattern.compile("^[A-Za-z0-9+._%\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,}$")
                .matcher(trimmedEmail)
                .matches();
    }

    private boolean isValidPassword(String password) {
        if(password == null || password.isEmpty()){
            return false;
        }
        String trimmedPassword = password.trim();
        return Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?]).{8,}$")
                .matcher(trimmedPassword)
                .matches();
    }

}
