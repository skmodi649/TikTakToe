package com.example.tiktaktoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    String player1="";
    String player2="";
    ImageView reload;

    // Player representation
    // 0 - X
    // 1 - O
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    // State meanings:
    //    0 - X
    //    1 - O
    //    2 - Null
    // put all win positions in a 2D array
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    public static int counter = 0;

    // this function will be called every time a
    // players tap in an empty box of the grid
    @SuppressLint("SetTextI18n")
    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        Log.e("Tapped Image Id", String.valueOf(tappedImage));
        // game reset function will be called
        // if someone wins or the boxes are full
        if (!gameActive) {
            gameReset(view);
        }

        // if the tapped image is empty
        if (gameState[tappedImage] == 2) {
            // increase the counter
            // after every tap
            counter++;

            // check if its the last box
            if (counter == 9) {
                // reset the game
                gameActive = false;
            }

            // mark this position
            gameState[tappedImage] = activePlayer;

            // this will give a motion
            // effect to the image
            img.setTranslationY(-1000f);

            // change the active player
            // from 0 to 1 or 1 to 0
            if (activePlayer == 0) {
                // set the image of x
                img.setImageResource(com.example.tiktaktoe.R.drawable.cross);
                activePlayer = 1;
                TextView status = findViewById(com.example.tiktaktoe.R.id.status);

                // change the status
                String stat=player2+" turn";
                status.setText(stat);
            } else {
                // set the image of o
                img.setImageResource(com.example.tiktaktoe.R.drawable.circle);
                activePlayer = 0;
                TextView status = findViewById(com.example.tiktaktoe.R.id.status);

                // change the status
                String stat=player1+" turn";
                status.setText(stat);
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        int flag = 0;
        // Check if any player has won
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                flag = 1;

                // Somebody has won! - Find out who!
                String winnerStr;

                // game reset function be called
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winnerStr = player1+" won";
                    // Update the status bar for winner announcement
                    TextView status = findViewById(com.example.tiktaktoe.R.id.status);
                    status.setText(winnerStr);
                    //Setting the intent
                    Intent intent = new Intent(this, DisplayMessage.class);
                    intent.putExtra("jeet1",player1);
                    startActivity(intent);
                    //Playing the winner sound
                    MediaPlayer mediaPlayer = MediaPlayer.create(this, com.example.tiktaktoe.R.raw.win_notification);
                    mediaPlayer.start();
                }
                // set the status if the match draw
                else {
                    winnerStr = player2+" won";
                    // Update the status bar for winner announcement
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerStr);
                    //Setting the intent
                    Intent intent = new Intent(this, DispMess.class);
                    intent.putExtra("jeet2",player2);
                    startActivity(intent);
                    //Playing the winner sound
                    MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.win_notification);
                    mediaPlayer.start();
                }
                // Update the status bar for winner announcement
                TextView status = findViewById(com.example.tiktaktoe.R.id.status);
                status.setText(winnerStr);
            }
        }
        // set the status if the match draw
        boolean emptySquare=false;
        for(int squareState:gameState){
            if(squareState==2){
                emptySquare=true;
                break;
            }
        }
        if (!emptySquare && gameActive) {
            gameActive=false;
            TextView status = findViewById(com.example.tiktaktoe.R.id.status);
            status.setText("Match Draw");
            //Setting the intent
            Intent intent=new Intent(this,drawactivity.class);
            startActivity(intent);
            //Playing the sound
            MediaPlayer mediaPlayer=MediaPlayer.create(this,com.example.tiktaktoe.R.raw.draw_notification);
            mediaPlayer.start();
        }
        if(counter==9 && flag==0){
            TextView status=findViewById(com.example.tiktaktoe.R.id.status);
            status.setText("Match Draw");
            //Setting the intent
            Intent intent=new Intent(this,drawactivity.class);
            startActivity(intent);
            //Playing the sound
            MediaPlayer mediaPlayer=MediaPlayer.create(this,com.example.tiktaktoe.R.raw.draw_notification);
            mediaPlayer.start();
        }
    }

    // reset the game
    @SuppressLint("SetTextI18n")
    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        // remove all the images from the boxes inside the grid
        ((ImageView) findViewById(com.example.tiktaktoe.R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(com.example.tiktaktoe.R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(com.example.tiktaktoe.R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(com.example.tiktaktoe.R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(com.example.tiktaktoe.R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(com.example.tiktaktoe.R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(com.example.tiktaktoe.R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(com.example.tiktaktoe.R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(com.example.tiktaktoe.R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(com.example.tiktaktoe.R.id.status);
        status.setText(player1+" turn");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reload = findViewById(R.id.reset);
        //Now we have to retrieve the player names from Details.java activity using the bundle or intent itself
        Intent intent=getIntent();
            player1 = intent.getStringExtra("key1");
            player2 = intent.getStringExtra("key2");


        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameReset(view);
            }
        });
    }
}