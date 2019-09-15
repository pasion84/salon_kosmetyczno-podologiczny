package pl.salon.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;

@Configuration
//ta adnotacja konfiguracyjna wyłącza componen scan
@ComponentScan(basePackages = {"pl.salon"}, excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        value = EnableWebMvc.class))
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.salon")
public class AppConfig {

    //zarządzanie encjami
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
        emf.setPersistenceUnitName("twitterPU");
        return emf;
    }

    //zarządzanie tranzakcjami
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(emf);
        return transactionManager;
    }
    //    validator
//    @Bean
//    public Validator validator() {
//        return new LocalValidatorFactoryBean();
//    }

}
