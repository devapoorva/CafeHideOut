package com.app.cafehideout.ui.login.model;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class LoginRequest {
    private String contact;
    private String password;

    public LoginRequest(String contact, String password) {
        this.contact = contact;
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }
}
