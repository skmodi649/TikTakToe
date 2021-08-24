package com.example.tiktaktoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

    }
    public void front(View view)
    {
        //Fetching player1 name
        TextView obj=(TextView)findViewById(com.example.tiktaktoe.R.id.one);
        CharSequence player1=obj.getText();
        player1=player1.toString();
        //Fetching player2 name
        TextView ob=(TextView)findViewById(com.example.tiktaktoe.R.id.two);
        CharSequence player2=ob.getText();
        player2=player2.toString();

        //Now creating bundles or intents so that these names can be used in the next activity as well
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("key1",player1);  //using put extra method of type string and string
        intent.putExtra("key2",player2);  //using put extra method of type string and string
        startActivity(intent);
    }
}