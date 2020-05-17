package aut.bme.jokes.mock;

import android.content.Context;

import javax.inject.Singleton;

import aut.bme.jokes.network.JokesApi;
import aut.bme.jokes.network.NetworkModule;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MockNetworkModule extends NetworkModule {
    public MockNetworkModule(Context context) {
        super(context);
    }

    @Override
    @Provides
    @Singleton
    public JokesApi provideJokesApi(Retrofit.Builder retrofitBuilder) {
        return new MockJokeApi();
    }
}
