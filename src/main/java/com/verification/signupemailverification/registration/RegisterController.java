package com.verification.signupemailverification.registration;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/registration")
public class RegisterController {

    private final RegisterService registerService;


    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return  registerService.register(request);
    }
}
