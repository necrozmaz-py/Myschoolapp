package com.example.myschoolapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);


        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        if (loginButton != null) {
            loginButton.setOnClickListener(view -> handleLoginButtonClick(emailEditText.getText().toString(), passwordEditText.getText().toString()));
        } else {
            showMessage("Login button is null.");
        }

        // Firebase Authentication
        mAuth = FirebaseAuth.getInstance();
    }

    private void handleLoginButtonClick(String email, String password) {
        // Validate user input
        if (email.isEmpty() || password.isEmpty()) {
            showMessage("Please fill in all fields.");
        } else {
            // Attempt user login
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // Login successful
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                // Determine user type based on email
                                if (email.toLowerCase().contains("admin")) {
                                    // Admin login
                                    showMessage("Admin login successful, Welcome " + user.getDisplayName() + "!");
                                    navigateToAdminDashboard();
                                } else if (email.toLowerCase().contains("student")) {
                                    // Student login
                                    showMessage("Student login successful, Welcome " + user.getDisplayName() + "!");
                                    navigateToStudentDashboard();
                                } else {
                                    // Regular user login
                                    showMessage("Login successful, Welcome " + user.getDisplayName() + "!");
                                    navigateToDashboard();
                                }
                            } else {
                                showMessage("Login successful, but user information is not available.");
                            }
                        } else {
                            // Login failed
                            showMessage("Login failed: " + Objects.requireNonNull(task.getException()).getMessage());
                        }
                    });
        }
    }

    private void navigateToAdminDashboard() {
        Intent adminIntent = new Intent(LoginActivity.this, AdminDashboardActivity.class);
        startActivity(adminIntent);
        finish();
    }

    private void navigateToStudentDashboard() {
        Intent studentIntent = new Intent(LoginActivity.this, ActivitySummaryDashboard.class);
        startActivity(studentIntent);
        finish();
    }

    private void navigateToDashboard() {
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    private void showMessage(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }
}
