package org.example.security.repository;

import org.example.security.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);

    @Query("SELECT u FROM ApplicationUser u JOIN FETCH u.roles where u.username = :username")
    ApplicationUser findByUsernameFetchRoles(@Param("username") String username);
}
