package com.example.gboard;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GeminiService {
    @POST("{model}:generateContent")
    Call<GeminiResponse> generateContent(
            @Path(value = "model", encoded = true) String model,
            @Query("key") String apiKey,
            @Body GeminiRequest request
    );

}
