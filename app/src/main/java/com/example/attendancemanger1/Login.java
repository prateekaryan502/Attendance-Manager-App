package com.example.attendancemanger1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {
    public static final String MSG = "com.AttendanceManager1.welcome";
    EditText password,email;
    Button login;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        password=findViewById(R.id.password);
        email=findViewById(R.id.email);

        firebaseAuth=FirebaseAuth.getInstance();
       // FirebaseFirestore db = FirebaseFirestore.getInstance();

        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emaild=email.getText().toString().trim();
                String passwordd=password.getText().toString().trim();

                if (TextUtils.isEmpty(emaild))
                {
                    email.setText("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(passwordd))
                {
                    password.setText("Password is required");
                    return;
                }
                if(passwordd.length()<6)
                {
                    password.setText("Password must be greater than 6 characters");
                }

                //authenticate the uer
                firebaseAuth.signInWithEmailAndPassword(emaild,passwordd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            Toast.makeText(Login.this,"Logged in successfully",Toast.LENGTH_SHORT).show();
                            String message=emaild;
                            intent.putExtra(MSG, message);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(Login.this,"Error :"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
}
