package aut.bme.jokes.ui.list;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import aut.bme.jokes.interactor.JokesInteractor;
import aut.bme.jokes.model.Joke;
import aut.bme.jokes.model.JokeModel;
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

    public void getAll() throws Exception {
        List<Joke> jokes = repository.getAll();
        screen.showActivities(jokes.stream().map(entity -> {
            JokeModel joke = new JokeModel();
            joke.setId(entity.getId());
            joke.setSetup(entity.getSetup());
            joke.setPunchline(entity.getPunchline());
            return joke;
        }).collect(Collectors.toList()));
    }

}
