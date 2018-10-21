package com.timbuchalka.top10downloader.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.com.timbuchalka.top10downloader.Adapters.RecyclerViewAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.timbuchalka.top10downloader.R;
import com.timbuchalka.top10downloader.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    public RecyclerView recyclerView;
    public RequestQueue requestQueue;
    public List<Movie> lstMovie;
    private final String JSON_URL_MOVIES = "http://www.jaimefont.com/mobile/user/getMovies.php?user=dms&pass=1234";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.pb);
        lstMovie = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
        infoButton();
        callButton();
        mailButton();
        jsonrequestMovies();

    }


    private void jsonrequestMovies() {

        StringRequest stringRequestMovies = new StringRequest(Request.Method.POST, JSON_URL_MOVIES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pb.setVisibility(View.GONE);
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        lstMovie = Arrays.asList(gson.fromJson(response, Movie[].class));
                        setuprecyclerview(lstMovie);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequestMovies);
    }

    private void setuprecyclerview(List<Movie> lstMovie) {
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstMovie);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }

    public void infoButton() {
        FloatingActionButton info = findViewById(R.id.floatingActionButtonInfo);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(MainActivity.this, com.timbuchalka.top10downloader.Activities.DevActivity.class);
                startActivity(info);
            }
        });
    }

    public void callButton() {
        FloatingActionButton call = findViewById(R.id.floatingActionButtonCall);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:+306987975385"));
                startActivity(call);
            }
        });
    }

    public void mailButton() {
        FloatingActionButton mail = findViewById(R.id.floatingActionButtonMail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"dmspallas@gmail.com"});  //developer 's email
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "Add your Subject"); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, "Dear Developer," + "");  //Email 's Greeting text
                startActivity(Intent.createChooser(Email, "Send Feedback:"));
            }
        });

    }
}

















