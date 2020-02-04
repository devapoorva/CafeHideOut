package com.app.cafehideout.di.component;

import com.app.cafehideout.app.App;
import com.app.cafehideout.di.module.ApiModule;
import com.app.cafehideout.di.module.AppModule;
import com.app.cafehideout.di.module.PresenterModule;
import com.app.cafehideout.ui.login.LoginActivity;
import com.app.cafehideout.ui.login.presenter.LoginImpl;
import com.app.cafehideout.ui.rating.RatingActivity;
import com.app.cafehideout.ui.rating.presenter.RatingImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
@Singleton
@Component(modules = {AppModule.class,
        ApiModule.class,
        PresenterModule.class
}
)
public interface AppComponent {
    void inject(App app);
    void inject(LoginImpl login);
    void inject(LoginActivity loginActivity);

    void inject(RatingImpl rating);
    void inject(RatingActivity ratingActivity);
}
