package com.example.attendancemanger1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.net.PasswordAuthentication;

public class Register extends AppCompatActivity {
    EditText fullname,phone,email,password;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    Button register;
    Button gotologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullname=findViewById(R.id.fullname);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        progressBar=findViewById(R.id.progressBar);
        firebaseAuth=FirebaseAuth.getInstance();
        register=findViewById(R.id.register);
        gotologin=findViewById(R.id.gotologin);

        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaild=email.getText().toString().trim();
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
                progressBar.setVisibility(View.VISIBLE);

                if (firebaseAuth.getCurrentUser()!=null)
                {
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                // register the user

                firebaseAuth.createUserWithEmailAndPassword(emaild,passwordd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Register.this,"User Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(Register.this,"Error :"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}
