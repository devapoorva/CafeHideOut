package com.app.cafehideout.data.dao;

import android.os.AsyncTask;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.app.cafehideout.ui.rating.model.RatingModel;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Apoorv Vardhman on 04-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
@Dao
public interface RatingDao {

    @Query("SELECT * FROM rating where `status` =:status")
    List<RatingModel> getAllRating(int status);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(RatingModel ratingModel);

    // rx java query
    @Query("SELECT * FROM rating where `status` =:status")
    Flowable<List<RatingModel>> getAllRatingRx(int status);


}
