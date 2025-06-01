package com.example.gramedia.ui.order;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gramedia.adapter.OrderAdapter;
import com.example.gramedia.R;
import com.example.gramedia.databinding.FragmentOrderBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrderAdapter adapter;
    private List<OrderItem> orderItemList = new ArrayList<>();
    private FragmentOrderBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        recyclerView = view.findViewById(R.id.rvCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Perbaiki di sini dengan menambahkan requireContext()
        adapter = new OrderAdapter(orderItemList, requireContext());
        recyclerView.setAdapter(adapter);

        loadOrderItems(); // Load cart items from SharedPreferences

        return view;
    }

    private void loadOrderItems() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("OrderPrefs", Context.MODE_PRIVATE);
        String orderJson = sharedPreferences.getString("order_items", "[]");

        // Convert the JSON string back to a list of OrderItem objects
        Type type = new TypeToken<List<OrderItem>>() {}.getType();
        List<OrderItem> orderItems = new Gson().fromJson(orderJson, type);

        // Update the list and notify the adapter
        orderItemList.clear();
        orderItemList.addAll(orderItems);
        adapter.notifyDataSetChanged();
    }
}