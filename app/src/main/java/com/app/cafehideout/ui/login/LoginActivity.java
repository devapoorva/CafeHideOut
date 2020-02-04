package com.app.cafehideout.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.cafehideout.R;
import com.app.cafehideout.app.App;
import com.app.cafehideout.base.BaseActivity;
import com.app.cafehideout.data.Global;
import com.app.cafehideout.data.PrefConnect;
import com.app.cafehideout.data.response.LoginResponse;
import com.app.cafehideout.di.component.DaggerAppComponent;
import com.app.cafehideout.di.module.AppModule;
import com.app.cafehideout.ui.login.model.LoginRequest;
import com.app.cafehideout.ui.login.presenter.LoginPresenter;
import com.app.cafehideout.ui.login.view.LoginView;
import com.app.cafehideout.ui.table.TableActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.edt_mobile)
    EditText mobile;
    @BindView(R.id.edt_password)
    EditText password;
    @BindView(R.id.btn_login)
    Button button;

    @Inject
    LoginPresenter loginPresenter;

    private String user_mobile,user_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        DaggerAppComponent.builder().appModule(new AppModule(App.getInstance())).build().inject(this);
        loginPresenter.attachView(this);
    }

    @OnClick(R.id.btn_login)
    public void login()
    {
        user_mobile = mobile.getText().toString().trim();
        user_password = password.getText().toString();
        if(TextUtils.isEmpty(user_mobile))
        {
            showValidationSnack(getString(R.string.empty_mobile_number));
        }
        else if(!isValidMobile(user_mobile))
        {
            showValidationSnack(getString(R.string.invalid_mobile));
        }
        else if(TextUtils.isEmpty(user_password))
        {
            showValidationSnack(getString(R.string.empty_password));
        }
        else{
            // login here
            loginPresenter.login(new LoginRequest(user_mobile,user_password));
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if(isConnected)
        {
            button.setVisibility(View.VISIBLE);
        }
        else
        {
            button.setVisibility(View.GONE);
        }
        showSnack(isConnected);
    }

    private boolean isValidMobile(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
    public static final String empcode = "empcode";
    public static final String empname = "empname";
    public static final String dob ="dob";
    public static final String emailid = "emailid";
    public static final String maritalstatus = "maritalstatus";
    public static final String user_id = "user_id";
    @Override
    public void success(LoginResponse loginResponse) {
        PrefConnect.writeString(LoginActivity.this, Global.USER_MOBILE,loginResponse.getResult().getContactno());
        PrefConnect.writeString(LoginActivity.this,Global.empcode,loginResponse.getResult().getEmpcode());
        PrefConnect.writeString(LoginActivity.this,Global.empname,loginResponse.getResult().getEmpname());
        PrefConnect.writeString(LoginActivity.this,Global.dob,loginResponse.getResult().getDob());
        PrefConnect.writeInteger(LoginActivity.this,Global.user_id,loginResponse.getResult().getId());
        PrefConnect.writeString(LoginActivity.this,Global.LOGIN,"Logined");
        PrefConnect.writeString(LoginActivity.this,Global.AUTH_TOKEN,loginResponse.getToken());
        Toast.makeText(LoginActivity.this,loginResponse.getMessage(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, TableActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void failure(String message) {
        Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        pleaseWait("Please wait");
    }

    @Override
    public void hideProgress() {
        okayThanks();
    }
}
