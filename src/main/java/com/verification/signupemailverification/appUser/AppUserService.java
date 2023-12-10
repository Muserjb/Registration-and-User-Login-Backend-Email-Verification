package com.verification.signupemailverification.appUser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final String USER_NOT_FOUND = "User with %s not found";
    private BCryptPasswordEncoder passwordEncoder;

    private final AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email))
        );
    }

    public String signUpUser(User appUser){
        boolean userExist = repository
                .findByEmail(appUser.getEmail())
                .isPresent();
        if ( userExist ){
            throw new IllegalStateException("email already exists");
        }
        String encodePassword = passwordEncoder.encode(appUser.getEmail());
        appUser.setPassword(encodePassword);
        repository.save(appUser);

        // todo : send configuration token


        return "it works";
    }
}
