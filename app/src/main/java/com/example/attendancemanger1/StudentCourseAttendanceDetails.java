package com.example.attendancemanger1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;

public class StudentCourseAttendanceDetails extends AppCompatActivity {

    EditText coursename;
    TableLayout coursedate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_course_details);

        coursename=findViewById(R.id.courseName2);
        coursedate=findViewById(R.id.courseDate);  // this is a table object


    }
}
