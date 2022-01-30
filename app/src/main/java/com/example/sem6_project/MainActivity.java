package com.example.sem6_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    CardView addCustomer , addProduct , generateInvoice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addCustomer = findViewById( R.id.addCustomer );
        addCustomer.setOnClickListener( new View.OnClickListener( )
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent( getApplicationContext() , add_customer.class);
                startActivity( intent );
            }
        } );

        addProduct = findViewById(R.id.addProduct);
        addProduct.setOnClickListener( new View.OnClickListener( )
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent( getApplicationContext() , add_product.class);
                startActivity( intent );
            }
        } );

        generateInvoice = findViewById(R.id.generateBill);
        generateInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , invoice.class);
                startActivity(intent);
            }
        });
    }
}