package com.example.gosia.frescogallery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;



/**
 * Created by gosia on 10.01.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<String> arrayListFirst;
    private List<String> arrayListSecond;
    private static Context context = null;

    public RecyclerViewAdapter(List<String> arrayListFirst, List<String>arrayListSecond) {
        this.arrayListFirst = arrayListFirst;
        this.arrayListSecond = arrayListSecond;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public SimpleDraweeView simpleDraweeViewFirst, simpleDraweeViewSecond;


        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);

            simpleDraweeViewFirst = (SimpleDraweeView) itemView.findViewById(R.id.draweeViewFirst);
            simpleDraweeViewSecond = (SimpleDraweeView) itemView.findViewById(R.id.draweeViewSecond);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, InfoPage.class);
            context.startActivity(intent);
        }
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Uri uriFirst = Uri.parse(arrayListFirst.get(position));
        Uri uriSecond = Uri.parse(arrayListSecond.get(position));

        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uriFirst)
                .setAutoPlayAnimations(true) //gif animation
                .build();

        holder.simpleDraweeViewFirst.setController(draweeController);
        holder.simpleDraweeViewSecond.setImageURI(uriSecond);

    }
    @Override
    public int getItemCount() {
        return arrayListFirst.size();
    }



}