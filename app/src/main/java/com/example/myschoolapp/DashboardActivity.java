package com.example.myschoolapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private TextView updatesContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_dashboard);

        // Initialize UI components
        updatesContentTextView = findViewById(R.id.updatesContentTextView);


        updatesContentTextView.setText("Welcome to the Dashboard!");


    }
}
