package com.example.sem6_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.sem6_project.db.Database;
import com.example.sem6_project.model.customermodel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class add_customer extends AppCompatActivity
{
    EditText et_name , et_number , et_email , et_city;
    Button addbtn , cancelbtn;
    FloatingActionButton fbBtn;
    Database db;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        et_name = findViewById(R.id.et_name);
        et_number = findViewById(R.id.et_number);
        et_email = findViewById(R.id.et_email);
        et_city = findViewById(R.id.et_city);

        addbtn = findViewById(R.id.addbtn);
        cancelbtn = findViewById(R.id.cancelbtn);
        fbBtn = findViewById(R.id.fbBtn);

        db=new Database(this);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation()) {
                    long userid = db.insertcustomerdata(et_name.getText().toString(),
                            et_number.getText().toString(),
                            et_email.getText().toString(),
                            et_city.getText().toString());
                    Log.i("userid :: ", String.valueOf(userid));
                    if(userid > 0) {
                        Toast.makeText(getApplicationContext(), "User data inserted successfully", Toast.LENGTH_LONG).show();
                       Intent i = new Intent(getApplicationContext(), UserListActivity.class);
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

        fbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),UserListActivity.class);
                startActivity(intent);
            }
        });
    }

    boolean validation() {
        boolean valid = true;
        if (et_name.getText().toString().length() == 0) {
            et_name.setError("Please Enter Name");
            valid = false;
        }
        if (et_city.getText().toString().length() == 0) {
            et_city.setError("Please Enter City");
            valid = false;
        }
        if (et_number.getText().toString().length() == 0) {
            et_number.setError("Please Enter Mobile No");
            valid = false;
        } else if (et_number.getText().length() != 10) {
            et_number.setError("Enter valid mobile number");
            valid = false;
        }
        if (et_email.getText().toString().length() == 0) {
            et_email.setError("Please Enter Email ID");
            valid = false;
        }
        return valid;
    }
}



