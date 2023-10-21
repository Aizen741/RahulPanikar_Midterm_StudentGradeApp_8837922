package com.example.rahulpanikar_midterm_studentgradeapp_8837922;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_display);

        TextView studentDetailsTextView = findViewById(R.id.studentDetailsTextView);
        TextView personalityTextView = findViewById(R.id.personalityTextView);
        TextView learningExperienceTextView = findViewById(R.id.learningExperienceTextView);

        // Retrieve the extras passed from the previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String studentId = extras.getString("studentId");
            String fullName = extras.getString("fullName");
            String personalityType = extras.getString("personalityType");
            String hobbies = extras.getString("hobbies");
            String learningExperience = extras.getString("learningExperience");

            // Set the values to the TextViews
            studentDetailsTextView.setText("The form for student with " + studentId + " and name " + fullName + " has been successfully submitted.");
            personalityTextView.setText("This student has a personality type " + personalityType + " and his hobbies include " + hobbies + ".");
            learningExperienceTextView.setText("His learning experience is as follows.\n" + learningExperience);
        }
    }
}
