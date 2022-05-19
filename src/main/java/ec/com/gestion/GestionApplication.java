package ec.com.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * Spring boot configuration class.
 */
@EntityScan(basePackages = "ec.com.gestion")
@SpringBootApplication
@EnableTransactionManagement
public class GestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionApplication.class, args);
	}

	@Bean
	@Autowired
	public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory e){
		JpaTransactionManager jpaTM = new JpaTransactionManager();
		jpaTM.setEntityManagerFactory(e);
		return  jpaTM;
	}

}
