package nes.welcome2church;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Welcome2churchApplication {

    public static void main(String[] args) {
        SpringApplication.run(Welcome2churchApplication.class, args);
    }

}
