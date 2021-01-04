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

public class Marocain extends AppCompatActivity {

    ListView marocainList;
    String restolist[] = {"Dar Naji", "Chez Ouazzani", "Le Tajine Rabat"};
    int logos[] = {R.drawable.naji, R.drawable.ouaz, R.drawable.tajine};
    String openlist[] = {"Open", "Open", "Open"};
    String closelist[] = {"Closed", "Closed", "Closed"};
    String citylist[] = {"Rabat", "Rabat", "Rabat"};
    String numeros[] = {"0537235689", "0537456987", "0537999985"};




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marocain);
        Toast.makeText(this, "Moroccan Category", Toast.LENGTH_SHORT).show();
        marocainList = (ListView) findViewById(R.id.marocainListView);

        int timeOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if(timeOfDay < 9){
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
            marocainList.setAdapter(customAdapter);

        } else if (timeOfDay < 20) {
            //open
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, openlist, numeros);
            marocainList.setAdapter(customAdapter);
        }

        else {
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
            marocainList.setAdapter(customAdapter);

        }

        marocainList.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),restolist[position],Toast.LENGTH_LONG).show();

                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.979485517259455);
                    intent.putExtra("Lng",  -6.895733894460819);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 34.00467859826877);
                    intent.putExtra("Lng",  -6.847342588738454);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 34.01547126659326);
                    intent.putExtra("Lng",  -6.837305502231318);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }



            }
        }));


    }}
