package com.example.skladinfo.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.skladinfo.databinding.ItemUserBinding;
import com.example.skladinfo.models.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    ItemUserBinding binding;
    Context context;
    ArrayList<User> uu_list;


    public UserAdapter(Context context, ArrayList<User> uu_list) {
        this.context = context;
        this.uu_list = uu_list;
    }

    public void setUu_list(ArrayList<User> uu_list) {
        this.uu_list = uu_list;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.onBind(uu_list.get(position));
    }

    @Override
    public int getItemCount() {
        return uu_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemUserBinding binding;

        public ViewHolder(@NonNull ItemUserBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(User user) {
            binding.userName.setText(user.getName());
            binding.userEmail.setText(user.getEmail());
        }
    }
}
