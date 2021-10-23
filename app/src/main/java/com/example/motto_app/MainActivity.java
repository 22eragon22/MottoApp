package com.example.motto_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    TextView tQ, tA, tB, tC, tD;
    String tCorr;
    Button bN;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tQ = findViewById(R.id.textQuestion);
        tA = findViewById(R.id.answerAText);
        tB = findViewById(R.id.answerBText);
        tC = findViewById(R.id.answerCText);
        tD = findViewById(R.id.answerDText);
        bN = findViewById(R.id.NextButton);
        bN.setText("START");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        APIInterface api = retrofit.create(APIInterface.class);
        
        Call<List<QuizQuestion>> call = api.getQuizQuestion();
        
        call.enqueue(new Callback<List<QuizQuestion>>() {
            @Override
            public void onResponse(Call<List<QuizQuestion>> call, Response<List<QuizQuestion>> response) {

                List<QuizQuestion> Questions = response.body();

                bN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (index < 3) {
                            bN.setText("NEXT");
                            QuizQuestion QuesInd = Questions.get(index);
                            tQ.setText(QuesInd.getQuestion());
                            tA.setText(QuesInd.getAnswerA());
                            tB.setText(QuesInd.getAnswerB());
                            tC.setText(QuesInd.getAnswerC());
                            tD.setText(QuesInd.getAnswerD());
                            tCorr = QuesInd.getCorrectAns();
                            index++;
                        } else {
                            setContentView(R.layout.activity_finish);
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<List<QuizQuestion>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
