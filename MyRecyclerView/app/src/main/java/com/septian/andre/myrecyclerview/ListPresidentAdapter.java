package com.septian.andre.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter.CateoryViewHolder> {

    private Context context;
    private ArrayList<President> listPresident;

    public void setContext(Context context) {
        this.context = context;
    }

    private ArrayList<President> getListPresident() {
        return listPresident;
    }

    ListPresidentAdapter(Context context) {
        this.context = context;
    }

    void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    @NonNull
    @Override
    public CateoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_president, viewGroup, false);
        return new CateoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CateoryViewHolder cateoryViewHolder, int position) {
        cateoryViewHolder.tvName.setText(getListPresident().get(position).getName());
        cateoryViewHolder.tvRemarks.setText(getListPresident().get(position).getRemarks());
        Glide.with(context).load(getListPresident().get(position).getPhoto()).apply(new RequestOptions().override(55, 55)).into(cateoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    class CateoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvRemarks;
        ImageView imgPhoto;
        CateoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
