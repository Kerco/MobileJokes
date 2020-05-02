package aut.bme.jokes.mock;

import javax.inject.Singleton;

import aut.bme.jokes.network.JokesApi;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MockNetworkModule {
    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public JokesApi provideArtistsApi(Retrofit.Builder retrofitBuilder) {
        return new MockJokesApi();
    }
}
