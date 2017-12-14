package com.example.lsiciliano.meteoapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by l.siciliano on 14/12/2017.
 */

public class CityActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_detail);
        final String title = getIntent().getStringExtra("cityTitle");
        TextView cityTitle = findViewById(R.id.city_title);
        final Button favorite = findViewById(R.id.button);
        cityTitle.setText(title);
        final SharedPreferences sharedPref = CityActivity.this.getSharedPreferences("MY_PRIVATE_PREF", Context.MODE_PRIVATE);
        String favoriteCity = sharedPref.getString("favoriteCity", null);

        if (favoriteCity != null && favoriteCity.equals(title)) {
            favorite.setVisibility(View.INVISIBLE);
        }

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("favoriteCity", title);
                editor.apply();
                favorite.setVisibility(View.INVISIBLE);
            }
        });
    }
}
