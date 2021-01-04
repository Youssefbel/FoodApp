package com.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojet.R;
import com.utils.PreferenceUtils;

import android.widget.ListView;
import android.widget.AdapterView;






public class UsersActivity extends AppCompatActivity {

    private TextView textViewName;


    ListView simpleList;
    String foodlist[] = {"Pizza", "Fast Food", "Tacos", "Marocain", "Asiatique", "Italien"};
    int flags[] = {R.drawable.pizza, R.drawable.fast, R.drawable.taco, R.drawable.marocain, R.drawable.asiatique, R.drawable.italien};



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        Toast.makeText(this, "Log in successful", Toast.LENGTH_SHORT).show();
        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), foodlist, flags);
        simpleList.setAdapter(customAdapter);


        simpleList.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //        Toast.makeText(getApplicationContext(),foodlist[i],Toast.LENGTH_LONG).show();

                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Pizza.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Fast.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Tacos.class);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent = new Intent(view.getContext(), Marocain.class);
                    startActivity(intent);
                }
                else if (position == 4) {
                    Intent intent = new Intent(view.getContext(), Asiatique.class);
                    startActivity(intent);
                }
                else if (position == 5) {
                    Intent intent = new Intent(view.getContext(), Italien.class);
                    startActivity(intent);
                }
            }
        }));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.log_out:
                PreferenceUtils.savePassword(null, this);
                PreferenceUtils.saveEmail(null, this);
                PreferenceUtils.saveName(null, this);
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }




}
