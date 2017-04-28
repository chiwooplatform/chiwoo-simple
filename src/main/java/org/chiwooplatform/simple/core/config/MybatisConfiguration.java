package org.chiwooplatform.simple.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.chiwooplatform.mybatis.dialect.MariaDBDialect;
import org.chiwooplatform.mybatis.plugin.LoggingInterceptor;
import org.chiwooplatform.mybatis.plugin.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = { "org.chiwooplatform.simple.dam.mapper" })
public class MybatisConfiguration {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        final PaginationInterceptor interceptor = new PaginationInterceptor();
        interceptor.setDialect( new MariaDBDialect() );
        return interceptor;
    }

    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }
}
