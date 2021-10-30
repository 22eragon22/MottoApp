package com.example.motto_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_Quiz extends Fragment {

//--------------------------------------------------------------------------------------------------declaring variables
    TextView tQ, tA, tB, tC, tD;
    Button bA, bB, bC, bD;
    String Corr;
    int index = 0;

    int random = new Random().nextInt(8);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//--------------------------------------------------------------------------------------------------initializing variables
        View rootView = inflater.inflate(R.layout.fragment__quiz, container, false);

        tQ = rootView.findViewById(R.id.textQuestion);
        tA = rootView.findViewById(R.id.answerAText);
        tB = rootView.findViewById(R.id.answerBText);
        tC = rootView.findViewById(R.id.answerCText);
        tD = rootView.findViewById(R.id.answerDText);

        bA = rootView.findViewById(R.id.buttonA);
        bB = rootView.findViewById(R.id.buttonB);
        bC = rootView.findViewById(R.id.buttonC);
        bD = rootView.findViewById(R.id.buttonD);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface api = retrofit.create(APIInterface.class);

        Call<List<QuizQuestion>> call = api.getQuizQuestion();

//--------------------------------------------------------------------------------------------------coding stuff

        call.enqueue(new Callback<List<QuizQuestion>>() {
            @Override
            public void onResponse(Call<List<QuizQuestion>> call, Response<List<QuizQuestion>> response) {

            }

            @Override
            public void onFailure(Call<List<QuizQuestion>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return rootView;
    }
}