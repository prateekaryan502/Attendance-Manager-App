package com.example.attendancemanger1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;


public class StudentHome extends AppCompatActivity {

    EditText welcometext;
    String name = "Srishti";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
        welcometext=findViewById(R.id.welcomeText);

        welcometext.setText("Welcome"+name);
    }
}
