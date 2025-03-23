package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Producto> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Camiseta Blanca", "$11.99", R.drawable.camiseta));
        listaProductos.add(new Producto("Jeans Azul", "$30.50", R.drawable.jeans));
        listaProductos.add(new Producto("Zapatillas DragonBall", "$25.00", R.drawable.zapatillas));
        listaProductos.add(new Producto("Camiseta Blanca", "$12.99", R.drawable.camiseta));
        listaProductos.add(new Producto("Jeans Azul", "$24.50", R.drawable.jeans));
        listaProductos.add(new Producto("Zapatillas Negras", "$39.99", R.drawable.zapatillas));listaProductos.add(new Producto("Camiseta Blanca", "$12.99", R.drawable.camiseta));
        listaProductos.add(new Producto("Jeans Azul", "$24.50", R.drawable.jeans));
        listaProductos.add(new Producto("Zapatillas Negras", "$39.99", R.drawable.zapatillas));

        ProductoAdapter adapter = new ProductoAdapter(this, listaProductos);
        recyclerView.setAdapter(adapter);
        Button btnVerCarrito = findViewById(R.id.btnVerCarrito);
        btnVerCarrito.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CarritoActivity.class);
            startActivity(intent);
        });
    }
}
