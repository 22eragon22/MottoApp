package com.example.motto_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.motto_app.Fragments.Fragment_Finish;
import com.example.motto_app.Fragments.Fragment_Quiz;
import com.example.motto_app.Interfaces.DataInterface;


public class MainActivity extends AppCompatActivity implements DataInterface {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment_Quiz fq = new Fragment_Quiz(MainActivity.this);
        ft.replace(R.id.placeHolder, fq);
        ft.commit();


    }

    @Override
    public void onDataReceived(int Score, int Size) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment_Finish ff = Fragment_Finish.newInstance(Score, Size);
        ft.replace(R.id.placeHolder, ff);
        ft.commit();
    }
}
