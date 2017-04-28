package org.chiwooplatform.simple.core.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.test.context.junit4.SpringRunner;

import org.chiwooplatform.context.Constants;
import org.chiwooplatform.context.supports.PathMatchingReloadableResourceMessageSource;
import org.chiwooplatform.simple.core.config.MessageConfiguration.MessageSourceConfiguration;
import org.junit.runner.RunWith;

@Import({ MessageSourceConfiguration.class })
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageConfiguration {

    @Configuration
    static class MessageSourceConfiguration {

        @Bean
        public MessageSource messageSource() {
            final PathMatchingReloadableResourceMessageSource messageSource = new PathMatchingReloadableResourceMessageSource();
            messageSource.setBasenames( "classpath*:i18n/messages", "classpath*:i18n/validations/*" );
            messageSource.setDefaultEncoding( Constants.DEFAULT_CHARSET );
            messageSource.setCacheSeconds( 10 ); //reload messages every 10 seconds
            return messageSource;
        }

        @Bean
        public MessageSourceAccessor messageAccessor() {
            final MessageSourceAccessor messageAccessor = new MessageSourceAccessor( messageSource() );
            return messageAccessor;
        }
    }
}
