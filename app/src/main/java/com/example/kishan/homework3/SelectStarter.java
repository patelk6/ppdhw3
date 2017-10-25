package com.example.kishan.homework3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SelectStarter extends AppCompatActivity {


    ImageView selectedStarterImage;
    TextView textView;
    RadioGroup starterSet;
    Button setOutButton;
    String starter;
    Drawable drawable;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_starter);
        setTitle("Choose your starter!");




        setOutButton = (Button) findViewById(R.id.goToMainHub);
        textView = (TextView) findViewById(R.id.selectedStarter);
        selectedStarterImage = (ImageView) findViewById(R.id.selectedStarterImage);
        starterSet = (RadioGroup) findViewById(R.id.starterSet);

        starterSet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int selectedButton) {
                generateChosenText(selectedButton);
            }
        });

        setOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(SelectStarter.this,MainHub.class);
                i.putExtra("Gender" , getIntent().getStringExtra("Gender"));
                i.putExtra("Name" , getIntent().getStringExtra("Name"));
                i.putExtra("Starter",starter);
                startActivity(i);
            }
        });




    }
    private void generateChosenText(int chosen){
        String begginning = "You have chosen ";
        switch(chosen){
            case R.id.fireType:



                selectedStarterImage.setImageResource(R.drawable.charmander);
                textView.setText(begginning + "Charmander" + ", the Fire Pokemon!");
                starter = "Charmander";

                break;

            case R.id.waterType:
                selectedStarterImage.setImageResource(R.drawable.squirtle);
                textView.setText(begginning + "Squirtle" + ", the Water Pokemon!");
                starter = "Squirtle";
                break;

            case R.id.grassType:
                selectedStarterImage.setImageResource(R.drawable.bulbasaur);
                textView.setText(begginning + "Bulbasaur" + ", the Grass Pokemon!");
                starter = "Bulbasaur";
                break;

            default:
                textView.setText("Please choose a starter!");
        }
    }
}
