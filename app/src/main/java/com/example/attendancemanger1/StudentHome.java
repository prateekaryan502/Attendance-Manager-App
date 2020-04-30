package com.example.attendancemanger1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class StudentHome extends AppCompatActivity {

    TextView welcometext;
    String name = "Srishti";
    Button viewattendance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        welcometext=findViewById(R.id.welcomeText);
        viewattendance=findViewById(R.id.viewAttendance);

        welcometext.setText("Welcome"+name);

        viewattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tocourseattendance = new Intent(getApplicationContext(),StudentCourseAttendance.class);
                startActivity(tocourseattendance);
            }
        });
    }
}
