package com.app.cafehideout.ui.login.presenter;

import com.app.cafehideout.api.ApiInterface;
import com.app.cafehideout.app.App;
import com.app.cafehideout.base.BasePresenter;
import com.app.cafehideout.data.response.LoginResponse;
import com.app.cafehideout.di.component.DaggerAppComponent;
import com.app.cafehideout.di.module.ApiModule;
import com.app.cafehideout.di.module.AppModule;
import com.app.cafehideout.ui.login.model.LoginRequest;
import com.app.cafehideout.ui.login.view.LoginView;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class LoginImpl extends BasePresenter<LoginView> implements LoginPresenter {

    @Inject
    @Named(ApiModule.DEFAULT)
    ApiInterface apiInterface;

    @Override
    public void attachView(LoginView view) {
        super.attachView(view);
        DaggerAppComponent.builder().
                appModule(new AppModule(App.getInstance())).appModule(new AppModule(App.getInstance())).build().inject(this);
        //DaggerAppComponent.create().inject(this);
    }

    @Override
    public void login(LoginRequest loginRequest) {
        getView().showProgress();
        Call<LoginResponse> loginResponseCall = apiInterface.login(loginRequest.getContact(),loginRequest.getPassword());
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    getView().hideProgress();
                    if(response.body().isStatus())
                    {
                        getView().success(response.body());
                    }
                    else
                    {
                        getView().failure(response.body().getMessage());
                    }
                } else {
                    getView().hideProgress();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                getView().hideProgress();
                getView().failure(t.getMessage());
            }
        });
    }
}
