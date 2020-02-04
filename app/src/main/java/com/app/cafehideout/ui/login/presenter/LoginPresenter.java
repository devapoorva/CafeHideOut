package com.app.cafehideout.ui.login.presenter;

import com.app.cafehideout.base.BasePresenter;
import com.app.cafehideout.base.Presenter;
import com.app.cafehideout.ui.login.model.LoginRequest;
import com.app.cafehideout.ui.login.view.LoginView;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public interface LoginPresenter extends Presenter<LoginView> {
    void login(LoginRequest loginRequest);
}
