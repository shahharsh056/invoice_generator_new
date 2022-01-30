package com.example.sem6_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sem6_project.adapter.ProductListAdapter;
import com.example.sem6_project.db.Database;
import com.example.sem6_project.model.productmodel;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    RecyclerView rcvProductList;
    ProductListAdapter adapter;
    Database db;
    ArrayList<productmodel> productlist= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        rcvProductList = findViewById(R.id.rcvProductList);
        db = new Database(this);
        productlist.addAll(db.getproductlist());
        adapter = new ProductListAdapter(productlist);
        rcvProductList.setLayoutManager(new GridLayoutManager(this, 1));
        rcvProductList.setAdapter(adapter);
    }
}