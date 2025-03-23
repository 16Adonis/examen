package com.example.examen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CarritoActivity extends AppCompatActivity {

    RecyclerView recyclerCarrito;
    TextView totalText;
    Button btnPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        recyclerCarrito = findViewById(R.id.recyclerCarrito);
        totalText = findViewById(R.id.totalText);
        btnPagar = findViewById(R.id.btnPagar);

        recyclerCarrito.setLayoutManager(new LinearLayoutManager(this));
        ProductoAdapter adapter = new ProductoAdapter(this, Carrito.productosEnCarrito);
        recyclerCarrito.setAdapter(adapter);

        actualizarTotal();

        btnPagar.setOnClickListener(v -> {
            Toast.makeText(this, "¡Gracias por tu compra!", Toast.LENGTH_LONG).show();
            Carrito.productosEnCarrito.clear();
            finish(); // cerrar pantalla
        });
    }

    private void actualizarTotal() {
        double total = 0;
        for (Producto p : Carrito.productosEnCarrito) {
            total += Double.parseDouble(p.precio.replace("$", ""));
        }
        totalText.setText("Total: $" + String.format("%.2f", total));
    }
}