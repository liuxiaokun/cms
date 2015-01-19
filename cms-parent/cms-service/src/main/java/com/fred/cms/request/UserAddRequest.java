/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:58:24 AM
 */
package com.fred.cms.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class UserAddRequest implements Serializable {

    private static final long serialVersionUID = 3326819349560530947L;

    @NotBlank
    private String account;

    @NotBlank
    private String password;

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
