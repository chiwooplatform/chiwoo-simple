package org.chiwooplatform.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.chiwooplatform.context.Constants;
import org.chiwooplatform.context.supports.ConverterUtils;
import org.chiwooplatform.simple.core.config.SimpleWebApplication;
import org.chiwooplatform.simple.message.RequestMessage;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimpleWebApplication.class)
@AutoConfigureMockMvc
public abstract class AbstractControllerTests<T> {

    static private ObjectMapper OBJECTMAPPER;

    protected final Logger logger = LoggerFactory.getLogger( this.getClass() );

    private final Integer AUTH_USER_ID = -100001;

    protected Integer userid() {
        return this.AUTH_USER_ID;
    }

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private MappingJackson2HttpMessageConverter jsonConverter;
    
    abstract protected T model(); 

    protected RequestMessage requestMessage( Object target )
        throws Exception {
        RequestMessage message = new RequestMessage();
        ConverterUtils.setProperty( message, target );
        return message;
    }

    protected String requestBody( Object object )
        throws JsonProcessingException {
        return OBJECTMAPPER.writeValueAsString( object );
    }

    protected String mockMessage( Object object )
        throws Exception {
        String content = requestBody( requestMessage( object ) );
        return content;
    }

    protected final String token() {
        return token( USER.valueOf( "bob" ) );
    }

    protected final String token( final USER user ) {
        return user.token;
    }

    protected final String lang() {
        return Constants.LANGUAGE;
    }

    @Before
    public void setUp() {
        logger.info( "jsonConverter: {}", jsonConverter );
        if ( jsonConverter != null && OBJECTMAPPER == null ) {
            OBJECTMAPPER = jsonConverter.getObjectMapper();
            OBJECTMAPPER.enable( SerializationFeature.INDENT_OUTPUT );
        }
    }

    protected enum USER {
                         bob("bob", "bc9dd4658e06498fb7917c12bac3f969"),
                         apple("apple", "9d787279cd3d48fa863c8dfdec255b25"),
                         banana("banana", "ccabe36b77784631b2caf30552d313e8"),
                         kssy("kssy", "d107406bab4b4daeb2e85f75f2a22aa2"),;

        String name;

        String token;

        USER( String name, String token ) {
            this.name = name;
            this.token = token;
        }

        public String user() {
            return this.name;
        }

        public String token() {
            return this.token;
        }
    }
}
