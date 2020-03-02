package com.example.listviewbss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView txtDl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtDl = findViewById(R.id.txtDl);
        Bundle bundle = getIntent().getExtras();
        if( bundle != null){
            txtDl.setText(bundle.getString("du lieu","sai key"));
        }
    }
}
