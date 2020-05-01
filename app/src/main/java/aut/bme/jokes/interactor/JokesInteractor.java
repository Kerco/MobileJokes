package aut.bme.jokes.interactor;

import javax.inject.Inject;

import aut.bme.jokes.model.JokeModel;
import aut.bme.jokes.network.JokesApi;
import retrofit2.Call;
import retrofit2.Response;

public class JokesInteractor {
    JokesApi jokesApi;

    @Inject
    public JokesInteractor(JokesApi jokesApi) {
        this.jokesApi = jokesApi;
    }

    public JokeModel getJoke() throws Exception {

        Call<JokeModel> jokeModelCall = jokesApi.getJoke();

        Response<JokeModel> response = jokeModelCall.execute();
        if(response.code() != 200) {
            throw new Exception("Result code is not 200");
        }

        return response.body();
    }

}
