package com.app.cafehideout.ui.rating.presenter;

import android.os.AsyncTask;

import com.app.cafehideout.api.ApiInterface;
import com.app.cafehideout.app.App;
import com.app.cafehideout.base.BasePresenter;
import com.app.cafehideout.data.dao.RatingDao;
import com.app.cafehideout.data.database.HideCafe;
import com.app.cafehideout.data.response.RatingResponse;
import com.app.cafehideout.di.component.DaggerAppComponent;
import com.app.cafehideout.di.module.ApiModule;
import com.app.cafehideout.di.module.AppModule;
import com.app.cafehideout.ui.login.view.LoginView;
import com.app.cafehideout.ui.rating.model.RatingModel;
import com.app.cafehideout.ui.rating.view.RatingView;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
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

public class RatingImpl extends BasePresenter<RatingView> implements RatingPresenter {

    @Inject
    RatingDao ratingDao;

    @Inject
    @Named(ApiModule.AUTH)
    ApiInterface apiInterface;

    @Override
    public void attachView(RatingView view) {
        super.attachView(view);
        DaggerAppComponent.builder().appModule(new AppModule(App.getInstance())).build().inject(this);
    }

    @Override
    public void getFeedbackParameter() {
        getView().showProgress();
        Call<RatingResponse> ratingResponseCall = apiInterface.feedBackParameter();
        ratingResponseCall.enqueue(new Callback<RatingResponse>() {
            @Override
            public void onResponse(Call<RatingResponse> call, Response<RatingResponse> response) {
                getView().hideProgress();
                if(response.isSuccessful())
                {
                    for (int i=0;i<response.body().getResult().size();i++)
                    {
                        insertRating(response.body().getResult().get(i));
                        //new InsertRating(response.body().getResult().get(i)).execute();
                    }
                    getView().success(response.body());
                }
                else if(response.code()==401)
                {
                    getView().unAuthorize("Session Expired");
                }
                else
                {
                    getView().failure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<RatingResponse> call, Throwable t) {
                getView().hideProgress();
                getView().failure(t.getMessage());
            }
        });
    }

    private void insertRating(RatingModel ratingModel)
    {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                ratingDao.insertAll(ratingModel);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    class InsertRating extends AsyncTask<Void,Void,Void>
    {
        private RatingModel ratingModel;

        public InsertRating(RatingModel ratingModel) {
            this.ratingModel = ratingModel;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ratingDao.insertAll(ratingModel);
            return null;
        }
    }
}
