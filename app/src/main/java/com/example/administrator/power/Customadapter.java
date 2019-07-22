package com.example.administrator.power;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Customadapter extends ArrayAdapter<String> {
    private String[] ricenames;
    private String[] urls;
    private Activity context;

    public Customadapter(Activity context, String[] ricenames) {
        super(context,R.layout.layout, ricenames);
        this.context = context;
//        this.urls = urls;
        this.ricenames = ricenames;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewltem = inflater.inflate(R.layout.layout, null,true);
        return listViewltem;
    }
}
