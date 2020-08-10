package com.example.lynxdispatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import me.himanshusoni.quantityview.QuantityView;

public class NewTripEstimate extends AppCompatActivity {
    private ImageView fareParameter;
    private Button backButton,createUrgentTrip;
    private EditText baseLocation,pickUpAddress,dropoFFAddress;
    private  TextView baseFareValue,perMileValue,perMinVale;


    SharedPreferences prefs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip_estimate);
        initialization();
        String     baselocation = prefs.getString("baselocation", null);
        String    basefare = prefs.getString("basefare", null);
        String    permnute = prefs.getString("permnute", null);
        String    permile = prefs.getString("permile", null);

        baseFareValue.setText(basefare);
        perMileValue.setText(permile);
        perMinVale.setText(permnute);
        baseLocation.setText(baselocation);

        fareParameter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewTripEstimate.this, FareParameters.class);
                startActivity(intent);
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
        createUrgentTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean fieldsOK = validate(new EditText[]{baseLocation, pickUpAddress, dropoFFAddress});
                if (fieldsOK) {
                    Intent intent = new Intent(NewTripEstimate.this, UrgentTripDetail.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

                }
                else {
                }



            }
        });
    }


    private void initialization() {
        baseFareValue =findViewById(R.id.base_fare_Value);
        perMileValue = findViewById(R.id.per_mile_value);
        perMinVale = findViewById(R.id.per_minute_value);
        baseLocation = findViewById(R.id.base_location_newTrip);
        pickUpAddress = findViewById(R.id.pickUp_Time_new_Trip);
        dropoFFAddress = findViewById(R.id.dropoff_address_new_trip);
        createUrgentTrip = findViewById(R.id.create_urgent_Trips);
        backButton = findViewById(R.id.backButton_new_trip_estimate);
        fareParameter = findViewById(R.id.fare_parameter);
        prefs = this.getSharedPreferences("fare_parameter_data", Context.MODE_PRIVATE);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }
    private boolean validate(EditText[] fields) {
        for (int i = 0; i < fields.length; i++) {
            EditText currentField = fields[i];
            if (currentField.getText().toString().length() <= 0) {
                currentField.setError("Do not leave empty");
                return false;
            }
        }
        return true;
    }

}