package com.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojet.R;

import java.util.Calendar;

public class Pizza extends AppCompatActivity {

    ListView pizzaList;
    String restolist[] = {"Pizza Hut", "Domino's Pizza", "Luigi's Pizza", "Papa John's Pizza"};
    int logos[] = {R.drawable.hut, R.drawable.dominos, R.drawable.luigi, R.drawable.papa};
    String openlist[] = {"Open", "Open", "Open", "Open"};
    String closelist[] = {"Closed", "Closed", "Closed", "Closed"};
    String citylist[] = {"Rabat", "Rabat", "Rabat", "Casablanca"};
    String numeros[] = {"0537235689", "0537852102", "0537456987", "0537999985"};




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza);
        Toast.makeText(this, "Pizza Category", Toast.LENGTH_SHORT).show();
        pizzaList = (ListView) findViewById(R.id.pizzaListView);

        int timeOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if(timeOfDay < 9){
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
            pizzaList.setAdapter(customAdapter);

        } else if (timeOfDay < 20) {
            //open
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, openlist, numeros);
            pizzaList.setAdapter(customAdapter);
        }

        else {
            //closed
            CustomAdapter2 customAdapter = new CustomAdapter2(getApplicationContext(), restolist, logos, citylist, closelist, numeros);
            pizzaList.setAdapter(customAdapter);

        }




        pizzaList.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(getApplicationContext(),restolist[position],Toast.LENGTH_LONG).show();

                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.99860156544411);
                    intent.putExtra("Lng", -6.84546358688928);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.99036959359105);
                    intent.putExtra("Lng", -6.849802248224124);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.96106038063092);
                    intent.putExtra("Lng", -6.867252373397074);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent = new Intent(view.getContext(), Map.class);
                    intent.putExtra("Lat", 33.59204288760674);
                    intent.putExtra("Lng", -7.600215986282186);
                    intent.putExtra("restoname",restolist[position]);
                    intent.putExtra("tel",numeros[position]);

                    startActivity(intent);
                }




            }
        }));


    }


}



