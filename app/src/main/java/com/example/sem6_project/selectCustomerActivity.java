package com.example.sem6_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.sem6_project.adapter.SelectUserListAdapter;
import com.example.sem6_project.adapter.UserListAdapter;
import com.example.sem6_project.db.Database;
import com.example.sem6_project.model.customermodel;

import java.util.ArrayList;

public class selectCustomerActivity extends AppCompatActivity {

    RecyclerView rcvUserList;
    SelectUserListAdapter adapter;
    Database db;
    ArrayList<customermodel> userlist= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        rcvUserList = findViewById(R.id.recycle_view);
        db = new Database(this);
        userlist.addAll(db.getuserlist());
        adapter = new SelectUserListAdapter(getApplicationContext(), userlist);
        rcvUserList.setLayoutManager(new GridLayoutManager(this, 1));
//        rcvUserList.sela
        rcvUserList.setAdapter(adapter);
    }
}