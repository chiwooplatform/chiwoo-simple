package org.chiwooplatform.simple.rest;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.chiwooplatform.context.ContextHolder;
import org.chiwooplatform.context.annotation.Loggable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Loggable
@RestController
public class HelloController {

    protected static final String BASE_URI = "/home";

    protected final Logger logger = LoggerFactory.getLogger( this.getClass() );

    /**
     * Query common codes.
     *
     * @param param Query parameters
     * @param token Authentication token value
     * @return ResponseMessage conatains codes
     */
    @RequestMapping(value = BASE_URI + "/params", method = RequestMethod.GET, consumes = {
        MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> params( @RequestParam Map<String, Object> param )
        throws Exception {
        param.put( "tXID", ContextHolder.tXID() );
        param.put( "userseq", ContextHolder.userseq() );
        param.put( "principal", ContextHolder.principal() );
        logger.debug( "param: {}", param );
        return new ResponseEntity<>( param, HttpStatus.OK );
    }
}
