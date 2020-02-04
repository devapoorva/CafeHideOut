package com.app.cafehideout.base;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public abstract class BasePresenter<T extends BaseView> implements Presenter<T> {

    private T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    public T getView() {
        confirmViewInteractorAttached();

        return view;
    }

    private void confirmViewInteractorAttached() {
        if (!isViewInteractorAttached()) {
            throw new ViewInteractorNotAttachedException();
        }
    }

    private boolean isViewInteractorAttached() {
        return view != null;
    }

}