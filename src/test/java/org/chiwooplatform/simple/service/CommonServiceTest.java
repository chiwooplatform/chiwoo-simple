package org.chiwooplatform.simple.service;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.chiwooplatform.simple.AbstractServiceTests;
import org.junit.Test;

@Transactional
public class CommonServiceTest
    extends AbstractServiceTests {

    @Autowired
    private CommonService service;

    @Test
    public void contextLoads() {
        logger.info( "{}", service );
        assertNotNull( service );
        assertThat( service, instanceOf( CommonService.class ) );
    }

    @Test
    public void ut1001_queryMapAtCodeMapper()
        throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put( "cdId", "1" );
        logger.info( "{}", service.getAtCodeMapper( param ) );
    }
}
