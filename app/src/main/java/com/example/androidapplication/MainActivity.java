package com.example.androidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnClick;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnClick = findViewById(R.id.btnClick);
        tvName = findViewById(R.id.tvName);

        btnClick.setOnClickListener(btn -> {
            tvName.setText("Nguyen Anh Duc");

            //Khi bam button, intent sang man hinh so 2
            //De mo ra man hinh moi, chung ta su dung intent
            Intent intent = new Intent(this, RecycleView.class);
            startActivity(intent);
        });
    }
}