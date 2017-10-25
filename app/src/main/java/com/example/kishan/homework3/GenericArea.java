package com.example.kishan.homework3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GenericArea extends AppCompatActivity {
    Button confirm;
    TextView welcomeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_area);

        confirm = (Button) findViewById(R.id.confirmButton);
        welcomeText = (TextView) findViewById(R.id.welcomeText);

        switch(getIntent().getStringExtra("Choice")){
            case "Viridian Forest":
                welcomeText.setText("You encountered a Caterpie and deafeated it!");
                break;
            case "Route 22":
                welcomeText.setText("You encountered a wild Pidgey and deafeted it!");
                break;
            case "Pewter City Pokemon Center":
                welcomeText.setText("You went to the Pewter City Pokemon Center, and restored your Pokemon to full health!");
                break;
            case "Pewter Gym_win":
                welcomeText.setText("You have successfully defeated Brock, and have won the Boulder Badge!");
                break;
            case "Pewter Gym_lose":
                welcomeText.setText("You were unable to defeat Brock. Perhaps you should train some more before trying again!");
                break;
        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
