package com.app.cafehideout.di.module;

import android.content.Context;

import androidx.room.Room;

import com.app.cafehideout.app.App;
import com.app.cafehideout.data.dao.RatingDao;
import com.app.cafehideout.data.database.HideCafe;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
@Module
public class AppModule {
    private final App application;
    private HideCafe database;

    public AppModule(App application) {
        this.application = application;
        database = Room.databaseBuilder(application, HideCafe.class, "Apoorv").build();
    }

    @Provides
    App providesApplication() {
        return application;
    }

    @Provides
    Context providesContext() {
        return application;
    }



    @Singleton
    @Provides
    HideCafe provideDb()
    {
        return database;
    }

    @Singleton
    @Provides
    RatingDao ratingDao(HideCafe hideCafe)
    {
        return hideCafe.ratingDao();
    }

}

