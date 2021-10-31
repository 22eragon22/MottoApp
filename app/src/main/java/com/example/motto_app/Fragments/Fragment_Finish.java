package com.example.motto_app.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.motto_app.Interfaces.APIInterface;
import com.example.motto_app.Objects.MottoContent;
import com.example.motto_app.R;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Fragment_Finish extends Fragment {

//--------------------------------------------------------------------------------------------------declaring variables
    TextView tScore, tMotto;

    int index, score, size;

//--------------------------------------------------------------------------------------------------linking values
    public static Fragment_Finish newInstance(int sc, int sz) {
        Fragment_Finish FF = new Fragment_Finish();
        Bundle args = new Bundle();

        args.putInt("Score", sc);
        args.putInt("Size", sz);

        FF.setArguments(args);
        return FF;
    }

//--------------------------------------------------------------------------------------------------getting values
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        score = getArguments().getInt("Score", 0);
        size = getArguments().getInt("Size", 0);
    }

//--------------------------------------------------------------------------------------------------initializing variables
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment__finish, container, false);

        tScore = rootView.findViewById(R.id.textScore);
        tMotto = rootView.findViewById(R.id.textMotto);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface api = retrofit.create(APIInterface.class);

        Call<List<MottoContent>> call = api.getMotto();

//--------------------------------------------------------------------------------------------------coding stuff
        call.enqueue(new Callback<List<MottoContent>>() {
            @Override
            public void onResponse(Call<List<MottoContent>> call, Response<List<MottoContent>> response) {
                List<MottoContent> MList = response.body();

                index = new Random().nextInt(MList.size() + 1);
                MottoContent M = MList.get(index);
                tMotto.setText(M.getContent());
                tScore.setText("Final score: " + score + "/" + size);
            }

            @Override
            public void onFailure(Call<List<MottoContent>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return rootView;
    }
}