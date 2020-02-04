package com.app.cafehideout.ui.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.cafehideout.R;
import com.app.cafehideout.base.BaseActivity;
import com.app.cafehideout.ui.thanku.ThankYouActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class FeedbackActivity extends BaseActivity {

    @BindView(R.id.btn_next)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_next)
    public void next()
    {
        Intent intent = new Intent(FeedbackActivity.this, ThankYouActivity.class);
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
}
