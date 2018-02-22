package com.utng.vgutierrez.nieves;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SnowActivity extends AppCompatActivity  {
    private Button btn_location;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snow);

        btn_location = (Button) findViewById(R.id.btn_location);
        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLocation = new Intent(SnowActivity.this, MapsActivity.class);
                startActivity(intentLocation);

        }
        });
    }
}

