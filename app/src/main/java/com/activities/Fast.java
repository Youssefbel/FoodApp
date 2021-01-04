package com.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojet.R;

import java.util.Calendar;

public class Fast extends AppCompatActivity {

    ListView fastList;
    String restolist[] = {"McDonald's", "KFC", "Burger King", "Quick"};
    int logos[] = {R.drawable.mc, R.drawable.kfc, R.drawable.bk, R.drawable.quick};
    String openlist[] = {"Open", "Open", "Open", "Open"};
    String closelist[] = {"Closed", "Closed", "Closed", "Closed"};
    String citylist[] = {"Rabat", "Rabat", "Rabat", "Rabat"};
    String numeros[] = {"0537235689", "0537852102", "0537456987", "0537999985"};




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fast);
        Toast.makeText(this, "Fast Food Category", Toast.LENGTH_SHORT).show();
        fastList = (ListView) findViewById(R.id.fastListView);


        int timeOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if(timeOfDay < 9){
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
            fastList.setAdapter(customAdapter);

        } else if (timeOfDay < 20) {
            //open
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, openlist, numeros);
            fastList.setAdapter(customAdapter);
        }

        else {
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
            fastList.setAdapter(customAdapter);

        }

        fastList.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),restolist[position],Toast.LENGTH_LONG).show();

                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 34.017478888752976);
                    intent.putExtra("Lng",  -6.834727370449588);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.99481929422483);
                    intent.putExtra("Lng",  -6.847397136569759);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.987520711783496);
                    intent.putExtra("Lng", -6.851828668547656);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.99555729410046);
                    intent.putExtra("Lng",  -6.847767412848547);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }




            }
        }));


    }}
