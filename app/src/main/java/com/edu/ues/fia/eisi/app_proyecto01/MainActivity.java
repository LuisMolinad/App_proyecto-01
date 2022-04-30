package com.edu.ues.fia.eisi.app_proyecto01;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Objects.requireNonNull(getSupportActionBar()).hide();


    }

    @Override
    public void onClick(View view) {

    }
}