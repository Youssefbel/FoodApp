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

public class Tacos extends AppCompatActivity {

    ListView tacosList;
    String restolist[] = {"Tacos de Paris", "Tacos de Lyon", "Tacos de France", "O'Tacos"};
    int logos[] = {R.drawable.paris, R.drawable.lyon, R.drawable.france, R.drawable.otacos};
    String openlist[] = {"Open", "Open", "Open", "Open"};
    String closelist[] = {"Closed", "Closed", "Closed", "Closed"};
    String citylist[] = {"Rabat", "Rabat", "Rabat", "Casablanca"};
    String numeros[] = {"0537235689", "0537852102", "0537456987", "0537999985"};




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tacos);
        Toast.makeText(this, "Tacos Category", Toast.LENGTH_SHORT).show();
        tacosList = (ListView) findViewById(R.id.tacosListView);

        int timeOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if(timeOfDay < 9){
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
           tacosList.setAdapter(customAdapter);

        } else if (timeOfDay < 20) {
            //open
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, openlist, numeros);
            tacosList.setAdapter(customAdapter);
        }

        else {
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
            tacosList.setAdapter(customAdapter);

        }



        tacosList.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),restolist[position],Toast.LENGTH_LONG).show();

                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 34.015584362998176);
                    intent.putExtra("Lng",   -6.8284679780848);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 34.019996385918226);
                    intent.putExtra("Lng",   -6.844742189608554);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.95731307071016);
                    intent.putExtra("Lng", -6.872668798379205);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.99709129079763);
                    intent.putExtra("Lng", -6.845295559903005);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }



            }
        }));



    }}
