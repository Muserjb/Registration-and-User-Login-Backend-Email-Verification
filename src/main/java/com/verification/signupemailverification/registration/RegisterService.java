package com.verification.signupemailverification.registration;

import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    public String register(RegistrationRequest request) {
        return "works";
    }
}
