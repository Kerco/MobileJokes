package aut.bme.jokes.mock;

import android.content.Context;

import javax.inject.Singleton;

import aut.bme.jokes.repository.JokesRepository;
import aut.bme.jokes.repository.RepositoryModule;
import dagger.Module;
import dagger.Provides;

@Module
public class MockRepositoryModule extends RepositoryModule {
    Context context;

    public MockRepositoryModule(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    @Singleton
    @Provides
    public JokesRepository provideRepository() {
        return new MockRepository(context);
    }
}
