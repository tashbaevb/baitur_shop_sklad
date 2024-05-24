package com.example.skladinfo.remote_data;

import java.util.List;

import com.example.skladinfo.models.Order;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("order/all")
    Call<List<Order>> getAllOrders();
}
