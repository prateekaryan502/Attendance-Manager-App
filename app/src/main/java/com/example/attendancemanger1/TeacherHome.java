package com.example.attendancemanger1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherHome extends AppCompatActivity {


    Button takeattendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        takeattendance=findViewById(R.id.takeAttendance);

        takeattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent totakeattendance=new Intent(getApplicationContext(),TakeAttendance.class);
                startActivity(totakeattendance);
            }
        });
    }
}
