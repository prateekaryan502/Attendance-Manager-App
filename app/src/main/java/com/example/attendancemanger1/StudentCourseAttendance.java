package com.example.attendancemanger1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentCourseAttendance extends AppCompatActivity {
    EditText coursename, totalclasses, attendedclasses, percentage;
    Button details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_course);

        coursename=findViewById(R.id.courseName);
        totalclasses=findViewById(R.id.totalClasses);
        attendedclasses=findViewById(R.id.attendedClasses);
        percentage=findViewById(R.id.percentage);
        details=findViewById(R.id.details);


//        coursename.setText();
//        totalclasses.setText();
//        attendedclasses.setText();
//        percentage.setText();
//        details.setText();

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tostudentattendancedetails = new Intent(getApplicationContext(), StudentCourseAttendanceDetails.class);

                // here we will have to implement puExtra and add extra varibles needed to access database of the student.
                startActivity(tostudentattendancedetails);
            }
        });

    }
}
