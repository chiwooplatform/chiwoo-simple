package org.chiwooplatform.simple.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.jdbc.core.JdbcTemplate;

import org.chiwooplatform.context.supports.JdbcTemplateMessageSource;
import org.chiwooplatform.context.supports.LoggingAspect;
import org.chiwooplatform.context.supports.ThrowableHandlerAspect;

@Import({ MybatisConfiguration.class, SecurityConfiguration.class })
@Configuration
public class AppConfiguration {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public MessageSource messageSource() {
        final JdbcTemplateMessageSource messageSource = new JdbcTemplateMessageSource();
        messageSource.setCacheSeconds( 30 ); // reload messages every 30 seconds
        messageSource.setJdbcTemplate( jdbcTemplate );
        return messageSource;
    }

    @Bean
    public MessageSourceAccessor messageAccessor() {
        final MessageSourceAccessor messageAccessor = new MessageSourceAccessor( messageSource() );
        return messageAccessor;
    }

    @Bean
    public LoggingAspect loggingAspect() {
        LoggingAspect loggingAspect = new LoggingAspect();
        return loggingAspect;
    }

    @Bean
    public ThrowableHandlerAspect throwableHandlerAspect() {
        ThrowableHandlerAspect throwableHandlerAspect = new ThrowableHandlerAspect();
        return throwableHandlerAspect;
    }
}
