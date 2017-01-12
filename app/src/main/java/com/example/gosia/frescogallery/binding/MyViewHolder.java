package com.example.gosia.frescogallery.binding;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gosia.frescogallery.InfoActivity;
import com.example.gosia.frescogallery.MainActivity;
import com.example.gosia.frescogallery.R;
import com.example.gosia.frescogallery.models.PictureListModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by gosia on 11.01.2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private SimpleDraweeView simpleDraweeViewFirst, simpleDraweeViewSecond;

    public MyViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        simpleDraweeViewFirst = (SimpleDraweeView) itemView.findViewById(R.id.draweeViewFirst);
        simpleDraweeViewSecond = (SimpleDraweeView) itemView.findViewById(R.id.draweeViewSecond);

    }

    public void bind(PictureListModel pictureListModel, int position) {

        Uri uriFirstCommmon = Uri.parse(pictureListModel.getUriFirst());
        Uri uriSecondCommmon = Uri.parse(pictureListModel.getUriSecond());

        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uriFirstCommmon)
                .setAutoPlayAnimations(true) //gif animation
                .build();

        this.simpleDraweeViewFirst.setController(draweeController);
        this.simpleDraweeViewSecond.setImageURI(uriSecondCommmon);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), InfoActivity.class);
        view.getContext().startActivity(intent);
        ((MainActivity) view.getContext()).userPictureClick(getAdapterPosition());  //get position of picture
    }
}