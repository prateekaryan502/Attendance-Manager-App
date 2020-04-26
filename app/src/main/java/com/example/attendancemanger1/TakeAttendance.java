package com.example.attendancemanger1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TakeAttendance extends AppCompatActivity {

    Button updateattendance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);

        updateattendance=findViewById(R.id.updateAttendance);
        updateattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtohome=new Intent(getApplicationContext(),TeacherHome.class);
                startActivity(backtohome);
            }
        });
    }
}
