package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView txt1, txt2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt1 = findViewById(R.id.textView2);
        txt2 = findViewById(R.id.textView3);
        btn1 = findViewById(R.id.button2);

        Intent i = getIntent();
        String username = i.getStringExtra("name");

        // Display the username
        txt1.setText("Hello " + username + "!");

        int num1 = generateRandomNumber();
        // Use String.valueOf() for clarity and to avoid potential issues
        txt2.setText(String.valueOf(num1));

        btn1.setOnClickListener(v -> shareData(username, num1));
    }

    public int generateRandomNumber() {
        Random random = new Random();
        int upper_limit = 1000;
        // Directly return the generated number
        return random.nextInt(upper_limit) + 1; // +1 to avoid 0
    }

    public void shareData(String s1, int rnumber) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, s1 + " got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is " + rnumber);
        startActivity(Intent.createChooser(i, "Choose a platform"));
    }
}
