package com.example.sem6_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sem6_project.adapter.UserListAdapter;
import com.example.sem6_project.db.Database;
import com.example.sem6_project.model.customermodel;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    RecyclerView rcvUserList;
    UserListAdapter adapter;
    Database db;
    ArrayList<customermodel> userlist= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        rcvUserList = findViewById(R.id.recycle_view);
        db = new Database(this);
        userlist.addAll(db.getuserlist());
        adapter = new UserListAdapter(userlist);
        rcvUserList.setLayoutManager(new GridLayoutManager(this, 1));
        rcvUserList.setAdapter(adapter);
    }
}