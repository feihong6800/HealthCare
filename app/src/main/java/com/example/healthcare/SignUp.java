package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText username, password, email;
    Button btn_sigup, btn_cancel;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        btn_sigup = findViewById(R.id.bt_signup);
        btn_cancel = findViewById(R.id.bt_cancel);

        databaseHelper = new DatabaseHelper(this);

        btn_sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String emailValue = email.getText().toString();

                if(emailValue.length() > 1)
                {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("Username", usernameValue);
                    contentValues.put("Password", passwordValue);
                    contentValues.put("Email", emailValue);

                    databaseHelper.insertUser(contentValues);
                    Toast.makeText(SignUp.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent =  new Intent(SignUp.this, Home.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(SignUp.this, "Error. Please Try Again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openMain(View view) {
        Intent intent = new Intent(SignUp.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
}
