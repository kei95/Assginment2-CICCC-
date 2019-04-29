package com.example.assginment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner mSpinner;

    private static String[] imgRes = {
            "catch_me_if_you_can",
            "flight_club",
            "forrest_gump",
            "the_godfather",
            "good_will_hunting",
            "pulp_fiction",
            "the_hangover",
            "the_shawshank_redemption",
            "titanic"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button -> OnClickListener
        //Spinner -> OnItemSelectedLister

        mSpinner = findViewById(R.id.spinner);
        // pass anonymous
        mSpinner.setOnItemSelectedListener(this);

    }

    private String getSummary(String name){

        int resId = getResources().getIdentifier(name, "raw", getPackageName());
        String summary="";
        Scanner in = new Scanner(getResources().openRawResource(resId));
        while(in.hasNext()){
            summary += in.nextLine();
        }
        return summary;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] movies = getResources().getStringArray(R.array.movies);
        Toast.makeText(this, movies[position], Toast.LENGTH_LONG).show();
        ImageView posterIV = findViewById(R.id.imageView);

        int imgReses = getResources().getIdentifier(imgRes[position], "drawable", getPackageName());
        posterIV.setImageResource(imgReses);

        String summary = getSummary(imgRes[position]);
        TextView summaryTV = findViewById(R.id.SummaryTV);
        summaryTV.setText(summary);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent){
    }
}
