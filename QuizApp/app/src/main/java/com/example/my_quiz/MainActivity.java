package com.example.my_quiz;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextInputEditText etLogin, etPassword;
    Button bLogin;
    TextView tvRegister;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLogin = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
        tvRegister = findViewById(R.id.tvRegister);
        bLogin = findViewById(R.id.bLogin);

        mAuth = FirebaseAuth.getInstance();

        bLogin.setOnClickListener(view -> {
            loginUser();
        });
        tvRegister.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, Register.class));
        });
    }

    private void loginUser(){
        String email = etLogin.getText().toString();
        String password = etPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            etLogin.setError("Email cannot be empty");
            etLogin.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etPassword.setError("Password cannot be empty");
            etPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Menu.class));
                    }else{
                        Toast.makeText(MainActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}

