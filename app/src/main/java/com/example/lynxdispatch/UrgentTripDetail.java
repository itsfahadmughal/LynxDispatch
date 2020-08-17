package com.example.lynxdispatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UrgentTripDetail extends AppCompatActivity {
  Button saveTrip,makeTripLive,backButton;
    EditText pickupTime,PickUpAddress,name,contact_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_trip_detail);
        initialization();
        saveTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  pickup_Time =  pickupTime.getText().toString();
                String  PickUp_Address = PickUpAddress.getText().toString();
                String  name_ = name.getText().toString();
                String  contacts_no = contact_no.getText().toString();
                boolean fieldsOK = validate(new EditText[]{pickupTime, PickUpAddress, name,contact_no});
                if (fieldsOK) {


            }
                else {
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }

    private void initialization() {
        backButton = findViewById(R.id.backButton_urgentTripDetail);
        saveTrip = findViewById(R.id.save_trip);
        makeTripLive = findViewById(R.id.make_Trip_live);
        pickupTime = findViewById(R.id.pickup_time);
        PickUpAddress = findViewById(R.id.pickup_address);
        name = findViewById(R.id.name);
        contact_no  = findViewById(R.id.contact_No_urgentTrip);
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