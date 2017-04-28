package org.chiwooplatform.simple;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import org.chiwooplatform.simple.core.config.MybatisApplication;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public abstract class AbstractMapperTests<T> {

    @ClassRule
    public static OutputCapture capture = new OutputCapture();

    protected final Logger logger = LoggerFactory.getLogger( this.getClass() );

    private final Integer AUTH_USER_ID = -100001;

    protected Integer userid() {
        return this.AUTH_USER_ID;
    }

    abstract protected T model();
}
