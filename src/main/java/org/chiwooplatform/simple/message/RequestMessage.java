package org.chiwooplatform.simple.message;

import java.util.List;

import java.io.Serializable;

import org.chiwooplatform.simple.model.com.Code;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@JsonRootName("requestMessage")
public class RequestMessage
    implements Serializable {

    private static final long serialVersionUID = 6622434867461480011L;

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
}