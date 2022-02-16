package io.github.jithset.hibernatepsql;

import io.github.jithset.hibernatepsql.domains.Student;
import io.github.jithset.hibernatepsql.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernatePsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatePsqlApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student s1 = new Student("Jithin", "Set", 26, "jithin@gmail.com");
			studentRepository.save(s1);
		};
	}

}
