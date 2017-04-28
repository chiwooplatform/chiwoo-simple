package org.chiwooplatform.simple.core.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Import;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;

@SpringBootConfiguration
@Import({ MybatisConfiguration.class })
@ImportAutoConfiguration(classes = {
    DataSourceAutoConfiguration.class,
    MybatisAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class })
public class MybatisApplication {
}
