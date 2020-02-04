package com.app.cafehideout.ui.rating;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.cafehideout.MainActivity;
import com.app.cafehideout.R;
import com.app.cafehideout.app.App;
import com.app.cafehideout.base.BaseActivity;
import com.app.cafehideout.data.Global;
import com.app.cafehideout.data.dao.RatingDao;
import com.app.cafehideout.data.response.RatingResponse;
import com.app.cafehideout.di.component.DaggerAppComponent;
import com.app.cafehideout.di.module.ApiModule;
import com.app.cafehideout.di.module.AppModule;
import com.app.cafehideout.ui.feedback.FeedbackActivity;
import com.app.cafehideout.ui.rating.adapter.RatingAdapter;
import com.app.cafehideout.ui.rating.communication.RatingComm;
import com.app.cafehideout.ui.rating.model.RatingModel;
import com.app.cafehideout.ui.rating.presenter.RatingPresenter;
import com.app.cafehideout.ui.rating.view.RatingView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class RatingActivity extends BaseActivity implements RatingView {

    @BindView(R.id.btn_next)
    Button button;
    @BindView(R.id.rv_rating)
    RecyclerView rvRating;

    private String table_number = "";
    private RatingAdapter ratingAdapter;

    @Inject
    RatingPresenter ratingPresenter;

    @Inject
    RatingDao ratingDao;


    RatingComm ratingComm = new RatingComm() {

        @Override
        public void rating(RatingModel ratingModel, float rate) {
            Toast.makeText(getApplicationContext(),rate+"",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(intent!=null)
        {
            table_number = intent.getStringExtra(Global.table_number);
        }
        else
        {
            onBackPressed();
        }
        setContentView(R.layout.activity_rating);
        ButterKnife.bind(this);
        DaggerAppComponent.builder().appModule(new AppModule(App.getInstance())).build().inject(this);
        ratingPresenter.attachView(this);
        ratingPresenter.getFeedbackParameter();

    }

    @OnClick(R.id.btn_next)
    public void next()
    {
        Intent intent = new Intent(RatingActivity.this, FeedbackActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
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

    @Override
    public void success(RatingResponse ratingResponse) {
        fetchData();
    }
    //List<RatingModel> ratingModels;

    public void fetchData()
    {
        ratingDao.getAllRatingRx(1).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<RatingModel>>() {
                    @Override
                    public void accept(List<RatingModel> ratingModels) throws Exception {
                        rvRating.setLayoutManager(new LinearLayoutManager(RatingActivity.this));
                        ratingAdapter = new RatingAdapter(ratingModels,RatingActivity.this,ratingComm);
                        rvRating.setAdapter(ratingAdapter);
                        ratingAdapter.notifyDataSetChanged();
                    }
                });
    }

    class FetchData extends AsyncTask<Void,Void,List<RatingModel>>
    {
        @Override
        protected List<RatingModel> doInBackground(Void... voids) {
            return ratingDao.getAllRating(1);
        }

        @Override
        protected void onPostExecute(List<RatingModel> ratingModels) {
            super.onPostExecute(ratingModels);
            rvRating.setLayoutManager(new LinearLayoutManager(RatingActivity.this));
            ratingAdapter = new RatingAdapter(ratingModels,RatingActivity.this,ratingComm);
            rvRating.setAdapter(ratingAdapter);
            ratingAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void failure(String message) {
        showValidationSnack(message);
    }

    @Override
    public void unAuthorize(String message) {
        showValidationSnack(message);
    }

    @Override
    public void showProgress() {
        pleaseWait(getString(R.string.please_wait));
    }

    @Override
    public void hideProgress() {
        okayThanks();
    }
}
