package com.company.secure;

import com.company.secure.models.CustomUser;
import com.company.secure.repositories.CustomUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureApplication.class, args);
	}
        
    @Bean
    public CommandLineRunner run(CustomUserRepository userRepository, PasswordEncoder passwordEncoder) throws Exception {
        return (String[] args) -> {
            CustomUser user1 = new CustomUser("admin", passwordEncoder.encode("admin"), true, "Admin User" ,"admin@domain.com");
            CustomUser user2 = new CustomUser("user", passwordEncoder.encode("user"), true, "Simple User" ,"user@domain.com");
            CustomUser user3 = new CustomUser("root", passwordEncoder.encode("root"), true, "SuperAdmin User" ,"root@domain.com");
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.findAll().forEach(user -> System.out.println(user));
        };
    }

}
