package com.example.kishan.homework3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainHub extends AppCompatActivity {
    String[] actionChoices = {"Viridian Forest" , "Route 22" , "Pewter City Pokemon Center" , "Pewter Gym"};
    TextView stats;
    Button chooseActionButton;
    int level = 5;
    String name,gender,pokemon;
    static final String playerName = "PLAYER_NAME";
    static final String playerPokemon = "POKEMON";
    static final String playerGender = "GENDER";
    static final String playerLevel = "LEVEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hub);

        chooseActionButton = (Button) findViewById(R.id.actionChooseButton);
        stats = (TextView) findViewById(R.id.stats);


        name = getIntent().getStringExtra("Name");
        gender = getIntent().getStringExtra("Gender");
        pokemon = getIntent().getStringExtra("Starter");

        generateWelcome();



        chooseActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainHub.this);
                builder.setTitle("Choose an Action").setItems(actionChoices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int chosen) {
                        Intent i = new Intent(MainHub.this,GenericArea.class);
                        switch(chosen){

                            case 0:

                                i.putExtra("Choice" , "Viridian Forest");
                                startActivity(i);
                                level++;
                                generateWelcome();
                                break;
                            case 1:
                                i.putExtra("Choice" , "Route 22");
                                startActivity(i);
                                level++;
                                generateWelcome();
                                break;
                            case 2:
                                i.putExtra("Choice" , "Pewter City Pokemon Center");
                                startActivity(i);
                                generateWelcome();
                                break;
                            case 3:
                                if(level > 9){
                                    i.putExtra("Choice" , "Pewter Gym_win");
                                    startActivity(i);
                                    level+=2;
                                }else{
                                    i.putExtra("Choice" , "Pewter Gym_lose");
                                    startActivity(i);

                                }

                                generateWelcome();
                                break;

                        }
                    }
                }).create().show();

            }

        });


    }



    private void generateWelcome(){
        stats.setText(
                "Name: " + name + "\n" +
                        "Gender: "  + gender + "\n" +
                        "Pokemon: " + pokemon + "\n" +
                        "Level: " + level);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);


        // Restore state members from saved instance
        name = savedInstanceState.getString(playerName);
        gender = savedInstanceState.getString(playerGender);
        pokemon = savedInstanceState.getString(playerPokemon);
        level = savedInstanceState.getInt(playerLevel);
        generateWelcome();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy



        // Restore state members from saved instance
        savedInstanceState.putString(playerName,name);
        savedInstanceState.putString(playerGender,gender);
        savedInstanceState.putString(playerPokemon,pokemon);
        savedInstanceState.putInt(playerLevel,level);

        super.onSaveInstanceState(savedInstanceState);
    }


}
