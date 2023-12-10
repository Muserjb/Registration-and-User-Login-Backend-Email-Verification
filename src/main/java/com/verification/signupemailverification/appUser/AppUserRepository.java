package com.verification.signupemailverification.appUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
