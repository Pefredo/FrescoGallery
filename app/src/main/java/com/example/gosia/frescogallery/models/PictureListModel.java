package com.example.gosia.frescogallery.models;

/**
 * Created by gosia on 11.01.2017.
 */

public class PictureListModel {

    private String uriPictures = "";
    private String uriFirst = "";
    private String uriSecond = "";

    public PictureListModel(String uriPictures){ //http://thecatapi.com/api/images/get
        this.uriPictures = uriPictures;
    }

    public PictureListModel(String uriFirst, String uriSecond){
        this.uriFirst = uriFirst;
        this.uriSecond = uriSecond;
    }

    public String getUriSecond() {
        return uriSecond;
    }

    public String getUriFirst() {
        return uriFirst;
    }
}
