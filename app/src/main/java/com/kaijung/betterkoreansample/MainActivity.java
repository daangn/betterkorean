package com.kaijung.betterkoreansample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kaijung.betterkorean.BetterKorean;
import com.kaijung.betterkorean.KoreanAnalyzer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("test", BetterKorean.with("abc").get_은_는_with());

        Log.e("test", BetterKorean.with("우람이").get_이_가_with());

        Log.e("test", BetterKorean.with("사탕").get_이_가_with());

        Log.e("test", BetterKorean.with("사탕").get_을_를_with());

        Log.e("test", BetterKorean.with("집").get_으로_로_with());

        Log.e("test", BetterKorean.with("당근마켓").get_은_는_with());
    }
}
