package com.example.myschoolapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {
    private TextView motivationSummaryContentTextView;
    private TextView studentListContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);


        Button viewAllMotivationsButton = findViewById(R.id.viewAllMotivationsButton);

        motivationSummaryContentTextView = findViewById(R.id.motivationSummaryContentTextView);
        studentListContentTextView = findViewById(R.id.studentListContentTextView);


        viewAllMotivationsButton.setOnClickListener(view -> {

            viewAllMotivations();
        });


        loadMotivationSummary();
        loadStudentList();
    }

    private void loadMotivationSummary() {

        String motivationSummary = "Average Motivation: 7.5\nTotal Students: 100";
        motivationSummaryContentTextView.setText(motivationSummary);
    }

    private void loadStudentList() {

        String studentList = "1. Student 1\n2. Student 2\n3. Student 3";
        studentListContentTextView.setText(studentList);
    }

    private void viewAllMotivations() {

        Intent intent = new Intent(this, ViewAllMotivationsActivity.class);
        startActivity(intent);
    }
}
class ViewAllMotivationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_motivations);


    }
}