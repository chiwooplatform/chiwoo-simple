package org.chiwooplatform.simple.core.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;

@ImportAutoConfiguration(classes = {
    FreeMarkerAutoConfiguration.class,
    DataSourceAutoConfiguration.class,
    MybatisAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class })
@SpringBootConfiguration
@ComponentScan(basePackages = { "tool.config" })
@MapperScan("tool.dam.mapper")
public class CodeGenApplication {
}
