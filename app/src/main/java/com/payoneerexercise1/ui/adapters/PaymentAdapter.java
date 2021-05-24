package com.payoneerexercise1.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.payoneerexercise1.databinding.ListItemBinding;
import com.payoneerexercise1.model.Applicable;

import java.util.ArrayList;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.PaymentListViewHolder> {
    private Context mContext;
    private ArrayList<Applicable> mList;
    private ListItemBinding binding;

    public PaymentAdapter(Context mContext, ArrayList<Applicable> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public PaymentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = ListItemBinding.inflate(inflater,parent,false);
        return new PaymentListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentListViewHolder holder, int position) {
        holder.itemBinding.paymentName.setText(mList.get(position).getLabel());
        Glide.with(mContext).load(mList.get(position).getLinks().getLogo())
                .into(holder.itemBinding.paymentImage);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class PaymentListViewHolder extends RecyclerView.ViewHolder{
        private ListItemBinding itemBinding;

        public PaymentListViewHolder(ListItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

    public  void updateList(ArrayList<Applicable> updatedList){
        mList = updatedList;
        notifyDataSetChanged();
    }

}
