package projeto.aplicspringboot.aplicspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = "projeto.aplicspringboot.model")
@ComponentScan(basePackages = "projeto.*")
@EnableJpaRepositories(basePackages = "projeto.aplicspringboot.repository")
@EnableTransactionManagement
@EnableWebMvc
public class AplicspringbootApplication implements WebMvcConfigurer {

	/*Esse EnableWebMvc serve para habilitarmos todos os 
	 * recursos de MVC para ele poder redirecionar para nossa tela*/
	
	public static void main(String[] args) {
		SpringApplication.run(AplicspringbootApplication.class, args);
		
		/*
		 * O código abaixo é para criar senhas criptografadas. Quando for utilizar ele,
		 * comente todas as anotações acima, execute o código e será impressa
		 * a senha criptografada. A seguir, copie a senha e cole no password
		 * da classe WebConfigSecurity
		 
		 
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCriptografada = encoder.encode("123");
		System.out.println(senhaCriptografada); */
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// Abaixo mapeamos e redirecionamos para a tela de login
		registry.addViewController("/login").setViewName("/login");
		registry.setOrder(Ordered.LOWEST_PRECEDENCE);
	}

}