package com.example.eva_02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class Menu_act extends AppCompatActivity {


    private ViewFlipper vf;
    private int [] imagen = {R.drawable.a,R.drawable.b,R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i< imagen.length; i++)
        {
            Flip_Image(imagen[i]);
        }

    }

    public void Flip_Image(int i)
    {

        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2300);
        vf.setAutoStart(true);


        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);


    }

    public void Info(View v)
    {
        Intent f = new Intent(this, Info_act.class);
        startActivity(f);
    }

    public void seguridad(View v)
    {
        Intent s = new Intent(this, Seguridad_act.class);
        startActivity(s);
    }



}