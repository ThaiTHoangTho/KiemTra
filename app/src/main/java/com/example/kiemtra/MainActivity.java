package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.example.kiemtra.adapter.SanPhamAdapter;
import com.example.kiemtra.dao.SanPhamDao;
import com.example.kiemtra.model.SanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SanPhamAdapter sanPhamAdapter;
    SanPhamDao sanPhamDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.viewSanPham);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sanPhamDao = new SanPhamDao(this);
        ArrayList<SanPham> ListSanPham = sanPhamDao.getAllSanPham();

        sanPhamAdapter = new SanPhamAdapter(this, ListSanPham);
        recyclerView.setAdapter(sanPhamAdapter);
    }
}