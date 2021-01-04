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

public class Asiatique extends AppCompatActivity {

    ListView asiatiqueList;
    String restolist[] = {"Mitsuki", "Yoka Sushi", "Eathai", "Le Sushis Rabat"};
    int logos[] = {R.drawable.mitsu, R.drawable.yoka, R.drawable.thai, R.drawable.agdal};
    String openlist[] = {"Open", "Open", "Open", "Open"};
    String closelist[] = {"Closed", "Closed", "Closed", "Closed"};
    String citylist[] = {"Rabat", "Rabat", "Rabat", "Rabat"};
    String numeros[] = {"0537235689", "0537852102", "0537456987", "0537999985"};




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asiatique);
        Toast.makeText(this, "Asian Category", Toast.LENGTH_SHORT).show();
        asiatiqueList = (ListView) findViewById(R.id.asiatiqueListView);

        int timeOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if(timeOfDay < 9){
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
            asiatiqueList.setAdapter(customAdapter);

        } else if (timeOfDay < 20) {
            //open
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, openlist, numeros);
            asiatiqueList.setAdapter(customAdapter);
        }

        else {
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
            asiatiqueList.setAdapter(customAdapter);

        }



        asiatiqueList.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),restolist[position],Toast.LENGTH_LONG).show();

                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 34.00358306927362);
                    intent.putExtra("Lng",  -6.845016745810222);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 34.00076067489699);
                    intent.putExtra("Lng",   -6.849469609622562);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 34.001715580776086);
                    intent.putExtra("Lng", -6.846519345189484);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.99947438595777);
                    intent.putExtra("Lng", -6.849931873396106);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }



            }
        }));

    }}
