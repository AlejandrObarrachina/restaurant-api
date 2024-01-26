package com.restaurantapi.restaurantcrud.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configurable
@Configuration
public class EntityManagerFactoryConfig {
    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        return new LocalSessionFactoryBean();
    }
}
