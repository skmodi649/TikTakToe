package com.example.tiktaktoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Fetching the player1 name from the DisplayMessage.java full
        Intent intent=getIntent();
        String player1=intent.getStringExtra("jeet1");
        TextView textView=(TextView)findViewById(com.example.tiktaktoe.R.id.textView3);
        textView.setText(player1);
    }
}