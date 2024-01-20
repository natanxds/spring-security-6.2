package org.example.security.service.Impl;


import org.example.security.repository.ApplicationUserRepository;
import org.example.security.service.ApplicationUserService;
import org.example.security.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    ApplicationUserRepository userRepository;

    @Override
    public ApplicationUser create(ApplicationUser user) {
        ApplicationUser existUser = userRepository.findByUsername(user.getUsername());

        if(existUser != null){
            throw new Error("User already exists!");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));
        ApplicationUser createdUser = userRepository.save(user);

        return createdUser;
    }
}
