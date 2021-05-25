package com.abachapp.hrmmobileapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("getallusers")
    Call<User> getusers();
}
