package com.app.cafehideout.di.module;

import android.util.Log;

import androidx.room.Room;

import com.app.cafehideout.BuildConfig;
import com.app.cafehideout.api.ApiInterface;
import com.app.cafehideout.app.App;
import com.app.cafehideout.data.Global;
import com.app.cafehideout.data.PrefConnect;
import com.app.cafehideout.data.dao.RatingDao;
import com.app.cafehideout.data.database.HideCafe;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
@Module
public class ApiModule {

    public static final String DEFAULT = "non-auth";
    public static final String AUTH = "auth";
    private static final String REQUEST_TAG = "Request";
    private static final String RESPONSE_TAG = "Response";

    @Named(DEFAULT)
    @Provides
    LoggingInterceptor providesLoggingInterceptor() {
        return new LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .log(Platform.WARN)
                .setLevel(Level.BASIC)
                .request(REQUEST_TAG)
                .response(RESPONSE_TAG)
                .build();
    }

    @Named(AUTH)
    @Provides
    LoggingInterceptor providesAuthLoggingInterceptor() {
        return new LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .addHeader("Authorization", PrefConnect.readString(App.mInstance, Global.AUTH_TOKEN, ""))
                .log(Log.DEBUG)
                .request(REQUEST_TAG)
                .response(RESPONSE_TAG).build();
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
    }

    @Named(DEFAULT)
    @Provides
    OkHttpClient providesOkHttpClient(@Named(DEFAULT) LoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    @Named(AUTH)
    @Provides
    OkHttpClient providesAuthOkHttpClient(@Named(AUTH) LoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    @Named(DEFAULT)
    @Provides
    Retrofit provideRetrofit(@Named(DEFAULT) OkHttpClient httpClient, Converter.Factory factory) {
        return new Retrofit.Builder()
                .baseUrl(Global.BASE_URL)
                .addConverterFactory(factory)
                .client(httpClient)
                .build();
    }

    @Named(AUTH)
    @Provides
    Retrofit provideAuthRetrofit(@Named(AUTH) OkHttpClient httpClient, Converter.Factory
            factory) {
        return new Retrofit
                .Builder()
                .baseUrl(Global.BASE_URL)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(factory)
                .build();
    }

    @Singleton
    @Named(DEFAULT)
    @Provides
    ApiInterface providesApiService(@Named(DEFAULT) Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

    @Singleton
    @Named(AUTH)
    @Provides
    ApiInterface providesAuthApiService(@Named(AUTH) Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

}
