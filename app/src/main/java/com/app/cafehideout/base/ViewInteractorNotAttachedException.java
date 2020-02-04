package com.app.cafehideout.base;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class ViewInteractorNotAttachedException extends RuntimeException {

    public ViewInteractorNotAttachedException() {
        super(
                "Presenter.attachViewViewInteractor(viewInteractor) should be called before"
                        + " accessing presenter methods which uses view interactor object");
    }

}
