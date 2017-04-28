package org.chiwooplatform.simple.model.com;

import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import org.hibernate.validator.constraints.NotEmpty;

import org.chiwooplatform.context.Constants;
import org.chiwooplatform.context.model.MapConvertable;
import org.chiwooplatform.context.supports.ConverterUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author yourname <yourname@your.email>
 */
@SuppressWarnings("serial")
@Alias("code")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@JsonRootName("code")
public class Code
    implements MapConvertable {

    @NotNull
    @JsonProperty(required = true)
    private Integer cdId;

    private Integer upCdId;

    private String cdVal;

    @NotEmpty
    @JsonProperty(required = true)
    private String cdName;

    private String cdEngName;

    private String descr;

    @NotNull
    @JsonProperty(required = true)
    private Boolean useYn;

    private Integer ordno;

    private String extVal;

    private Integer registerId;

    @JsonFormat(pattern = Constants.DEFAULT_TIMESTAMP_FORMAT, timezone = Constants.LOCAL_TIMEZONE)
    @JsonProperty(required = true)
    private Date regDtm;

    private Integer modifierId;

    @JsonFormat(pattern = Constants.DEFAULT_TIMESTAMP_FORMAT, timezone = Constants.LOCAL_TIMEZONE)
    private Date updDtm;

    public Map<String, Object> toMap()
        throws Exception {
        return ConverterUtils.toMap( this );
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "Code [cdId=" );
        builder.append( cdId );
        builder.append( ", upCdId=" );
        builder.append( upCdId );
        builder.append( ", cdVal=" );
        builder.append( cdVal );
        builder.append( ", cdName=" );
        builder.append( cdName );
        builder.append( ", cdEngName=" );
        builder.append( cdEngName );
        builder.append( ", descr=" );
        builder.append( descr );
        builder.append( ", useYn=" );
        builder.append( useYn );
        builder.append( ", ordno=" );
        builder.append( ordno );
        builder.append( ", extVal=" );
        builder.append( extVal );
        builder.append( ", registerId=" );
        builder.append( registerId );
        builder.append( ", regDtm=" );
        builder.append( regDtm );
        builder.append( ", modifierId=" );
        builder.append( modifierId );
        builder.append( ", updDtm=" );
        builder.append( updDtm );
        builder.append( "]" );
        return builder.toString();
    }

    public final Integer getCdId() {
        return cdId;
    }

    public final void setCdId( Integer cdId ) {
        this.cdId = cdId;
    }

    public final Integer getUpCdId() {
        return upCdId;
    }

    public final void setUpCdId( Integer upCdId ) {
        this.upCdId = upCdId;
    }

    public final String getCdVal() {
        return cdVal;
    }

    public final void setCdVal( String cdVal ) {
        this.cdVal = cdVal;
    }

    public final String getCdName() {
        return cdName;
    }

    public final void setCdName( String cdName ) {
        this.cdName = cdName;
    }

    public final String getCdEngName() {
        return cdEngName;
    }

    public final void setCdEngName( String cdEngName ) {
        this.cdEngName = cdEngName;
    }

    public final String getDescr() {
        return descr;
    }

    public final void setDescr( String descr ) {
        this.descr = descr;
    }

    public final Boolean getUseYn() {
        return useYn;
    }

    public final void setUseYn( Boolean useYn ) {
        this.useYn = useYn;
    }

    public final Integer getOrdno() {
        return ordno;
    }

    public final void setOrdno( Integer ordno ) {
        this.ordno = ordno;
    }

    public final String getExtVal() {
        return extVal;
    }

    public final void setExtVal( String extVal ) {
        this.extVal = extVal;
    }

    public final Integer getRegisterId() {
        return registerId;
    }

    public final void setRegisterId( Integer registerId ) {
        this.registerId = registerId;
    }

    public final Date getRegDtm() {
        return regDtm;
    }

    public final void setRegDtm( Date regDtm ) {
        this.regDtm = regDtm;
    }

    public final Integer getModifierId() {
        return modifierId;
    }

    public final void setModifierId( Integer modifierId ) {
        this.modifierId = modifierId;
    }

    public final Date getUpdDtm() {
        return updDtm;
    }

    public final void setUpdDtm( Date updDtm ) {
        this.updDtm = updDtm;
    }
}