package com.example.changlecolouroftext;

import android.support.v4.app.BundleCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text1);

    }
    @Override
    public void onSaveInstanceState(Bundle save) {
     super.onSaveInstanceState(save);
     //save the state of textColor of text before destroy Activity
     //getCurrentTextColor return the current text color of text
     save.putInt("color",textView.getCurrentTextColor());
    }
    //handle click event
    public void changeColor(View v) {
        //use Random class
        Random random = new Random();
        //random.nextInt(20) choose 0-19 elements of array randomly
        String colorName = mColorArray[random.nextInt(20)];
        //get the color identifier that matches the color name
        int colorResourceName = getResources().getIdentifier(colorName,"color",getApplicationContext().getPackageName());
       //get the Id of color
        int colorId = getResources().getColor(colorResourceName);
        textView.setTextColor(colorId);
    }
}
