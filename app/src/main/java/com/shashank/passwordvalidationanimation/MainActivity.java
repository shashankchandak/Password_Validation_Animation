package com.shashank.passwordvalidationanimation;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toolbar;

import lib.mozidev.me.extextview.ExTextView;
import lib.mozidev.me.extextview.StrikeThroughPainting;

public class MainActivity extends AppCompatActivity {

    ExTextView validation1TextView,validation2TextView,validation3TextView,validation4TextView;
    EditText passwordEditText;
    ImageView allDoneImageView;
    StrikeThroughPainting s1,s2,s3,s4;
    boolean strike1,strike2,strike3,strike4;
    String password;

    TranslateAnimation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setUpAnimation();
    }



    void validate(){

        password=passwordEditText.getText().toString().trim();
        if(!password.isEmpty()){

            if(password.length()>8 &&!strike1){

                validation1TextView.setTextColor(Color.GRAY);   //change color to black
                s1.strikeThrough();             //strike the text
                validation1TextView.startAnimation(animation);      //animate from left to right and back
                strike1=true;
            }
            else{

            }

        }

    }

     void setUpAnimation(){

         animation = new TranslateAnimation(0.0f, 75.0f,
                 0.0f, 0.0f);
         animation.setDuration(200);  // animation duration
         animation.setRepeatCount(1);  // animation repeat count
         animation.setRepeatMode(2);

     }

    void initializeViews(){

        validation1TextView=findViewById(R.id.validation1TextView);
        validation2TextView=findViewById(R.id.validation2TextView);
        validation3TextView=findViewById(R.id.validation3TextView);
        validation4TextView=findViewById(R.id.validation4TextView);

        passwordEditText=findViewById(R.id.passwordEditText);
        allDoneImageView=findViewById(R.id.allDoneImageView);

        s1=new StrikeThroughPainting(validation1TextView);
        s2=new StrikeThroughPainting(validation2TextView);
        s3=new StrikeThroughPainting(validation3TextView);
        s4=new StrikeThroughPainting(validation4TextView);

        s1.cutTextEdge(true).color(getResources().getColor(R.color.colorStrike,null)).strokeWidth(3F).
                mode(StrikeThroughPainting.MODE_DEFAULT).linePosition(0.7F).totalTime(700L);
        s2.cutTextEdge(true).color(getResources().getColor(R.color.colorStrike,null)).strokeWidth(3F).
                mode(StrikeThroughPainting.MODE_DEFAULT).linePosition(0.7F).totalTime(700L);
        s3.cutTextEdge(true).color(getResources().getColor(R.color.colorStrike,null)).strokeWidth(3F).
                mode(StrikeThroughPainting.MODE_DEFAULT).linePosition(0.7F).totalTime(700L);
        s4.cutTextEdge(true).color(getResources().getColor(R.color.colorStrike,null)).strokeWidth(3F).
                mode(StrikeThroughPainting.MODE_DEFAULT).linePosition(0.7F).totalTime(700L);

        strike1=strike2=strike3=strike4=false;

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validate();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


}
