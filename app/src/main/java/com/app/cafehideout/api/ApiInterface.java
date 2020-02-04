package com.app.cafehideout.api;

import com.app.cafehideout.data.Global;
import com.app.cafehideout.data.response.LoginResponse;
import com.app.cafehideout.data.response.RatingResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public interface ApiInterface {

    @FormUrlEncoded
    @POST(Global.LOGIN)
    Call<LoginResponse> login(
            @Field("contact") String contact,
            @Field("password") String password
    );

    @POST(Global.FEEDBACK_PARAMETER)
    Call<RatingResponse> feedBackParameter();
}
