package aut.bme.jokes.mock;

import aut.bme.jokes.model.JokeModel;
import aut.bme.jokes.network.JokesApi;
import retrofit2.Call;

public class MockJokesApi implements JokesApi {
    @Override
    public Call<JokeModel> getJoke() {
        return null;
    }
}
