package org.chiwooplatform.simple.service;

import static org.chiwooplatform.mybatis.mapper.BaseMapper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.chiwooplatform.context.Constants;
import org.chiwooplatform.context.annotation.Loggable;
import org.chiwooplatform.context.supports.LanMessage;
import org.chiwooplatform.context.supports.LocaleMessageSource;
import org.chiwooplatform.mybatis.model.ResultMap;
import org.chiwooplatform.simple.dam.mapper.com.CodeMapper;
import org.chiwooplatform.simple.model.com.Code;

@Loggable
@Service
public class CommonService {

    // ~ COM : CODE -----------------------------------------------------------
    @Autowired
    private CodeMapper codeMapper;

    public Code getAtCodeMapper( Map<String, Object> param ) {
        return codeMapper.get( param );
    }

    public List<Code> queryAtCodeMapper( Map<String, Object> param ) {
        return codeMapper.query( param, rowBounds( param ) );
    }

    public List<ResultMap> queryMapAtCodeMapper( Map<String, Object> param ) {
        return codeMapper.queryForMap( param, rowBounds( param ) );
    }

    @Transactional
    public void saveOrUpdateAtCodeMapper( Code code ) {
        codeMapper.saveOrUpdate( code );
    }

    @Transactional
    public void addAtCodeMapper( Code code ) {
        codeMapper.add( code );
    }

    @Transactional
    public void modifyAtCodeMapper( Code code ) {
        codeMapper.modify( code );
    }

    @Transactional
    public void removeAtCodeMapper( Map<String, Object> param ) {
        codeMapper.remove( param );
    }

    @Transactional
    public void enableAtCodeMapper( Map<String, Object> param ) {
        codeMapper.enable( param );
    }

    @Transactional
    public void disableAtCodeMapper( Map<String, Object> param ) {
        codeMapper.disable( param );
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private MessageSourceAccessor messageAccessor;

    public LanMessage getMessage( String code, String lang ) {
        String msg = messageAccessor.getMessage( code, lang );
        if ( msg == null ) {
            return null;
        }
        LanMessage message = new LanMessage();
        message.setCode( code );
        message.setLocale( lang );
        message.setMessage( msg );
        return message;
    }

    public List<LanMessage> getMessages( String pattern, String locale ) {
        List<LanMessage> messages = redisTemplate.execute( new RedisCallback<List<LanMessage>>() {

            @Override
            public List<LanMessage> doInRedis( RedisConnection connection )
                throws DataAccessException {
                ScanOptions options = ScanOptions.scanOptions().match( pattern ).count( 1 ).build();
                Cursor<Map.Entry<byte[], byte[]>> entries = connection.hScan( LocaleMessageSource.key( locale )
                                                                                                 .getBytes(),
                                                                              options );
                List<LanMessage> result = new ArrayList<LanMessage>();
                if ( entries != null )
                    while ( entries.hasNext() ) {
                        Map.Entry<byte[], byte[]> entry = entries.next();
                        LanMessage msg = new LanMessage();
                        msg.setLocale( locale );
                        msg.setCode( StringUtils.toEncodedString( entry.getKey(),
                                                                  Charset.forName( Constants.DEFAULT_CHARSET ) ) );
                        msg.setMessage( StringUtils.toEncodedString( entry.getValue(),
                                                                     Charset.forName( Constants.DEFAULT_CHARSET ) ) );
                        result.add( msg );
                    }
                return result;
            }
        } );
        return messages;
    }
}
