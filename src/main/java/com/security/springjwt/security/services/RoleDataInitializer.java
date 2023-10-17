package com.security.springjwt.security.services;
import com.security.springjwt.models.ERole;
import com.security.springjwt.models.Role;
import com.security.springjwt.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class RoleDataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository; // Assuming you have a RoleRepository

    @Override
    public void run(String... args) throws Exception {
        // Check if roles exist
        if (!roleRepository.existsByName(ERole.ROLE_USER)) {
            roleRepository.save(new Role(ERole.ROLE_USER));
        }
        if (!roleRepository.existsByName(ERole.ROLE_MODERATOR)) {
            roleRepository.save(new Role(ERole.ROLE_MODERATOR));
        }
        if (!roleRepository.existsByName(ERole.ROLE_ADMIN)) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }
    }
}
