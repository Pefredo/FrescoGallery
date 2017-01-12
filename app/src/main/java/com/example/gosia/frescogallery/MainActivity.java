package com.example.gosia.frescogallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.example.gosia.frescogallery.binding.RecyclerViewAdapter;
import com.example.gosia.frescogallery.interfaces.IRecyclerViewClickListener;
import com.example.gosia.frescogallery.models.PictureListModel;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;
//butterKnife



public class MainActivity extends AppCompatActivity implements IRecyclerViewClickListener {

    private RecyclerView recyclerView;
    private int picturePosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(this);

        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        myArrayList();
    }


    public void myArrayList() {
        List<PictureListModel> arrayListCommonFirstSecond = new ArrayList<>();

        String uriGifFirst = "https://media.giphy.com/media/Xmz6AD5s92Re8/giphy.gif";
        String uriPictureFirst = "https://www.bankozarks.com/assets/images/mobil-wallet-android.jpg";
        String uriPictureSecond = "https://s3-eu-west-1.amazonaws.com/fs.siteor.com/javatech/files/layout/assan/vavatech/img/content/android-logo.jpg?1461590805";

        //http://thecatapi.com/api/images/get
        //Retrofit AsyncTask (w nowym pliku) w for pobiera i dodaje do listy obrazki z linku, opakować w jeden obiekt (jedna lista)
        //Podzielić na paczki, (activities, logic, adapter).


        for (int i = 0; i < 25; i++) {
            arrayListCommonFirstSecond.add(new PictureListModel(uriGifFirst, uriPictureSecond));
        }

        RecyclerViewAdapter recyclerViewAdapterCommonFirstSecond = new RecyclerViewAdapter(arrayListCommonFirstSecond);
        recyclerView.setAdapter(recyclerViewAdapterCommonFirstSecond);
    }



    @Override
    public void userPictureClick(int pos) {
        Toast.makeText(MainActivity.this, "Clicked picture : " + pos, Toast.LENGTH_SHORT).show();
        picturePosition = pos;
    }
}
