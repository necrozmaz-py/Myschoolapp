package com.example.myschoolapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySummaryDashboard extends AppCompatActivity {
    private RatingBar motivationRatingBar;
    private EditText reasoningEditText;
    private TextView updatesContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_dashboard);

        // Initialize UI components
        motivationRatingBar = findViewById(R.id.motivationRatingBar);
        reasoningEditText = findViewById(R.id.reasoningEditText);
        Button logMotivationButton = findViewById(R.id.logMotivationButton);
        updatesContentTextView = findViewById(R.id.updatesContentTextView);

        // Set up onClickListener for the log motivation button
        logMotivationButton.setOnClickListener(view -> {
            // Call your method to log motivation when the button is clicked
            logMotivation((int) motivationRatingBar.getRating(), reasoningEditText.getText().toString());
        });

        // Call a method to load and display updates
        loadUpdates();
    }

    private void logMotivation(int rating, String reasoning) {
        // Implement logic to log motivation here
        // You can save the motivation log to a database or perform any other necessary actions
        // For this example, we'll just display the motivation log in the updatesContentTextView
        String motivationLog = "Motivation Log: " + rating + " - " + reasoning;
        updatesContentTextView.setText(motivationLog);
    }

    private void loadUpdates() {
        // Implement logic to load and display updates
        // For this example, we'll just display some sample updates
        String updatesContent = "1. Update 1\n2. Update 2\n3. Update 3";
        updatesContentTextView.setText(updatesContent);
    }
}
