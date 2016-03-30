package com.kaijung.betterkoreansample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.kaijung.betterkorean.BetterKorean;
import com.kaijung.betterkorean.KoreanAnalyzer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String sample_1 = BetterKorean.with("아빠").get_이_가_with() + " 방으로 들어가신다."; //"아빠가 방으로 들어가신다.
        String sample_2 = BetterKorean.with("집").get_으로_로_with() + " 가야지"; //"집으로 가야지

        String region = "서초1동";
        String sample_3 = "\'" + region + "\'" + BetterKorean.with(region).get_을_를() + " 내 지역으로 설정할까요?"; //'서초1동'을 내 지역으로 설정할까요?

        String sample_4 = BetterKorean.with("연필").get_와_과_with() + " " + BetterKorean.with("지우개").get_와_과_with() + " " + BetterKorean.with("자").get_을_를_with() + " " + "주세요";

        StringBuilder builder = new StringBuilder();
        builder.append(sample_1).append("\n");
        builder.append(sample_2).append("\n");
        builder.append(sample_3).append("\n");
        builder.append(sample_4);

        ((TextView)findViewById(R.id.text)).setText(builder.toString());
    }
}
