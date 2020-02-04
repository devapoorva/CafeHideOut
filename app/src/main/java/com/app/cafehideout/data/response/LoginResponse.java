package com.app.cafehideout.data.response;

import com.app.cafehideout.ui.login.model.LoginModel;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class LoginResponse {
    private boolean status;
    private LoginModel result;
    private String token;
    private String message;

    public LoginResponse(boolean status, LoginModel result, String token, String message) {
        this.status = status;
        this.result = result;
        this.token = token;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public LoginModel getResult() {
        return result;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}
