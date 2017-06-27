package org.chiwooplatform.simple.rest.com;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.chiwooplatform.context.Constants;
import org.chiwooplatform.context.ContextHolder;
import org.chiwooplatform.context.annotation.Loggable;
import org.chiwooplatform.context.supports.ConverterUtils;
import org.chiwooplatform.web.supports.RequestValidator;
import org.chiwooplatform.web.supports.WebUtils;
import org.chiwooplatform.simple.message.RequestMessage;
import org.chiwooplatform.simple.message.ResponseMessage;
import org.chiwooplatform.simple.model.com.Code;
import org.chiwooplatform.simple.service.CommonService;

/**
 * @author yourname <yourname@your.email>
 */
@Loggable
@RestController
public class CodeController {

    protected static final String BASE_URI = "/com/codes";

    protected final Logger logger = LoggerFactory.getLogger( this.getClass() );

    @Autowired
    private RequestValidator validator;

    @Autowired
    private CommonService commonService;

    /**
     * Get the 'code' data corresponding to the URI PathVariables.
     *
     * @param token is the Authentication token.
     * @param cdId is the URI path variable for identifying resource.
     * @param param is the Query parameters.
     * @return the ResponseMessage that is converted to JSON or XML messages.
     */
    @RequestMapping(value = BASE_URI + "/{cdId}", method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @PreAuthorize("hasPermission(#token, 'API_ComCode.get')")
    public ResponseEntity<?> get( @RequestHeader(Constants.AUTH_TOKEN) String token, @PathVariable("cdId") Integer cdId,
                                  @RequestParam Map<String, Object> param )
        throws Exception {
        // logger.debug( "tXID: {}, userno: {}, principal: {}", ContextHolder.tXID(), ContextHolder.userno(), ContextHolder.principal() );
        param.put( "cdId", cdId );
        ResponseMessage response = new ResponseMessage();
        Code code = commonService.getAtCodeMapper( param );
        if ( code == null ) {
            throw WebUtils.notFoundException();
        }
        response.setCode( code );
        return new ResponseEntity<>( response, HttpStatus.OK );
    }

    /**
     * 'code' data is newly registered.
     *
     * @param token is the Authentication token.
     * @param requestMessage It is contained 'code' data to register.
     * @param request is the HttpServletRequest.
     * @return the ResponseMessage that is converted to JSON or XML messages.
     */
    @RequestMapping(value = BASE_URI, method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @PreAuthorize("hasPermission(#token, 'API_ComCode.add')")
    public ResponseEntity<?> add( @RequestHeader(Constants.AUTH_TOKEN) String token,
                                  @RequestBody RequestMessage requestMessage, HttpServletRequest request ) {
        Code code = requestMessage.getCode();
        validator.validate( code );
        ResponseMessage response = new ResponseMessage();
        code.setRegisterId( ContextHolder.userno() ); // XXX 사용자 아이디 를 설정 
        commonService.addAtCodeMapper( code );
        response.setCode( code );
        return new ResponseEntity<>( response, HttpStatus.CREATED );
    }

    /**
     * Get the 'code' data corresponding to the query parameters condition.
     *
     * @param param is the Query parameters.
     * @param token is the Authentication token.
     * @return the ResponseMessage that is converted to JSON or XML messages.
     */
    @RequestMapping(value = BASE_URI + "/query", method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @PreAuthorize("hasPermission(#token, 'API_ComCode.query')")
    public ResponseEntity<?> query( @RequestHeader(Constants.AUTH_TOKEN) String token,
                                    @RequestParam Map<String, Object> param )
        throws Exception {
        ResponseMessage response = new ResponseMessage();
        List<Code> codes = ConverterUtils.toBeans( commonService.queryMapAtCodeMapper( param ), Code.class );
        response.setCodes( codes );
        return new ResponseEntity<>( response, HttpStatus.OK );
    }

    /**
     * Modify the 'code' information.
     *
     * @param token is the Authentication token.
     * @param requestMessage It is contained 'code' data to register.
     * @param request is the HttpServletRequest.
     * @return the ResponseMessage that is converted to JSON or XML messages.
     */
    @RequestMapping(value = BASE_URI + "/{cdId}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @PreAuthorize("hasPermission(#token, 'API_ComCode.modify')")
    public ResponseEntity<?> modify( @RequestHeader(Constants.AUTH_TOKEN) String token, @PathVariable("cdId") Integer cdId,
                                     @RequestBody RequestMessage requestMessage, HttpServletRequest request ) {
        Code code = requestMessage.getCode();
        validator.validate( code );
        ResponseMessage response = new ResponseMessage();
        code.setModifierId( ContextHolder.userno() ); 
        commonService.modifyAtCodeMapper( code );
        response.setCode( code );
        return new ResponseEntity<>( response, HttpStatus.OK );
    }

    /**
     * Remove the 'code' data corresponding to the URI PathVariables.
     *
     * @param token is the Authentication token.
     * @param cdId is the URI path variable for identifying resource.
     * @param param is the Query parameters.
     * @return the ResponseMessage that is converted to JSON or XML messages.
     */  
    @RequestMapping(value = BASE_URI + "/{cdId}", method = RequestMethod.DELETE, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @PreAuthorize("hasPermission(#token, 'API_ComCode.remove')")
    public ResponseEntity<?> remove( @RequestHeader(Constants.AUTH_TOKEN) String token, @PathVariable("cdId") Integer cdId,
                                     @RequestParam Map<String, Object> param ) {
        param.put( "cdId", cdId );
        commonService.removeAtCodeMapper( param );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }

    /**
     * Enable the 'code' data.
     *
     * @param token is the Authentication token.
     * @param requestMessage It is contained 'code' data to register.
     * @param request is the HttpServletRequest.
     * @return the ResponseMessage that is converted to JSON or XML messages.
     */
    @RequestMapping(value = BASE_URI + "/{cdId}/enable", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @PreAuthorize("hasPermission(#token, 'API_ComCode.enable')")
    public ResponseEntity<?> enable( @RequestHeader(Constants.AUTH_TOKEN) String token, @PathVariable("cdId") Integer cdId,
                                     @RequestParam Map<String, Object> param ) {
        param.put( "cdId", cdId );
        param.put( "modifierId", ContextHolder.userno() );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }

    /**
     * Disable the 'code' data.
     *
     * @param token is the Authentication token.
     * @param requestMessage It is contained 'code' data to register.
     * @param request is the HttpServletRequest.
     * @return the ResponseMessage that is converted to JSON or XML messages.
     */
    @RequestMapping(value = BASE_URI + "/{cdId}/disable", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @PreAuthorize("hasPermission(#token, 'API_ComCode.disable')")
    public ResponseEntity<?> disable( @RequestHeader(Constants.AUTH_TOKEN) String token, @PathVariable("cdId") Integer cdId,
                                      @RequestParam Map<String, Object> param ) {
        param.put( "cdId", cdId );
        param.put( "modifierId", ContextHolder.userno() ); 
        commonService.enableAtCodeMapper( param );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
}
