package aut.bme.jokes;

import javax.inject.Singleton;

import aut.bme.jokes.network.NetworkModule;
import aut.bme.jokes.repository.RepositoryModule;
import aut.bme.jokes.ui.main.MainActivity;
import aut.bme.jokes.ui.UIModule;
import aut.bme.jokes.ui.details.DetailsActivity;
import aut.bme.jokes.ui.list.ListActivity;
import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, RepositoryModule.class})
public interface JokesApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(ListActivity mainActivity);
    void inject(DetailsActivity mainActivity);
}
