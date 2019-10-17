package pl.salon.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.salon.converters.CosmeticProcedureConverter;

import javax.persistence.EntityManagerFactory;

@Configuration
//ta adnotacja konfiguracyjna wyłącza componen scan
@ComponentScan(basePackages = {"pl.salon"}, excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        value = EnableWebMvc.class))
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.salon")
public class AppConfig extends WebMvcConfigurerAdapter {

    //zarządzanie encjami
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
        emf.setPersistenceUnitName("salonPU");
        return emf;
    }

    //zarządzanie tranzakcjami
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(emf);
        return transactionManager;
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public CosmeticProcedureConverter getCosmeticProcedureConverter() {
        return new CosmeticProcedureConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getCosmeticProcedureConverter());
    }
}