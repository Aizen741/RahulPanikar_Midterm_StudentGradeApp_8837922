package com.example.rahulpanikar_midterm_studentgradeapp_8837922;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText studentId, fullName, learningExperience;
    CheckBox chess, cycling, swimming, programming;
    RadioGroup personalityGroup;
    Button submitForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Assuming your XML file is named activity_main.xml

        // Initialize views
        studentId = findViewById(R.id.studentId);
        fullName = findViewById(R.id.fullName);
        learningExperience = findViewById(R.id.learningExperience);
        chess = findViewById(R.id.chess);
        cycling = findViewById(R.id.cycling);
        swimming = findViewById(R.id.swimming);
        programming = findViewById(R.id.programming);
        personalityGroup = findViewById(R.id.personalityGroup);
        submitForm = findViewById(R.id.submitForm);

        submitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract values
                String id = studentId.getText().toString();
                String name = fullName.getText().toString();
                String experience = learningExperience.getText().toString();

                StringBuilder hobbies = new StringBuilder();
                if(chess.isChecked()) {
                    hobbies.append("Chess ");
                }
                if(cycling.isChecked()) {
                    hobbies.append("Cycling ");
                }
                if(swimming.isChecked()) {
                    hobbies.append("Swimming ");
                }
                if(programming.isChecked()) {
                    hobbies.append("Programming ");
                }

                int selectedPersonalityId = personalityGroup.getCheckedRadioButtonId();
                RadioButton selectedPersonality = findViewById(selectedPersonalityId);
                String personality = selectedPersonality.getText().toString();

                // Display or store the extracted values
                Toast.makeText(MainActivity.this, "Student ID: " + id + "\nName: " + name + "\nHobbies: " + hobbies + "\nPersonality: " + personality + "\nExperience: " + experience, Toast.LENGTH_LONG).show();
            }
        });
    }
}
