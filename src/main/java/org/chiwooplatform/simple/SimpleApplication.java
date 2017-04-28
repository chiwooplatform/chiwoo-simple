package org.chiwooplatform.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;

@SpringBootApplication(exclude = {
    SessionAutoConfiguration.class,
    ValidationAutoConfiguration.class,
    MessageSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class })
public class SimpleApplication {

    public static void main( String[] args ) {
        SpringApplication.run( SimpleApplication.class, args );
    }
}
