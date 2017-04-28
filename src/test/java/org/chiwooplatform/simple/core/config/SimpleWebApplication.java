package org.chiwooplatform.simple.core.config;

import org.springframework.boot.actuate.autoconfigure.AuditAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.HealthIndicatorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricExportAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.TraceRepositoryAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.TraceWebFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;

@SpringBootApplication(exclude = {
    EmbeddedServletContainerAutoConfiguration.class,
    AuditAutoConfiguration.class,
    HealthIndicatorAutoConfiguration.class,
    MetricFilterAutoConfiguration.class,
    MetricExportAutoConfiguration.class,
    SpringDataWebAutoConfiguration.class,
    TraceWebFilterAutoConfiguration.class,
    TraceRepositoryAutoConfiguration.class,
    FreeMarkerAutoConfiguration.class,
    SessionAutoConfiguration.class,
    ValidationAutoConfiguration.class,
    MessageSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class })
public class SimpleWebApplication {
}
