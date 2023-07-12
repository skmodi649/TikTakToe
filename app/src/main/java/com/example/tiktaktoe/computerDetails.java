package com.example.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class computerDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_details);
    }

    public void front(View view)
    {
        //Fetching player1 name
        TextView obj=(TextView)findViewById(com.example.tiktaktoe.R.id.one);
        CharSequence player1=obj.getText();
        player1 = player1.toString();

        String player2 = "Bot";
        //Now creating bundles or intents so that these names can be used in the next activity as well
        Intent intent=new Intent(this,computer.class);
        intent.putExtra("key1",player1);  //using put extra method of type string and string
        intent.putExtra("key2",player2);  //using put extra method of type string and string
        startActivity(intent);
    }
}