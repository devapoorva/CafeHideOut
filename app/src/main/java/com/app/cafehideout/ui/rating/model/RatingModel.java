package com.app.cafehideout.ui.rating.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */

@Entity(tableName = "rating",indices = {@Index(value = {"id"},
        unique = true)})

public class RatingModel {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("rating_id")
    public int rating_id;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int feedbackId;

    @ColumnInfo(name = "parameter")
    @SerializedName("parameter")
    private String parameterName;

    @SerializedName("cuid")
    @ColumnInfo(name = "cuid")
    private int cuid;

    @SerializedName("ctime")
    @ColumnInfo(name = "ctime")
    private String ctime;

    @SerializedName("muid")
    @ColumnInfo(name = "muid")
    private int muid;

    @SerializedName("mtime")
    @ColumnInfo(name = "mtime")
    private String mtime;

    @SerializedName("status")
    @ColumnInfo(name = "status")
    private int status;

    public RatingModel(int feedbackId, String parameterName, int cuid, String ctime, int muid, String mtime, int status) {
        this.feedbackId = feedbackId;
        this.parameterName = parameterName;
        this.cuid = cuid;
        this.ctime = ctime;
        this.muid = muid;
        this.mtime = mtime;
        this.status = status;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public int getCuid() {
        return cuid;
    }

    public String getCtime() {
        return ctime;
    }

    public int getMuid() {
        return muid;
    }

    public String getMtime() {
        return mtime;
    }

    public int getStatus() {
        return status;
    }
}
