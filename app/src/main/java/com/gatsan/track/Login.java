package com.gatsan.track;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Login extends AppCompatActivity {

    EditText Email,Password;
    Button Login;
    Intent service = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = new Intent(getBaseContext(), tcpService.class);
        startService(service);



        Email =(EditText) findViewById(R.id.email);
        Password =(EditText) findViewById(R.id.password);
        Login =(Button) findViewById(R.id.login);

        LocalBroadcastManager.getInstance(this).registerReceiver(
                mMessageReceiver, new IntentFilter("intentKey"));



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginPacket = "li," + Email.getText().toString() + "," + Password.getText().toString();

                login(loginPacket);

            }
        });
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String message = intent.getStringExtra("key");
            try
            {
                String[] packets = message.split(",");
                String packetID = packets[0];

                if(packetID.equals("ui"))
                {
                    //Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();

                }
            }
            catch (Exception s)
            {

            }
        }
    };

    private void login(String packet) {

        final Intent service = new Intent(this, tcpService.class);
        service.putExtra("data", packet);
        startService(service);
    }
}
