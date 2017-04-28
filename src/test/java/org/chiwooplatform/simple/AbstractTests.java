package org.chiwooplatform.simple;

import org.chiwooplatform.context.Constants;
import org.chiwooplatform.context.supports.UUIDGenerator;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public abstract class AbstractTests {

    protected final Logger logger = LoggerFactory.getLogger( this.getClass() );

    private final Integer AUTH_USER_ID = -100001;

    protected Integer userid() {
        return this.AUTH_USER_ID;
    }

    @Before
    public void setMDC() {
        MDC.put( Constants.TXID, UUIDGenerator.getTXID() );
        logger.info( "MDC.put TXID" );
    }

    @After
    public void removeMDC() {
        MDC.remove( Constants.TXID );
        logger.info( "MDC.remove TXID" );
    }
}
