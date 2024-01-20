package org.example.security;


import org.example.security.model.Role;
import org.example.security.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository) {
        return args -> {
            if(roleRepository.count() != 4){

            roleRepository.save(new Role(1L,"PRODUCT_INSERT"));
            roleRepository.save(new Role(2L, "PRODUCT_DELETE"));
            roleRepository.save(new Role(3L, "PRODUCT_UPDATE"));
            roleRepository.save(new Role(4L, "PRODUCT_SELECT"));
            }
        };
    }

}
