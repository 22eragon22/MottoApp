package com.example.motto_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity {

//--------------------------------------------------------------------------------------------------//declaring variables
    RadioGroup RG;
    RadioButton bA, bB, bC, bD;
    TextView tA, tB, tC, tD, tQ;
    Button bN, bS;
    String texA, texB, texC, texD, texQues, texCorr, texNull;
    String url ="http://10.0.2.2:8080/quiz";
    String url2 ="http://10.0.2.2:8080/motto";
    boolean start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
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

        bS = findViewById(R.id.StartButton);
        bN = findViewById(R.id.NextButton);

        GetData gD = new GetData(MainActivity.this, url, 0, "question");
//--------------------------------------------------------------------------------------------------//on-click listeners


        bS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(gD.getText());
                setContentView(R.layout.activity_main);
            }
        });
    }
}
