package com.example.motto_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Queue;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity{

//declaring variables from layout 1-----------------------------------------------------------------
    TextView tQ, tA, tB, tC, tD;
    Button bA, bB, bC, bD;
    String Corr;
    int index = 0;
    int random = new Random().nextInt(8);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//setting up variables from layout 1----------------------------------------------------------------
        tQ = findViewById(R.id.textQuestion);
        tA = findViewById(R.id.answerAText);
        tB = findViewById(R.id.answerBText);
        tC = findViewById(R.id.answerCText);
        tD = findViewById(R.id.answerDText);

        bA = findViewById(R.id.buttonA); //bA.setOnClickListener(this);
        bB = findViewById(R.id.buttonB); //bB.setOnClickListener(this);
        bC = findViewById(R.id.buttonC); //bC.setOnClickListener(this);
        bD = findViewById(R.id.buttonD); //bD.setOnClickListener(this);

//establishing connection---------------------------------------------------------------------------
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        APIInterface api = retrofit.create(APIInterface.class);

//call for quiz questions---------------------------------------------------------------------------


        Call<List<QuizQuestion>> call = api.getQuizQuestion();

        call.enqueue(new Callback<List<QuizQuestion>>() {
            @Override
            public void onResponse(Call<List<QuizQuestion>> call, Response<List<QuizQuestion>> response) {

                List<QuizQuestion> Questions = response.body();


                QuizQuestion QuesInd = Questions.get(index);
                tQ.setText(QuesInd.getQuestion());
                tA.setText(QuesInd.getAnswerA());
                tB.setText(QuesInd.getAnswerB());
                tC.setText(QuesInd.getAnswerC());
                tD.setText(QuesInd.getAnswerD());
                Corr = QuesInd.getCorrectAns();
                System.out.println(Corr);


                bA.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            index++;
                            if (index < 3) {
                                QuizQuestion QuesInd = Questions.get(index);
                                tQ.setText(QuesInd.getQuestion());
                                tA.setText(QuesInd.getAnswerA());
                                tB.setText(QuesInd.getAnswerB());
                                tC.setText(QuesInd.getAnswerC());
                                tD.setText(QuesInd.getAnswerD());
                                Corr = QuesInd.getCorrectAns();
                            }
                        }
                    });
                bB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        index++;
                        if (index < 3) {
                            QuizQuestion QuesInd = Questions.get(index);
                            tQ.setText(QuesInd.getQuestion());
                            tA.setText(QuesInd.getAnswerA());
                            tB.setText(QuesInd.getAnswerB());
                            tC.setText(QuesInd.getAnswerC());
                            tD.setText(QuesInd.getAnswerD());
                            Corr = QuesInd.getCorrectAns();
                        }
                    }
                });
                bC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        index++;
                        if (index < 3) {
                            QuizQuestion QuesInd = Questions.get(index);
                            tQ.setText(QuesInd.getQuestion());
                            tA.setText(QuesInd.getAnswerA());
                            tB.setText(QuesInd.getAnswerB());
                            tC.setText(QuesInd.getAnswerC());
                            tD.setText(QuesInd.getAnswerD());
                            Corr = QuesInd.getCorrectAns();
                        }
                    }
                });
                bD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        index++;
                        if (index < 3) {
                            QuizQuestion QuesInd = Questions.get(index);
                            tQ.setText(QuesInd.getQuestion());
                            tA.setText(QuesInd.getAnswerA());
                            tB.setText(QuesInd.getAnswerB());
                            tC.setText(QuesInd.getAnswerC());
                            tD.setText(QuesInd.getAnswerD());
                            Corr = QuesInd.getCorrectAns();
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
