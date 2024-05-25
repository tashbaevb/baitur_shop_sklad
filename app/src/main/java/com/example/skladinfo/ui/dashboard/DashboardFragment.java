package com.example.skladinfo.ui.dashboard;

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
import com.example.skladinfo.databinding.FragmentDashboardBinding;
import com.example.skladinfo.models.User;
import com.example.skladinfo.remote_data.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    UserAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Call<List<User>> apiCall = RetrofitClient.getInstance().getApi().getAllUsers();
        apiCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.body() != null) {
                    ArrayList<User> response_list = (ArrayList<User>) response.body();
                    adapter = new UserAdapter(requireActivity(), response_list);
                    binding.rvUserList.setAdapter(adapter);
                } else {
                    Toast.makeText(requireActivity(), "No DATA from backend", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {
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