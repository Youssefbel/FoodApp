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

public class Italien extends AppCompatActivity {

    ListView italienList;
    String restolist[] = {"Pinchos", "La Mamma", "Luigi's Pizza"};
    int logos[] = {R.drawable.pinchos, R.drawable.mamma, R.drawable.luigi};
    String openlist[] = {"Open", "Open", "Open"};
    String closelist[] = {"Closed", "Closed", "Closed"};
    String citylist[] = {"Rabat", "Rabat", "Rabat"};
    String numeros[] = {"0537852102", "0537456987", "0537999985"};




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.italien);
        Toast.makeText(this, "Italian Category", Toast.LENGTH_SHORT).show();
        italienList = (ListView) findViewById(R.id.italienListView);

        int timeOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if(timeOfDay < 9){
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
            italienList.setAdapter(customAdapter);

        } else if (timeOfDay < 20) {
            //open
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, openlist, numeros);
            italienList.setAdapter(customAdapter);
        }

        else {
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
            italienList.setAdapter(customAdapter);

        }

        italienList.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),restolist[position],Toast.LENGTH_LONG).show();

                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.99776259653219);
                    intent.putExtra("Lng",  -6.848242612778529);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 34.01838777329783);
                    intent.putExtra("Lng",  -6.834848344560015);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.961051481947095);
                    intent.putExtra("Lng", -6.867220186890196);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }



            }
        }));


    }}
