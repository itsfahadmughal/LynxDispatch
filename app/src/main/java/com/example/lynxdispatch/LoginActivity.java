package com.example.lynxdispatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {


    private TextView forgetPassword, newAccount;
    private Button loginButton;
    private TextInputEditText email_e, password_e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialization();

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Forget Password", Toast.LENGTH_SHORT).show();
            }
        });

        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "New Account...", Toast.LENGTH_SHORT).show();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFunc();
            }
        });

    }

    private void loginFunc() {
        String s = email_e.getText().toString().trim();
        String s1 = password_e.getText().toString();
        String emailValidation="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (TextUtils.isEmpty(s)||!s.matches(emailValidation)) {
            email_e.setError("Invalid email format");
        }
        if (TextUtils.isEmpty(s1)) {
            Toast.makeText(this, "Password: This field must be filled!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Email : " + s + "\nPassword : " + s1, Toast.LENGTH_SHORT).show();
        }
    }

    private void initialization() {
        forgetPassword = findViewById(R.id.textView);
        newAccount = findViewById(R.id.textView3);
        loginButton = findViewById(R.id.button);
        email_e = findViewById(R.id.email_login);
        password_e = findViewById(R.id.password_login);
    }
}