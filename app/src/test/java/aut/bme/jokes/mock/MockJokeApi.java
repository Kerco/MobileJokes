package aut.bme.jokes.mock;

import java.io.IOException;

import aut.bme.jokes.model.JokeModel;
import aut.bme.jokes.network.JokesApi;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockJokeApi implements JokesApi {
    @Override
    public Call<JokeModel> getJoke() {
        JokeModel joke = new JokeModel();
        joke.setId(1);
        joke.setSetup("Test Setup");
        joke.setPunchline("Test Punchline");

        Call<JokeModel> call = new Call<JokeModel>() {
            @Override
            public Response<JokeModel> execute() throws IOException {
                return Response.success(joke);
            }

            @Override
            public void enqueue(Callback<JokeModel> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<JokeModel> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }

            @Override
            public Timeout timeout() {
                return null;
            }
        };

        return call;
    }
}

