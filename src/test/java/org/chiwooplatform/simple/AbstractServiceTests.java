package org.chiwooplatform.simple;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.chiwooplatform.simple.core.config.ServiceApplication;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public abstract class AbstractServiceTests {

    protected final Logger logger = LoggerFactory.getLogger( this.getClass() );

    private final Integer AUTH_USER_ID = -100001;

    protected Integer userid() {
        return this.AUTH_USER_ID;
    }
}
