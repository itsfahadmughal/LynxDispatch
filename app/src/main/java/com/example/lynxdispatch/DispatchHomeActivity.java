package com.example.lynxdispatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class DispatchHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private boolean doubleBackToExitPressedOnce = false;
    private TextView username, account;
    private ImageView userprofile;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch_home);

        initialization();

    }

    private void initialization() {
        toolbar = findViewById(R.id.toolbar_dispatcher);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(DispatchHomeActivity.this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        View header_view = navigationView.getHeaderView(0);
        username = header_view.findViewById(R.id.nav_name_user);
        account = header_view.findViewById(R.id.nav_user_car);
        userprofile = header_view.findViewById(R.id.navProfile);
        navigationView.setNavigationItemSelectedListener(DispatchHomeActivity.this);

        sharedpreferences = getSharedPreferences("login_data", MODE_PRIVATE);
        editor = sharedpreferences.edit();
        String fullname = sharedpreferences.getString("FullName", "");
        username.setText(fullname);
        int accounttype = sharedpreferences.getInt("RoleId", 0);
        if (accounttype == 1) {
            account.setText("Dispatcher");
        } else if (accounttype == 2) {
            account.setText("Driver");
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.dispatch_item1:
                drawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case R.id.dispatch_item2:
                Toast.makeText(this, "Assigned Trips", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dispatch_item3:
                Toast.makeText(this, "Trip History", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dispatch_item4:
                Toast.makeText(this, "Earnings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dispatch_item5:
                Toast.makeText(this, "Helping Material", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dispatch_item6:
                Toast.makeText(this, "Vehicle Expense", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dispatch_item7:
                Toast.makeText(this, "Support", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dispatch_item8:
                Toast.makeText(this, "Payment", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dispatch_item9:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dispatch_item10:
                Intent intent = new Intent(DispatchHomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                editor.putInt("flagLogin", 0);
                editor.putString("FullName", "");
                editor.putInt("UserId", 0);
                editor.putInt("RoleId", 0);
                editor.putString("AccessToken", "");
                editor.putString("TokenType", "");
                editor.apply();
                break;
        }

        return false;
    }


    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        if (drawerLayout.isShown() == true) {
            drawerLayout.closeDrawer(Gravity.LEFT);
            this.doubleBackToExitPressedOnce = false;
        }
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        this.doubleBackToExitPressedOnce = true;

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }//end of back pressed
}