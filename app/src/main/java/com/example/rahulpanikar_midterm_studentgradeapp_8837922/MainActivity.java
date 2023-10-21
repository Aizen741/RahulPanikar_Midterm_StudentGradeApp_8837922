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
/*

In the onCreate strategy for an Android movement,
this code instates UI components by finding their particular perspectives utilizing their IDs from the XML design document related with the action.
 These components incorporate text fields, checkboxes, radio buttons, and so forth.,
 empowering them to be gotten to and controlled inside the action.

 */
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


/*This code separates client input, including understudy data, side interests, character type,
and opportunity for growth,
then makes a purpose to pass this information to one more action for show.*/


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
/*

This code makes an Aim to explore from the ongoing MainActivity to the SecondDisplayActivity.
It adds different information values as additional items to the plan utilizing key-esteem matches.
These qualities incorporate understudy ID, complete name, character type, side interests, and growth opportunity.
 At last, it begins the new action utilizing startActivity(intent),
 passing the information to be shown in the subsequent movement.

 */
        Intent intent = new Intent(MainActivity.this, SecondDisplayActivity.class);
        intent.putExtra("studentId", studentIdValue);
        intent.putExtra("fullName", fullNameValue);
        intent.putExtra("personalityType", personalityTypeValue);
        intent.putExtra("hobbies", hobbiesValue.toString());
        intent.putExtra("learningExperience", learningExperienceValue);
        startActivity(intent);
    }
}
