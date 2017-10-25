package com.example.kishan.homework3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainMenu extends AppCompatActivity {

    EditText nameBox;
    RadioGroup genderSelector;
    Button beginAdventureButton,shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        nameBox = (EditText) findViewById(R.id.nameInput);
        genderSelector = (RadioGroup) findViewById(R.id.genderSelector);
        beginAdventureButton = (Button) findViewById(R.id.beginAdventure);
        shareButton = (Button) findViewById(R.id.shareButton);

        beginAdventureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gender = "";

                switch(genderSelector.getCheckedRadioButtonId()){
                    case R.id.maleGender:
                        gender = "Male";
                        break;
                    case R.id.femaleGender:
                        gender = "Female";
                        break;
                }

                Intent i = new Intent(MainMenu.this,SelectStarter.class);
                i.putExtra("Gender" , gender);
                i.putExtra("Name" , nameBox.getText().toString());
                startActivity(i);

            }
        });
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.createChooser(sendIntent,"test");
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "I'm about to go on my pokemon adventure!");
                sendIntent.setType("text/plain");

                startActivity(sendIntent);
            }
        });
    }
}
