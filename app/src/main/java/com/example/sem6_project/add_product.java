package com.example.sem6_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sem6_project.db.Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class add_product extends AppCompatActivity {

        EditText et_name, et_companyName, et_price;
        Button cancelbtn, addbtn;
        Database db;
        FloatingActionButton fb;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_product);

            et_name = findViewById(R.id.et_name);
            et_companyName = findViewById(R.id.et_companyName);
            et_price = findViewById(R.id.et_price);

            addbtn = findViewById(R.id.addbtn);
            cancelbtn = findViewById(R.id.cancelbtn);
            fb = findViewById(R.id.fbBtn);

            db=new Database(this);

            addbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(validation()) {
                        long userid = db.insertproductdata(et_name.getText().toString(),
                                et_companyName.getText().toString(),
                                et_price.getText());
                        Log.i("userid :: ", String.valueOf(userid));
                        if(userid > 0) {
                            Toast.makeText(getApplicationContext(), "User data inserted successfully", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), ProductListActivity.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Error occurred Insertion unsuccessful", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

            cancelbtn.setOnClickListener( new View.OnClickListener( ) {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent( getApplicationContext() , MainActivity.class);
                    startActivity( intent );
                }
            } );

            fb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext() , ProductListActivity.class);
                    startActivity(intent);
                }
            });
        }

        boolean validation() {
            boolean valid = true;
            if (et_name.getText().toString().length() == 0) {
                et_name.setError("Please Enter Product Name");
                valid = false;
            }
            if (et_companyName.getText().toString().length() == 0) {
                et_companyName.setError("Please Enter Company Name");
                valid = false;
            }
            if (et_price.getText().toString().length() == 0) {
                et_price.setError("Please Enter Price");
                valid = false;
            }
            return valid;
        }
}
