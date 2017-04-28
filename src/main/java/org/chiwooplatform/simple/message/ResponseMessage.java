package org.chiwooplatform.simple.message;

import java.util.List;
import java.util.Map;

import java.io.Serializable;

import org.chiwooplatform.context.supports.LanMessage;
import org.chiwooplatform.security.supports.mock.MockUser;
import org.chiwooplatform.simple.model.com.Code;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@JsonRootName("responseMessage")
public class ResponseMessage
    implements Serializable {

    private static final long serialVersionUID = 715187561600168554L;

    private ResponseHeader header;

    public final ResponseHeader getHeader() {
        return header;
    }

    public final void setHeader( ResponseHeader header ) {
        this.header = header;
    }

    // ~ COM : CODE -----------------------------------------------------------
    private Code code;

    public Code getCode() {
        return code;
    }

    public void setCode( Code code ) {
        this.code = code;
    }

    private List<Code> codes;

    public List<Code> getCodes() {
        return this.codes;
    }

    public void setCodes( List<Code> codes ) {
        this.codes = codes;
    }

    private LanMessage lanMessage;

    /**
     * @return the lanMessage
     */
    public LanMessage getLanMessage() {
        return lanMessage;
    }

    /**
     * @param lanMessage the lanMessage to set
     */
    public void setLanMessage( LanMessage lanMessage ) {
        this.lanMessage = lanMessage;
    }

    private List<LanMessage> lanMessages;

    /**
     * @return the lanMessages
     */
    public List<LanMessage> getLanMessages() {
        return lanMessages;
    }

    /**
     * @param lanMessages the lanMessages to set
     */
    public void setLanMessages( List<LanMessage> lanMessages ) {
        this.lanMessages = lanMessages;
    }
    // ~ IAM : 권한 -------------------------------------------------------------

    private Map<String, MockUser> authUsers;

    /**
     * @return the authUsers
     */
    public Map<String, MockUser> getAuthUsers() {
        return authUsers;
    }

    /**
     * @param authUsers the authUsers to set
     */
    public void setAuthUsers( Map<String, MockUser> authUsers ) {
        this.authUsers = authUsers;
    }
}