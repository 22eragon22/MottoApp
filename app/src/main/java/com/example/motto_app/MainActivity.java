package com.example.motto_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;

import org.json.JSONException;


public class MainActivity extends AppCompatActivity {

//--------------------------------------------------------------------------------------------------//declaring variables
    RadioGroup RG;
    RadioButton bA, bB, bC, bD;
    TextView tA, tB, tC, tD, tQ;
    Button bN;
    String texA, texB, texC, texD, texQues, texCorr;
    String url ="http://10.0.2.2:8080/quiz";
    String url2 ="http://10.0.2.2:8080/motto";
    Integer index = 0;
    boolean start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = true;

//--------------------------------------------------------------------------------------------------//assigning variables to objects in layouts
        RG = findViewById(R.id.radioGroup);

        bA = findViewById(R.id.answerAButton);
        bB = findViewById(R.id.answerBButton);
        bC = findViewById(R.id.answerCButton);
        bD = findViewById(R.id.answerDButton);

        tA = findViewById(R.id.answerAText);
        tB = findViewById(R.id.answerBText);
        tC = findViewById(R.id.answerCText);
        tD = findViewById(R.id.answerDText);

        tQ = findViewById(R.id.textQuestion);

        bN = findViewById(R.id.NextButton);

        GetData gD = new GetData(MainActivity.this, url, index);
        gD = new ViewModelProvider(this).get(GetData.class);
        gD.setIndex(index);
        gD.setUrl(url);
        gD.setContext(MainActivity.this);
        gD.getTest().observe(this, info -> {

            try {
                texQues = info.getString("question");
                texA = info.getString("answerA");
                texB = info.getString("answerB");
                texC = info.getString("answerC");
                texD = info.getString("answerD");
                texCorr = info.getString("correctAns");

                tQ.setText(texQues);
                tA.setText(texA);
                tB.setText(texB);
                tC.setText(texC);
                tD.setText(texD);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        });

//--------------------------------------------------------------------------------------------------//on-click listeners



    }
}
