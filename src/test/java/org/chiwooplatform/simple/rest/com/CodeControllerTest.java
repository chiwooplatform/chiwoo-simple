package org.chiwooplatform.simple.rest.com;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.ResultActions;

import org.chiwooplatform.context.Constants;
import org.chiwooplatform.simple.AbstractControllerTests;
import org.chiwooplatform.simple.model.com.Code;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles(profiles = { /* "local", "dev" */ })
public class CodeControllerTest
    extends AbstractControllerTests<Code> {

    private final Date CURRENT_TIMESTAMP = new Date();

    private Integer cdId = -999;

    protected Code model()
    {
        Code model = new Code();
        model.setCdId( this.cdId );
        model.setUpCdId( 10 );
        model.setCdVal( "cd_val" );
        model.setCdName( "cd_name" );
        model.setCdEngName( "cd_eng_name" );
        model.setDescr( "descr" );
        model.setUseYn( true );
        model.setOrdno( 1 );
        model.setExtVal( "ext_val" );
        model.setRegisterId( userid() );
        model.setRegDtm( CURRENT_TIMESTAMP );
        model.setModifierId( userid() );
        model.setUpdDtm( CURRENT_TIMESTAMP );
        return model;
    }

    @Test
    public void loaderTest() {
        logger.info( "mockMvc: {}", mockMvc );
        assertNotNull( mockMvc );
    }

    /**
     * {@link CodeController#add}
     * 
     * @throws Exception
     */
    @Test
    public void ut1001_add()
        throws Exception {
        Code code = model();
        // code.setCdVal( "changed_cd_val" );
        String content = mockMessage( code );
        logger.debug( "content: {}", content );
        final String uri = CodeController.BASE_URI;
        ResultActions actions = mockMvc.perform( post( uri ).contentType( MediaType.APPLICATION_JSON )
                                                            .header( Constants.AUTH_TOKEN, token() )
                                                            .content( content ) );
        actions.andExpect( content().contentType( MediaType.APPLICATION_JSON_UTF8 ) );
        actions.andExpect( status().isCreated() );
        actions.andDo( print() );
    }

    /**
     * {@link CodeController#get}
     * 
     * @throws Exception
     */
    @Test
    public void ut1002_get()
        throws Exception {
        final String uri = CodeController.BASE_URI + "/{cdId}";
        Integer cdId = this.cdId;
        ResultActions actions = mockMvc.perform( get( uri, cdId ).contentType( MediaType.APPLICATION_JSON )
                                                                 .header( Constants.AUTH_TOKEN, token() ) );
        actions.andExpect( content().contentType( MediaType.APPLICATION_JSON_UTF8 ) );
        actions.andExpect( status().isOk() );
        actions.andExpect( jsonPath( "$.code.cdId", equalTo( this.cdId ) ) ); // 요 포인트 있지 말자구..
        actions.andDo( print() );
    }

    /**
     * {@link CodeController#query}
     * 
     * @throws Exception
     */
    @Test
    public void ut1003_query()
        throws Exception {
        final String uri = CodeController.BASE_URI + "/query";
        ResultActions actions = mockMvc.perform( get( uri ).contentType( MediaType.APPLICATION_JSON )
                                                           .header( Constants.AUTH_TOKEN, token() )
                                                           // @formatter:off
                                                           // .param( lang(), "ko" )
                                                           // .param( "cdId", "-999" )
                                                           // .param( "upCdId", "-999" )
                                                           // .param( "cdVal", "cd_val" )
                                                           // .param( "cdName", "cd_name" )
                                                           // .param( "cdEngName", "cd_eng_name" )
                                                           // .param( "descr", "descr" )
                                                           // .param( "useYn", "true" )
                                                           // .param( "ordno", "1" )
                                                           // .param( "extVal", "ext_val" )
                                                           // .param( "registerId", "userid()" )
                                                           // .param( "regDtm", "CURRENT_TIMESTAMP" )
                                                           // .param( "modifierId", "userid()" )
                                                           // .param( "updDtm", "CURRENT_TIMESTAMP" )
                                                           // @formatter:on
                                                         );
        actions.andExpect( content().contentType( MediaType.APPLICATION_JSON_UTF8 ) );
        actions.andExpect( status().isOk() );
        actions.andExpect( jsonPath( "$.codes[0].cdId", equalTo( this.cdId  ) ) ); // 요 포인트 있지 말자구..
        actions.andDo( print() );
    }

    /**
     * {@link CodeController#modify}
     * 
     * @throws Exception
     */
    @Test
    public void ut1004_modify()
        throws Exception {
        Code code = model();
        code.setCdVal( "changed_cd_val" );
        String content = mockMessage( code );
        logger.debug( "content: {}", content );
        final String uri = CodeController.BASE_URI + "/{cdId}";
        Integer cdId = this.cdId;
        ResultActions actions = mockMvc.perform( put( uri, cdId ).contentType( MediaType.APPLICATION_JSON )
                                                            .header( Constants.AUTH_TOKEN, token() )
                                                            .content( content ) );
        actions.andExpect( content().contentType( MediaType.APPLICATION_JSON_UTF8 ) );
        actions.andExpect( status().isOk() );
        // actions.andExpect( jsonPath( "$.cdId", equalTo( this.cdId ) ) );
        actions.andDo( print() );
    }



    /**
     * {@link CodeController#enable}
     * 
     * @throws Exception
     */
    @Test
    public void ut1006_enable()
        throws Exception {
        final String uri = CodeController.BASE_URI + "/{cdId}" + "/enable";
        Integer cdId = this.cdId;
        ResultActions actions = mockMvc.perform( put( uri, cdId ).contentType( MediaType.APPLICATION_JSON )
                                                                 .header( Constants.AUTH_TOKEN, token() ) );
        actions.andExpect( status().isNoContent() );
        actions.andDo( print() );
    }

    /**
     * {@link CodeController#enable}
     * 
     * @throws Exception
     */
    @Test
    public void ut1007_disable()
        throws Exception {
        final String uri = CodeController.BASE_URI + "/{cdId}" + "/disable";
        Integer cdId = this.cdId;
        ResultActions actions = mockMvc.perform( put( uri, cdId ).contentType( MediaType.APPLICATION_JSON )
                                                                 .header( Constants.AUTH_TOKEN, token() ) );
        actions.andExpect( status().isNoContent() );
        actions.andDo( print() );
    }
    
    /**
     * {@link CodeController#remove}
     * 
     * @throws Exception
     */
    @Test
    public void ut1009_remove()
        throws Exception {
        final String uri = CodeController.BASE_URI + "/{cdId}";
        Integer cdId = this.cdId;
        ResultActions actions = mockMvc.perform( delete( uri, cdId ).contentType( MediaType.APPLICATION_JSON )
                                                                 .header( Constants.AUTH_TOKEN, token() ) );
        actions.andExpect( status().isNoContent() );
        actions.andDo( print() );
    }

}
