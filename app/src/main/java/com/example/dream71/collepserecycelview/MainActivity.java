package com.example.dream71.collepserecycelview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Animation animationUp, animationDown;
    public ArrayList<Pojo> pojoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pojoArrayList = new ArrayList<>();
        pojoArrayList.add(new Pojo("Help 1" , "If you have any question please click this"));
        pojoArrayList.add(new Pojo("Help 2" , "If you have any question please click this"));
        pojoArrayList.add(new Pojo("Help 3" , "If you have any question please click this"));
        pojoArrayList.add(new Pojo("Help 4" , "If you have any question please click this"));
        pojoArrayList.add(new Pojo("Help 5" , "If you have any question please click this"));
        pojoArrayList.add(new Pojo("Help 6" , "If you have any question please click this"));
        pojoArrayList.add(new Pojo("Help 7" , "If you have any question please click this"));
        pojoArrayList.add(new Pojo("Help 8" , "If you have any question please click this"));
        pojoArrayList.add(new Pojo("Help 9" , "If you have any question please click this"));


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        animationUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animationDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);

        RecyclerAdapter recyclerViewAdapter = new RecyclerAdapter(this, animationUp, animationDown , pojoArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
