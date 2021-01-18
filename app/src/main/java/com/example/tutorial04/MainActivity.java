package com.example.tutorial04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername,edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtusername);
        edtPassword = findViewById(R.id.edtpassword);
    }

    public void btnLoginClick(View view) {
        String valUsername = edtUsername.getText().toString();
        String valPassword = edtPassword.getText().toString();

        if(valUsername.equals("")){
            Toast.makeText(this, "Username can not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(valPassword.equals("")){
            Toast.makeText(this, "Password can not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(valPassword.length() < 6){
            Toast.makeText(this, "Password must be of minimum 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(valUsername).matches()){
            Toast.makeText(this, "Username must be proper email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if(valUsername.equals("admin@gmail.com") && valPassword.equals("123456"))
        {
            Intent intent = new Intent(MainActivity.this,Welcome.class);
            startActivity(intent);
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}