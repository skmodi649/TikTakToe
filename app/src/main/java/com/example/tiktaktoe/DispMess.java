package com.example.tiktaktoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DispMess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_mess);

        //Fetching the player1 name from the DispMess.java full
        Intent intent=getIntent();
        String player2=intent.getStringExtra("jeet2");
        TextView textView=(TextView)findViewById(com.example.tiktaktoe.R.id.textView4);
        textView.setText(player2);
    }
}