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

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.productHolder>{

    ArrayList<productmodel> productlist;

    public ProductListAdapter(ArrayList<productmodel> productlist) {
        this.productlist = productlist;
    }

    @NonNull
    @Override
    public productHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductListAdapter.productHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_row_product_list, null));
    }

    @Override
    public void onBindViewHolder(@NonNull productHolder holder, int position) {
        holder.tvName.append(" "+productlist.get(position).getName());
        holder.tvcompany.append(" "+productlist.get(position).getCompanyName());
        holder.tvprice.append(" "+productlist.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
            return productlist.size();
    }

    class productHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvcompany, tvprice;

        public productHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvcompany = itemView.findViewById(R.id.tvcompany);
            tvprice=itemView.findViewById(R.id.tvprice);
        }
    }
}
