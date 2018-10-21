package com.timbuchalka.top10downloader.Activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.timbuchalka.top10downloader.R;


public class CollapseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse);
        //hide the default action bar
        getSupportActionBar().hide();


        //receive data
        String Title = getIntent().getExtras().getString("Title");
        String Director = getIntent().getExtras().getString("Director");
        String m_description = getIntent().getExtras().getString("Description");
        // int Year  = getIntent().getExtras().getInt("Year");
        // int Runtime = getIntent().getExtras().getInt("Runtime");
        //  int Revenue = getIntent().getExtras().getInt("Revenue");
        //  int Votes = getIntent().getExtras().getInt("Votes");


        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView title = findViewById(R.id.title);
        TextView description = findViewById(R.id.description);
        TextView director = findViewById(R.id.director);
        //TextView year = findViewById(R.id.year);
        // TextView runtime = findViewById(R.id.runtime);
        //  TextView revenue = findViewById(R.id.revenue);
        //  TextView votes = findViewById(R.id.votes);

        //set values to each views
        title.setText(Title);
        description.setText(m_description);
        director.setText(Director);
//        year.setText(Year);
        // runtime.setText(Runtime);
        // revenue.setText(Revenue);
        // votes.setText(Votes);

        collapsingToolbarLayout.setTitle(Title);
    }

}
