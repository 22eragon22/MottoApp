package com.example.motto_app;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    String url = "http://10.0.2.2:8080/";

    @GET("quiz")
    Call<List<QuizQuestion>> getQuizQuestion();
    @POST("quiz")
    Call<String> postAnswer();


    @GET("motto")
    Call<List<MottoContent>> getMotto();
}
