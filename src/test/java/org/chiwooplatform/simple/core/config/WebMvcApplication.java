package org.chiwooplatform.simple.core.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.actuate.autoconfigure.ManagementServerPropertiesAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.security.BootGlobalAuthenticationConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;

@SpringBootConfiguration
@Import({ MybatisConfiguration.class, AppConfiguration.class })
@ImportAutoConfiguration(classes = {
    AopAutoConfiguration.class,
    BootGlobalAuthenticationConfiguration.class,
    HttpMessageConvertersAutoConfiguration.class,
    JacksonAutoConfiguration.class,
    ManagementServerPropertiesAutoConfiguration.class,
    MockMvcAutoConfiguration.class,
    SecurityAutoConfiguration.class,
    ManagementWebSecurityAutoConfiguration.class,
    RedisAutoConfiguration.class,
    DataSourceAutoConfiguration.class,
    JdbcTemplateAutoConfiguration.class,
    MybatisAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class })
@ComponentScan(basePackages = {
    "org.chiwooplatform.web.supports",
    "org.chiwooplatform.simple.service",
    "org.chiwooplatform.simple.rest" })
public class WebMvcApplication {
}
