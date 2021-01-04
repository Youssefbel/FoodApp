package com.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojet.R;



public class RestoActivity extends AppCompatActivity {
    TextView listdata;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto);
        listdata = findViewById(R.id.textView);
        imageView = findViewById(R.id.icon);
        Intent intent = getIntent();
       String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);
       listdata.setText(receivedName);
       imageView.setImageResource(receivedImage);
        //enable back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    /*
    private class UpdateTask extends AsyncTask<String, String,String> {
        protected String doInBackground(String... urls) {


            Request request = new Request.Builder()
                    .url("https://developers.zomato.com/api/v2.1/restaurant?res_id=16774318")
                    .get()
                    .addHeader("apikey", "c24adee9a2febfd6eae45a6105c9d9b7")
                    .asJSONObject()
                    .setCallback(new FutureCallback<JSONObject>() {
                        @Override
                        public void onCompleted(Exception e, JSONObject result) {

                            Log.d("FoodFragment", result.toString());
                            RestaurantsZomato r = (RestaurantsZomato) new Gson().fromJson(result.toString(), new TypeToken<RestaurantsZomato>(){}.getType());
                            JSONObject nearby_restaurants = result.get("nearby_restaurants").getAsJsonObject();
                            Log.d("RestDetails",nearby_restaurants.toString());

                            JSONObject rest = nearby_restaurants.get("1").getAsJsonObject();
                            Log.d("RestZomato", rest.toString());
                            JSONObject details = rest.get("restaurant").getAsJsonObject();
                            Log.d("RestZomato", details.toString());
                            RestaurantsZomato.RestaurantDetails ad = new Gson().fromJson(details, new TypeToken<RestaurantsZomato.RestaurantDetails>(){}.getType());

                            Set<Map.Entry<String, JsonElement>> objects =  nearby_restaurants.entrySet();
                            for (Map.Entry<String, JsonElement> entry : object) {
                                System.out.println(entry.getKey() + "/" + entry.getValue());
                                if (entry.getValue() != null) {
                                    RestaurantDetails rd = new Gson().fromJson(entry.getValue(), RestaurantDetails.class);
                                    Log.d("simpletest",rd.getLocation().getAddress());
                                    sTrips.add(rd);
                                }
                            }

                            adapter = new RestaurantAdapter(sTrips);
                            recyclerView.setAdapter(adapter);
                        }
                    });
        }

    Request request = new Request.Builder()
            .url("https://developers.zomato.com/api/v2.1/restaurant?res_id=16774318")
            .get()
            .addHeader("apikey", "c24adee9a2febfd6eae45a6105c9d9b7")
            .build();

        try {
        Response response = client.newCall(request).execute();

    } catch (IOException e) {
        e.printStackTrace();
    }


            return null;
        }
 */

}
