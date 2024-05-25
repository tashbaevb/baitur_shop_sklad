package com.example.skladinfo.remote_data;

import java.util.List;

import com.example.skladinfo.models.Order;
import com.example.skladinfo.models.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("order/all")
    Call<List<Order>> getAllOrders();

    @GET("account/all")
    Call<List<User>> getAllUsers();
}
