package com.example.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class selection extends AppCompatActivity {

    CardView playAFriend;
    CardView playComputer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        playAFriend = findViewById(R.id.playAFriend);
        playComputer = findViewById(R.id.playComputer);

        playAFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selection.this, Details.class));
            }
        });

        playComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selection.this, computerDetails.class));
            }
        });
    }
}