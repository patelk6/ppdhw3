package com.example.kishan.homework3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SelectStarter extends AppCompatActivity {


    ImageView selectedStarterImage;
    TextView textView;
    RadioGroup starterSet;
    String starter;
    Drawable drawable;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_starter);
        setTitle("Choose your starter!");



        //

        textView = (TextView) findViewById(R.id.selectedStarter);
        selectedStarterImage = (ImageView) findViewById(R.id.selectedStarterImage);
        starterSet = (RadioGroup) findViewById(R.id.starterSet);

        starterSet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int selectedButton) {
                generateChosenText(selectedButton);
            }
        });




    }
    private void generateChosenText(int chosen){
        String begginning = "You have chosen ";
        switch(chosen){
            case R.id.fireType:



                selectedStarterImage.setImageResource(R.drawable.charmander);
                textView.setText(begginning + "Charmander" + ", the Fire Pokemon!");
                break;

            case R.id.waterType:
                selectedStarterImage.setImageResource(R.drawable.squirtle);
                textView.setText(begginning + "Squirtle" + ", the Water Pokemon!");
                break;

            case R.id.grassType:
                selectedStarterImage.setImageResource(R.drawable.bulbasaur);
                textView.setText(begginning + "Bulbasaur" + ", the Grass Pokemon!");
                break;

            default:
                textView.setText("Please choose a starter!");
        }
    }
}
