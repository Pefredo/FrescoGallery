package com.example.gosia.frescogallery.binding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gosia.frescogallery.R;
import com.example.gosia.frescogallery.models.PictureListModel;

import java.util.List;

/**
 * Created by gosia on 10.01.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<PictureListModel> arrayListCommonList;

    public RecyclerViewAdapter(List<PictureListModel> arrayListCommonList) {     //two lists in one object
        this.arrayListCommonList = arrayListCommonList;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.bind(arrayListCommonList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return arrayListCommonList.size();
    }
}