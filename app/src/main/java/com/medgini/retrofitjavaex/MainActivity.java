package com.medgini.retrofitjavaex;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.medgini.retrofitjavaex.adapters.HeroAdapter;
import com.medgini.retrofitjavaex.pojo.Hero;
import com.medgini.retrofitjavaex.servers.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    HeroAdapter heroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        getHeroesFromServer();


    }

    private void getHeroesFromServer() {

        Call<List<Hero>> call = RetrofitClient.getInstance().getMyApi().getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroList = response.body();

                //Adding Adapter
                heroAdapter = new HeroAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(heroAdapter);

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}