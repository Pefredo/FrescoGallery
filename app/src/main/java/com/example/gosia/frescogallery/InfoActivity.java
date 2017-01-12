package com.example.gosia.frescogallery;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by gosia on 10.01.2017.
 */

public class InfoActivity extends Activity { //wyswietlac zdjecie

    @BindView (R.id.buttonInfoPage)  Button buttonInfoPage;
    @BindView(R.id.textViewInfoPage) TextView textViewInfoPage;
    private Context  context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ButterKnife.bind(this);
        context = getApplicationContext();
    }

    @OnClick(R.id.buttonInfoPage)
    public void backToPreviousActivity(Button button){
        finish();
    }
}
