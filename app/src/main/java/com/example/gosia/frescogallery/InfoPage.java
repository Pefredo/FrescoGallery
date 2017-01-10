package com.example.gosia.frescogallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Gosia on 10.01.2017.
 */

public class InfoPage extends Activity {

    private Button buttonInfoPage;
    private TextView textViewInfoPage;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.info_page);

        init();
    }

    public void init(){
        buttonInfoPage = (Button) findViewById(R.id.buttonInfoPage);
        textViewInfoPage = (TextView) findViewById(R.id.textViewInfoPage);
        context = getApplicationContext();

        buttonInfoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
