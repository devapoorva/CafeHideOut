package com.app.cafehideout.data.response;

import com.app.cafehideout.ui.rating.model.RatingModel;

import java.util.List;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class RatingResponse {
    private boolean status;
    private String message;
    private List<RatingModel> result;

    public RatingResponse(boolean status, String message, List<RatingModel> result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<RatingModel> getResult() {
        return result;
    }
}
