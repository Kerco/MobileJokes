package aut.bme.jokes;

import aut.bme.jokes.mock.MockNetworkModule;
import aut.bme.jokes.mock.MockRepositoryModule;

public class TestApplication extends JokesApplication{
    @Override
    public void initInjector() {
        injector = DaggerJokesApplicationComponent.builder()
                .repositoryModule(new MockRepositoryModule(this))
                .networkModule(new MockNetworkModule(this))
                .build();
    }

}
