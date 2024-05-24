package com.example.skladinfo.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.skladinfo.databinding.ItemOrderBinding;
import com.example.skladinfo.models.Order;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    ItemOrderBinding binding;
    Context context;
    ArrayList<Order> nn_list;

    public OrderAdapter(Context context, ArrayList<Order> nn_list) {
        this.context = context;
        this.nn_list = nn_list;
    }

    public void setNn_list(ArrayList<Order> nn_list) {
        this.nn_list = nn_list;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemOrderBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        holder.onBind(nn_list.get(position));
    }

    @Override
    public int getItemCount() {
        return nn_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOrderBinding binding;

        public ViewHolder(@NonNull ItemOrderBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(Order order) {
            binding.nameProductCard.setText(order.getNameProduct());
            binding.priceCard.setText(String.valueOf(order.getPriceProduct()));
            binding.userName.setText(order.getNameUser());
            binding.userAddress.setText(order.getAddressUser());
            //             Picasso.get().load(modelM.getModelImage()).into(binding.imageCard);
            Picasso.get().load(order.getModelImage()).into(binding.imageCard);
        }
    }
}
