package com.gatsan.track;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText Email,Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email =(EditText) findViewById(R.id.email);
        Password =(EditText) findViewById(R.id.password);
        Login =(Button) findViewById(R.id.login);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(Email.getText().toString(),Password.getText().toString());
            }
        });
    }

    private void login(String email, String password) {


    }
}
