package com.example.sem6_project.adapter;

import static android.app.Activity.RESULT_OK;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sem6_project.R;
import com.example.sem6_project.invoice;
import com.example.sem6_project.model.customermodel;

import java.util.ArrayList;

public class SelectUserListAdapter extends RecyclerView.Adapter<SelectUserListAdapter.userHolder>{
    ArrayList<customermodel> userlist;
    public LayoutInflater inflater;
    String value;

    public Activity mActivity;
    public SelectUserListAdapter(Context context, ArrayList<customermodel> userlist) {
        inflater = LayoutInflater.from(context);
        this.userlist = userlist;
//        this. mActivity= mActivity;
    }

    @NonNull
    @Override
    public SelectUserListAdapter.userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*View view = inflater.inflate(R.layout.country_list, parent, false);
        MyViewHolder holder = new MyViewHolder(view, mActivity *//*<- cant add this*//* );
        return holder;*/

        View v = inflater.inflate(R.layout.activity_select_customer, parent, false);
        userHolder holder1 = new userHolder(v, mActivity /*<- cant add this*/ );
        return holder1;

        /*return new SelectUserListAdapter.userHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_select_customer, null));*/
    }

    @Override
    public void onBindViewHolder(@NonNull SelectUserListAdapter.userHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvName.append(" "+userlist.get(position).getName());
        holder.tvmob.append(" "+userlist.get(position).getMobile());
        holder.tvemail.append(" "+userlist.get(position).getEmail());
        holder.tvcity.append(" "+userlist.get(position).getCity());
        value = userlist.get(position).getName();
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    class userHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvName, tvmob, tvemail, tvcity;
        Button select;

        public Activity mActivity;

        public userHolder(@NonNull View itemView, Activity mActivity) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvmob = itemView.findViewById(R.id.tvmob);
            tvemail=itemView.findViewById(R.id.tvemail);
            tvcity=itemView.findViewById(R.id.tvcity);
            select=itemView.findViewById(R.id.select);

            select.setOnClickListener(this);
            this.mActivity = mActivity;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("customer", value);
            mActivity.setResult(mActivity.RESULT_OK, intent);
            mActivity.finish();
        }
    }
}