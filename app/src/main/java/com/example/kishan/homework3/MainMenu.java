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
    Button beginAdventureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        nameBox = (EditText) findViewById(R.id.nameInput);
        genderSelector = (RadioGroup) findViewById(R.id.genderSelector);
        beginAdventureButton = (Button) findViewById(R.id.beginAdventure);

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
    }
}
