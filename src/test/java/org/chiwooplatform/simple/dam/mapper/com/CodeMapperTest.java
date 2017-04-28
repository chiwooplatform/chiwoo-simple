package org.chiwooplatform.simple.dam.mapper.com;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import org.chiwooplatform.mybatis.model.ResultMap;
import org.chiwooplatform.mybatis.mapper.BaseMapper;
import org.chiwooplatform.simple.AbstractMapperTests;
import org.chiwooplatform.simple.model.com.Code;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@ActiveProfiles(profiles = { /* "local", "dev" */ })
public class CodeMapperTest
    extends AbstractMapperTests<Code> {

    private Date CURRENT_TIMESTAMP = new Date();

    @Autowired
    private CodeMapper mapper;

    private Integer cdId = -999;

    protected Integer id()
    {
        return this.cdId;
    }

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
    public void mapperIsNotNullTest() {
        logger.info( "mapper: {}", mapper );
        assertNotNull( mapper );
    }

    @Rollback(true)
    @Test
    public void ut1001_CRUD() {
        Code model = model();
        // mapper.saveOrUpdate( model );
        mapper.add( model );
        assertThat( capture.toString(), containsString( "insert into" ) );
        capture.flush();
        Code result = mapper.get( id() );
        assertThat( result.getCdId(), is( this.cdId ) );
        logger.info( "result: {}", result );
        result.setCdVal( "changed_cd_val" );
        mapper.modify( result );
        result = mapper.get( id() );
        assertThat( result.getCdVal(), is( "changed_cd_val" ) );
        mapper.remove( id() );
        result = mapper.get( this.cdId );
        assertNull( result );
    }

    @Test
    public void ut1002_queryRowBounds()
        throws Exception {
        Code model = model();
        mapper.saveOrUpdate( model );
        Map<String, Object> param = new HashMap<>();
        param.put( "cd_id", this.cdId );
        // If you want to get the total record count, set BaseMapper.TOTAL_ROWCOUNT attribute value.
        param.put( BaseMapper.TOTAL_ROWCOUNT, null );
        // If you want to sort the columns in SQL, set value like "col1,col2:desc" format to BaseMapper.ORDERBY.
        param.put( BaseMapper.ORDERBY, "cd_id:desc," );
        logger.info( "TOTAL_ROWCOUNT: {}", param.get( BaseMapper.TOTAL_ROWCOUNT ) );
        RowBounds bounds = new RowBounds( 1, 10 );
        List<Code> list = mapper.query( param, bounds );
        assertNotNull( list );
        List<ResultMap> results = mapper.queryForMap( param, null );
        assertNotNull( results );
    }

}
