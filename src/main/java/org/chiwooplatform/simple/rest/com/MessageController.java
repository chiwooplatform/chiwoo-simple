package org.chiwooplatform.simple.rest.com;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.chiwooplatform.context.annotation.Loggable;
import org.chiwooplatform.context.supports.LanMessage;
import org.chiwooplatform.simple.message.ResponseMessage;
import org.chiwooplatform.simple.service.CommonService;
import org.chiwooplatform.web.supports.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Loggable
@RestController
public class MessageController {

    protected static final String BASE_URI = "/com/messages";

    protected final Logger logger = LoggerFactory.getLogger( this.getClass() );

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = BASE_URI + "/{code}", method = RequestMethod.GET, consumes = {
        MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> get( @PathVariable(name = "code", required = false) String code,
                                  @RequestParam(name = "lang", defaultValue = "ko", required = false) String lang ) {
        LanMessage lanMessage = commonService.getMessage( code, lang );
        if ( lanMessage == null ) {
            throw WebUtils.notFoundException();
        }
        ResponseMessage response = new ResponseMessage();
        response.setLanMessage( lanMessage );
        return new ResponseEntity<>( response, HttpStatus.OK );
    }

    @RequestMapping(value = BASE_URI, method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> messages( @RequestParam(name = "lang", defaultValue = "ko", required = false) String lang,
                                       @RequestParam(name = "code", required = false) String code,
                                       HttpServletRequest request ) {
        ResponseMessage response = new ResponseMessage();
        final String pattern = ( code != null ? code + "*" : "*" );
        List<LanMessage> lanMessages = commonService.getMessages( pattern, lang );
        response.setLanMessages( lanMessages );
        return new ResponseEntity<>( response, HttpStatus.OK );
    }
}
