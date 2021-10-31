package com.example.motto_app.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.motto_app.Interfaces.APIInterface;
import com.example.motto_app.Interfaces.DataInterface;
import com.example.motto_app.Objects.QuizQuestion;
import com.example.motto_app.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_Quiz extends Fragment {

//--------------------------------------------------------------------------------------------------declaring variables
    DataInterface dataInterface;
    TextView tQ, tA, tB, tC, tD;
    Button bA, bB, bC, bD;
    String Corr;
    int index = 0, score = 0;

//--------------------------------------------------------------------------------------------------constructor

    public Fragment_Quiz(DataInterface dataInterface) {
        this.dataInterface = dataInterface;
    }

//--------------------------------------------------------------------------------------------------initializing variables
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
                List<QuizQuestion> QList = response.body();

                QuizQuestion Q = QList.get(index);
                tQ.setText(Q.getQuestion());
                tA.setText(Q.getAnswerA());
                tB.setText(Q.getAnswerB());
                tC.setText(Q.getAnswerC());
                tD.setText(Q.getAnswerD());
                Corr = Q.getCorrectAns();

                bA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Corr.equals("a")) score++;
                        index++;
                        if (index < QList.size()) {
                            QuizQuestion Q = QList.get(index);
                            tQ.setText(Q.getQuestion());
                            tA.setText(Q.getAnswerA());
                            tB.setText(Q.getAnswerB());
                            tC.setText(Q.getAnswerC());
                            tD.setText(Q.getAnswerD());
                            Corr = Q.getCorrectAns();
                        }
                        else dataInterface.onDataReceived(score, QList.size());

                    }
                });

                bB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Corr.equals("b")) score++;
                        index++;
                        if (index < QList.size()) {
                            QuizQuestion Q = QList.get(index);
                            tQ.setText(Q.getQuestion());
                            tA.setText(Q.getAnswerA());
                            tB.setText(Q.getAnswerB());
                            tC.setText(Q.getAnswerC());
                            tD.setText(Q.getAnswerD());
                            Corr = Q.getCorrectAns();
                        }
                        else dataInterface.onDataReceived(score, QList.size());
                    }
                });

                bC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Corr.equals("c")) score++;
                        index++;
                        if (index < QList.size()) {
                            QuizQuestion Q = QList.get(index);
                            tQ.setText(Q.getQuestion());
                            tA.setText(Q.getAnswerA());
                            tB.setText(Q.getAnswerB());
                            tC.setText(Q.getAnswerC());
                            tD.setText(Q.getAnswerD());
                            Corr = Q.getCorrectAns();
                        }
                        else dataInterface.onDataReceived(score, QList.size());
                    }
                });

                bD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Corr.equals("d")) score++;
                        index++;
                        if (index < QList.size()) {
                            QuizQuestion Q = QList.get(index);
                            tQ.setText(Q.getQuestion());
                            tA.setText(Q.getAnswerA());
                            tB.setText(Q.getAnswerB());
                            tC.setText(Q.getAnswerC());
                            tD.setText(Q.getAnswerD());
                            Corr = Q.getCorrectAns();
                        }
                        else dataInterface.onDataReceived(score, QList.size());
                    }
                });

            }

            @Override
            public void onFailure(Call<List<QuizQuestion>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return rootView;
    }
}