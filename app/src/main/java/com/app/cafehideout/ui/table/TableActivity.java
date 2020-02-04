package com.app.cafehideout.ui.table;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.cafehideout.R;
import com.app.cafehideout.base.BaseActivity;
import com.app.cafehideout.data.Global;
import com.app.cafehideout.ui.rating.RatingActivity;

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
public class TableActivity extends BaseActivity {

    @BindView(R.id.edt_table)
    EditText table;
    @BindView(R.id.btn_next)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_no);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_next)
    public void next()
    {
        String table = this.table.getText().toString().trim();
        if(table.isEmpty())
        {
            showValidationSnack(getString(R.string.empty_table));
        }
        else
        {
            Intent intent = new Intent(TableActivity.this, RatingActivity.class);
            intent.putExtra(Global.table_number,"");
            startActivity(intent);
        }
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
