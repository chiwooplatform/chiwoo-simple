package org.chiwooplatform.simple.core.config;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import org.chiwooplatform.context.Constants;
import org.chiwooplatform.web.mvc.supports.ParameterMapMethodArgumentResolver;
import org.chiwooplatform.web.mvc.supports.TransactionLoggingFilter;
import org.chiwooplatform.web.supports.RequestValidator;

@Configuration
@ComponentScan(basePackages = { "org.chiwooplatform.web.mvc.supports", "org.chiwooplatform.simple.rest" })
public class MvcConfiguration
    extends WebMvcConfigurerAdapter {

    @Autowired
    private MessageSource messageSource;

    @Bean
    public LocaleResolver localeResolver() {
        final CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale( Locale.US );
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        final LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName( Constants.LANGUAGE );
        return localeChangeInterceptor;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean localValidator = new LocalValidatorFactoryBean();
        localValidator.setValidationMessageSource( messageSource );
        return localValidator;
    }

    @Bean
    public RequestValidator requestValidator() {
        RequestValidator requestValidator = new RequestValidator();
        requestValidator.setLocalValidatorFactory( localValidatorFactoryBean() );
        return requestValidator;
    }

    @Bean
    public FilterRegistrationBean transactionLoggingFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean( new TransactionLoggingFilter() );
        return registrationBean;
    }

    public void addArgumentResolvers( List<HandlerMethodArgumentResolver> argumentResolvers ) {
        ParameterMapMethodArgumentResolver parameterArgumentResolver = new ParameterMapMethodArgumentResolver();
        argumentResolvers.add( parameterArgumentResolver );
    }

    @Override
    public void addInterceptors( InterceptorRegistry registry ) {
        registry.addInterceptor( localeChangeInterceptor() );
    }

    @Override
    public Validator getValidator() {
        return localValidatorFactoryBean();
    }
}