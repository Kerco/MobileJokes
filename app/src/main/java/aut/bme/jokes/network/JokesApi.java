package aut.bme.jokes.network;

import aut.bme.jokes.model.JokeModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JokesApi {
    @GET("random_joke")
    Call<JokeModel> getJoke();
}
