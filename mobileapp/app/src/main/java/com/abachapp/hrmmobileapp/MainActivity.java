package com.abachapp.hrmmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        getallusers();
    }

    private void getallusers()
    {

        API api= ApiClient.getRetrofit().create(API.class);
        Call<User> call=api.getusers();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                generatedatalist(response.body().getData());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();
                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Warning")
                        .setMessage(t.getMessage())
                        .show();
            }
        });

    }

    private void generatedatalist(List<Datum> h)
    {
        CustomAdapter adapter= new CustomAdapter(h,MainActivity.this);
        LinearLayoutManager layoutManager= new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}