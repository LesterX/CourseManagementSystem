package model;

import repositories.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@SpringBootApplication
@ComponentScan("repositories")
@ComponentScan("model")
@ComponentScan("controller")
@EnableJpaRepositories("repositories")

public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    /*
    @Bean
    public CommandLineRunner demo(ProfessorRepository profRepo, CourseRepository courseRepo) {
        return (args) -> {
            profRepo.save(new Professor(1,"Yimin","Xu",75000));
            profRepo.save(new Professor(2,"Meimei","Han",90000));
            profRepo.save(new Professor(3,"Lei","Li",90000));
            profRepo.save(new Professor(4,"Yida","Xu"));
            profRepo.save(new Professor(5,"Dongmei","Ma",50000));

            log.info("Find all professors: ");
            log.info("--------------------------------------");

            for (Professor prof : profRepo.findAll()) {
                log.info(prof.toString());
            }
            log.info("");

            log.info("Find professors with last name Xu");
            log.info("--------------------------------------");

            profRepo.findByLastName("Xu").forEach(prof -> {
                log.info(prof.toString());
                log.info("");
            });

            log.info("");

            Professor xym = profRepo.findById(1);
            Professor hmm = profRepo.findById(2);

            courseRepo.save(new Course(11000,"CS1000",xym,"Mon 9:00-12:00"));
            courseRepo.save(new Course(11001,"CS1001",hmm,"Wed 9:00-12:00"));
            courseRepo.save(new Course(11002,"CS1002",hmm,"Mon 13:00-15:00"));
            courseRepo.save(new Course(11003,"CS1003",xym,"Fri 19:00-21:00"));        
            
            log.info("Find all courses");
            log.info("--------------------------------------");
            for (Course c : courseRepo.findAll()) {
                log.info(c.toString());
            }
            log.info("");
        };
    }
    */
}