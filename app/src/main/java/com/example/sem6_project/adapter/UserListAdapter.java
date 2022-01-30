package com.example.sem6_project.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sem6_project.R;
import com.example.sem6_project.model.customermodel;
import com.example.sem6_project.model.productmodel;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.userHolder>{

    ArrayList<customermodel> userlist;

    public UserListAdapter(ArrayList<customermodel> userlist) {
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new userHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_row_user_list, null));
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, int position) {
        holder.tvName.append(" "+userlist.get(position).getName());
        holder.tvmob.append(" "+userlist.get(position).getMobile());
        holder.tvemail.append(" "+userlist.get(position).getEmail());
        holder.tvcity.append(" "+userlist.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    class userHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvmob, tvemail, tvcity;

        public userHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvmob = itemView.findViewById(R.id.tvmob);
            tvemail=itemView.findViewById(R.id.tvemail);
            tvcity=itemView.findViewById(R.id.tvcity);
        }
    }
}
