package com.example.gosia.frescogallery;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titleBarRemover();

        //Fresco init
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        myArrayList();
    }

    public void myArrayList() {
        List<String> arrayListFirst = new ArrayList<>();
        List<String> arrayListSecond = new ArrayList<>();

        String URI_GIF_FIRST = "https://media.giphy.com/media/Xmz6AD5s92Re8/giphy.gif";
        String URI_PICTURE_FIRST = "https://www.bankozarks.com/assets/images/mobil-wallet-android.jpg";
        String URI_PICTURE_SECOND = "https://s3-eu-west-1.amazonaws.com/fs.siteor.com/javatech/files/layout/assan/vavatech/img/content/android-logo.jpg?1461590805";

        for (int i = 0; i < 50; i++) {
            arrayListFirst.add(i, URI_GIF_FIRST);
            //arrayListFirst.add(i, URI_PICTURE_FIRST);
            arrayListSecond.add(i, URI_PICTURE_SECOND);

            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(arrayListFirst, arrayListSecond);
            recyclerView.setAdapter(recyclerViewAdapter);

        }
    }

    public void titleBarRemover(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }






}