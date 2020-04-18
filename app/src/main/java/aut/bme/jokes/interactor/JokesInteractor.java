package aut.bme.jokes.interactor;

import javax.inject.Inject;

import aut.bme.jokes.network.JokesApi;

public class JokesInteractor {
    JokesApi jokesApi;

    @Inject
    public JokesInteractor(JokesApi jokesApi) {
        this.jokesApi = jokesApi;
    }

}
