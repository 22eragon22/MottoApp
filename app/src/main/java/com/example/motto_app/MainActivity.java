package com.example.motto_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
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

//declaring variables from layout 0
    Button bS;


//declaring variables from layout 1
    RadioGroup rG;
    TextView tQ, tA, tB, tC, tD;
    String tCorr, ans;
    Button bN;
    int index = 0, count = 0;

//declaring variables from layout 2
    TextView tS, tM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//setting up variables from layout 1
        rG = findViewById(R.id.radioGroup);
        tQ = findViewById(R.id.textQuestion);
        tA = findViewById(R.id.answerAText);
        tB = findViewById(R.id.answerBText);
        tC = findViewById(R.id.answerCText);
        tD = findViewById(R.id.answerDText);
        bN = findViewById(R.id.NextButton);
        bN.setText("START");

//establishing connection
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


//on-click mechanics

                bN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (index < 3) {
                            if (rG.getCheckedRadioButtonId() != -1) {
                                QuizQuestion QuesInd = Questions.get(index);
                                tQ.setText(QuesInd.getQuestion());
                                tA.setText(QuesInd.getAnswerA());
                                tB.setText(QuesInd.getAnswerB());
                                tC.setText(QuesInd.getAnswerC());
                                tD.setText(QuesInd.getAnswerD());
                                tCorr = QuesInd.getCorrectAns();
                                index++;
                            }
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
