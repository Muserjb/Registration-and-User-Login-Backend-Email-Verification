package com.verification.signupemailverification.registration;

import com.verification.signupemailverification.appUser.AppUserRole;
import com.verification.signupemailverification.appUser.AppUserService;
import com.verification.signupemailverification.appUser.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public RegisterService(AppUserService appUserService, EmailValidator emailValidator) {
        this.appUserService = appUserService;
        this.emailValidator = emailValidator;
    }

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if ( !isValidEmail ){
            throw new IllegalAccessError("email is not valid");
        }
        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER);

        return appUserService.signUpUser(user);
    }
}
