package com.example.lynxdispatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class PaymentActivity_2 extends AppCompatActivity {

    private Button backButton, saveButton;
    private TextInputEditText AccountNo, ConfirmAccountNo, RoutingNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_2);

        inialization();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAccountInfo();
            }
        });

    }

    private void saveAccountInfo() {
        String s = AccountNo.getText().toString().trim();
        String s1 = ConfirmAccountNo.getText().toString().trim();
        String s2 = RoutingNo.getText().toString().trim();

        if (TextUtils.isEmpty(s2)) {
            RoutingNo.setError("Routing #: This field must be filled!");
        } else if (TextUtils.isEmpty(s)) {
            AccountNo.setError("Account #: This field must be filled!");
        } else if (TextUtils.isEmpty(s1)) {
            ConfirmAccountNo.setError("Confirm Account #: This field must be filled!");
        } else {
            if (s.equals(s1)) {
                Toast.makeText(this, "Dummy Saved!!!" + s2 + " " + s1 + " " + s, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Account Number Doesn't Match!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void inialization() {
        backButton = findViewById(R.id.backButton_go_to_payment2);
        saveButton = findViewById(R.id.Save_button_payment2);
        AccountNo = findViewById(R.id.Account_number_payment2);
        ConfirmAccountNo = findViewById(R.id.Confirm_account_number_payment2);
        RoutingNo = findViewById(R.id.Routing_number_payment2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}