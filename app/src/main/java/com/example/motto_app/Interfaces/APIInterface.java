package com.example.motto_app.Interfaces;

import com.example.motto_app.Objects.MottoContent;
import com.example.motto_app.Objects.QuizQuestion;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    String url = "http://10.0.2.2:8080/";

    @GET("quiz")
    Call<List<QuizQuestion>> getQuizQuestion();

    @GET("motto")
    Call<List<MottoContent>> getMotto();
}
