package org.chiwooplatform.simple.rest.iam;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.chiwooplatform.context.annotation.Loggable;
import org.chiwooplatform.security.supports.mock.MockUser;
import org.chiwooplatform.security.supports.mock.MockUserDetailsManager;
import org.chiwooplatform.simple.message.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Loggable
@RestController
public class AuthenticationController {

    protected static final String BASE_URI = "/public/auths";

    protected final Logger logger = LoggerFactory.getLogger( this.getClass() );

    @Autowired
    private MockUserDetailsManager userDetailsManager;

    @RequestMapping(value = BASE_URI, method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> getAllUsers( @RequestParam Map<String, Object> param, HttpServletRequest request ) {
        ResponseMessage response = new ResponseMessage();
        Map<String, MockUser> authUsers = userDetailsManager.getAllUsers();
        response.setAuthUsers( authUsers );
        return new ResponseEntity<>( response, HttpStatus.OK );
    }
}
