package com.fred.cms.web.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class UserRequest implements Serializable {

    private static final long serialVersionUID = 3326819349560530947L;

    @NotEmpty
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
