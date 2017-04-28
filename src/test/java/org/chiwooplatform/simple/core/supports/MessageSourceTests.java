package org.chiwooplatform.simple.core.supports;

import java.util.Locale;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import org.chiwooplatform.simple.AbstractTests;
import org.chiwooplatform.simple.core.config.MessageConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;

@ContextConfiguration(classes = { MessageConfiguration.class })
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageSourceTests
    extends AbstractTests {

    @Autowired
    private MessageSourceAccessor messageAccessor;

    @Test
    public void testMessage()
        throws Exception {
        logger.info( "{}", messageAccessor );
        logger.info( "{}", messageAccessor.getMessage( "application.id", Locale.getDefault( Category.DISPLAY ) ) );
        logger.info( "{}", messageAccessor.getMessage( "application.id", "NotFound", Locale.US ) );
        logger.info( "{}", messageAccessor.getMessage( "application.id", "NotFound", Locale.KOREA ) );
    }
}
