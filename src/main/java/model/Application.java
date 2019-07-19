package model;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@SpringBootApplication
@ComponentScan("model")
@EnableJpaRepositories("model")

public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(Repository repo) {
        return (args) -> {
            repo.save(new Professor("Yimin","Xu",75000));
            repo.save(new Professor("Meimei","Han",90000));
            repo.save(new Professor("Lei","Li",90000));
            repo.save(new Professor("Yida","Xu",80000));
            repo.save(new Professor("Dongmei","Ma",50000));

            log.info("Find all professors: ");
            log.info("--------------------------------------");

            for (Professor prof : repo.findAll()) {
                log.info(prof.toString());
            }
            log.info("");

            log.info("Find professors with last name Xu");
            log.info("--------------------------------------");

            repo.findByLastName("Xu").forEach(prof -> {
                log.info(prof.toString());
                log.info("");
            });

            log.info("");
        };
    }
}