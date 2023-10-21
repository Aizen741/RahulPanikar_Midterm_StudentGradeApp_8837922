package com.example.rahulpanikar_midterm_studentgradeapp_8837922;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText studentIdEditText, fullNameEditText, learningExperienceEditText;
    private CheckBox chessCheckBox, cyclingCheckBox, swimmingCheckBox, programmingCheckBox;
    private RadioGroup personalityRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentIdEditText = findViewById(R.id.studentIdEditText);
        fullNameEditText = findViewById(R.id.fullNameEditText);
        learningExperienceEditText = findViewById(R.id.learningExperienceEditText);

        chessCheckBox = findViewById(R.id.chessCheckBox);
        cyclingCheckBox = findViewById(R.id.cyclingCheckBox);
        swimmingCheckBox = findViewById(R.id.swimmingCheckBox);
        programmingCheckBox = findViewById(R.id.programmingCheckBox);

        personalityRadioGroup = findViewById(R.id.personalityRadioGroup);
    }

    public void submitData(View view) {
        String studentIdValue = studentIdEditText.getText().toString();
        String fullNameValue = fullNameEditText.getText().toString();
        String learningExperienceValue = learningExperienceEditText.getText().toString();

        StringBuilder hobbiesValue = new StringBuilder();
        if (chessCheckBox.isChecked()) hobbiesValue.append("Chess, ");
        if (cyclingCheckBox.isChecked()) hobbiesValue.append("Cycling, ");
        if (swimmingCheckBox.isChecked()) hobbiesValue.append("Swimming, ");
        if (programmingCheckBox.isChecked()) hobbiesValue.append("Programming");

        // Removing any trailing comma and space
        if (hobbiesValue.toString().endsWith(", ")) {
            hobbiesValue.delete(hobbiesValue.length() - 2, hobbiesValue.length());
        }

        int selectedPersonalityId = personalityRadioGroup.getCheckedRadioButtonId();
        String personalityTypeValue = "";

        if (selectedPersonalityId == R.id.introvertRadioButton) {
            personalityTypeValue = "Introvert";
        } else if (selectedPersonalityId == R.id.extrovertRadioButton) {
            personalityTypeValue = "Extrovert";
        } else if (selectedPersonalityId == R.id.ambivertRadioButton) {
            personalityTypeValue = "Ambivert";
        }

        Intent intent = new Intent(MainActivity.this, SecondDisplayActivity.class);
        intent.putExtra("studentId", studentIdValue);
        intent.putExtra("fullName", fullNameValue);
        intent.putExtra("personalityType", personalityTypeValue);
        intent.putExtra("hobbies", hobbiesValue.toString());
        intent.putExtra("learningExperience", learningExperienceValue);
        startActivity(intent);
    }
}
