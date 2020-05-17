package aut.bme.jokes.repository;

import android.content.Context;

import javax.inject.Singleton;

import aut.bme.jokes.model.Joke;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    private Context context;

    public RepositoryModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    public JokesRepository provideRepository() {return new JokesRepository(context);}
}
