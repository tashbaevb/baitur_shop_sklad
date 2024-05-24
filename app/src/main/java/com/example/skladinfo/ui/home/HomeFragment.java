package com.example.skladinfo.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.skladinfo.databinding.FragmentHomeBinding;
import com.example.skladinfo.models.Order;
import com.example.skladinfo.remote_data.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    OrderAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Call<List<Order>> apiCall = RetrofitClient.getInstance().getApi().getAllOrders();
        apiCall.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if (response.body() != null) {
                    ArrayList<Order> response_list = (ArrayList<Order>) response.body();
                    adapter = new OrderAdapter(requireActivity(), response_list);
                    binding.recyclerViewScaldOrders.setAdapter(adapter);
                } else {
                    Toast.makeText(requireActivity(), "NO Ability DATA from Sanjar/BaiturSHOP ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable throwable) {
                Log.e("TAG", "NO  DATA " + throwable.getLocalizedMessage());
                Toast.makeText(requireActivity(), "NO DATA", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}