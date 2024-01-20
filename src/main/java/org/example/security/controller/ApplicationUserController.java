package org.example.security.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.security.model.ApplicationUser;
import org.example.security.service.ApplicationUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class ApplicationUserController {

    private final ApplicationUserService applicationUserService;

    @PostMapping
    public ApplicationUser create(@RequestBody ApplicationUser userRequest) {
        log.info("Creating user {}", userRequest.getUsername());
        return applicationUserService.create(userRequest);
    }

}
