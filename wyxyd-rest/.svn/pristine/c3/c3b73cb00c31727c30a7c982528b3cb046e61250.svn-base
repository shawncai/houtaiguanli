package wy.rest.modular.auth.controller.dto;

import wy.rest.modular.auth.validator.dto.Credence;

/**
 * 认证的请求dto
 *
 * @author xyd
 * @Date 2017/8/24 14:00
 */
public class AuthRequest implements Credence {

    private String account;
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String getCredenceName() {
        return this.account;
    }

    @Override
    public String getCredenceCode() {
        return this.password;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
