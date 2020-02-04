package com.app.cafehideout.di.module;

import com.app.cafehideout.ui.login.presenter.LoginImpl;
import com.app.cafehideout.ui.login.presenter.LoginPresenter;
import com.app.cafehideout.ui.rating.presenter.RatingImpl;
import com.app.cafehideout.ui.rating.presenter.RatingPresenter;

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
public class PresenterModule {
    @Provides
    LoginPresenter providesLoginPresenter()
    {
        return new LoginImpl();
    }

    @Provides
    RatingPresenter providesRatingPresenter()
    {
        return new RatingImpl();
    }
    /*
    * @Provides
    MobilePresenter provideMobilePresenter(){
        return new MobileImp();
    }*/
}
