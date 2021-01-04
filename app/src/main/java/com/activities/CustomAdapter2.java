package com.activities;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniprojet.R;


public class CustomAdapter2 extends BaseAdapter {
    Context context;
    String restoname[];
    String city[];
    String numeros[];
    int flags[];
    String open[];
    LayoutInflater inflter;



    public CustomAdapter2(Context applicationContext, String[] restoname, int[] flags, String[] city, String open[], String numeros[]) {
        this.context = context;
        this.restoname = restoname;
        this.flags = flags;
        this.city = city;
        this.open = open;
        this.numeros= numeros;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return restoname.length;
    }

    @Override
    public Object getItem(int i) {

        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflter.inflate(R.layout.list_resto, null);
        TextView restoname1 = (TextView) view.findViewById(R.id.restoname);
        TextView city1 = (TextView) view.findViewById(R.id.city);
        TextView open1 = (TextView) view.findViewById(R.id.open);
        TextView numeros1 = (TextView) view.findViewById(R.id.numeros);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        restoname1.setText(restoname[i]);
        city1.setText(city[i]);
        open1.setText(open[i]);
        numeros1.setText(numeros[i]);
        icon.setImageResource(flags[i]);
        return view;

    }
}