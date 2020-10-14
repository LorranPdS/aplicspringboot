package projeto.aplicspringboot.aplicspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "projeto.aplicspringboot.model")
@ComponentScan(basePackages = "projeto.*")
@EnableJpaRepositories(basePackages = "projeto.aplicspringboot.repository")
@EnableTransactionManagement
public class AplicspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicspringbootApplication.class, args);
	}

}
