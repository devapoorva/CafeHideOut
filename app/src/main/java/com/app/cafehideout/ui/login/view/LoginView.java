package com.app.cafehideout.ui.login.view;

import com.app.cafehideout.base.BaseView;
import com.app.cafehideout.data.response.LoginResponse;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public interface LoginView extends BaseView {
    void success(LoginResponse loginResponse);
    void failure(String message);
}
