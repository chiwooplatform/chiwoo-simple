package org.chiwooplatform.simple;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableAutoConfiguration
//@Import({ PropertyPlaceholderConfig.class, RestTemplateConfiguration.class, MultipartConfiguration.class, MessageSourceConfiguration.class })
public class WebMvcTestConfiguration
    extends WebMvcConfigurerAdapter {
}
