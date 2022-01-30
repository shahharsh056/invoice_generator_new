package com.example.sem6_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class invoice extends AppCompatActivity {

    CardView cardviewClient;
    TextView client;
    private final static int MY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

//        cardviewClient=findViewById(R.id.cardviewClient);
//        client=findViewById(R.id.client);

//        cardviewClient.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), selectCustomerActivity.class);
//                startActivityForResult(i, MY_REQUEST_CODE);
//            }
//        });
        client=findViewById(R.id.textView);
        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), selectCustomerActivity.class);
//                startActivityForResult(i, MY_REQUEST_CODE);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == MY_REQUEST_CODE) {
                if (data != null) {
                    client.setText(data.getStringExtra("customer"));
                }
            }
        }
    }
}