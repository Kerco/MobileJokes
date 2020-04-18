package aut.bme.jokes.ui.list;

import javax.inject.Inject;

import aut.bme.jokes.interactor.JokesInteractor;
import aut.bme.jokes.repository.JokesRepository;
import aut.bme.jokes.ui.Presenter;

public class ListPresenter extends Presenter<ListScreen> {
    JokesRepository repository;
    JokesInteractor interactor;

    @Inject
    public ListPresenter(JokesRepository jokesRepository, JokesInteractor jokesInteractor) {
        this.repository = jokesRepository;
        this.interactor = jokesInteractor;
    }

}
