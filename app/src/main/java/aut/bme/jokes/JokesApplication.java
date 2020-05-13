package aut.bme.jokes;

import android.app.Application;

import aut.bme.jokes.network.NetworkModule;
import aut.bme.jokes.repository.RepositoryModule;

public class JokesApplication extends Application {

    public static JokesApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerJokesApplicationComponent.builder()
                .repositoryModule(new RepositoryModule(this))
                .networkModule(new NetworkModule(this))
                .repositoryModule(new RepositoryModule(this))
                .build();
    }
}
