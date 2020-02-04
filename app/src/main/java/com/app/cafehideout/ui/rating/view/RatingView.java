package com.app.cafehideout.ui.rating.view;

import com.app.cafehideout.base.BaseView;
import com.app.cafehideout.data.response.RatingResponse;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public interface RatingView extends BaseView {
    void success(RatingResponse ratingResponse);
    void failure(String message);
    void unAuthorize(String message);
}
