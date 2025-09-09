package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.editTextText);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(v -> {
            String username = txt.getText().toString();
            Intent i = new Intent(getApplicationContext(), SecondActivity.class);
            i.putExtra("name", username);
            startActivity(i);
        });
    }
}
