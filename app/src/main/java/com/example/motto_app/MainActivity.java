package com.example.motto_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;




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

        GetData gD = new GetData(MainActivity.this, url, index, "question");
        gD.RequestGiver();

//--------------------------------------------------------------------------------------------------//on-click listeners
        texCorr = gD.getText();

        bN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
