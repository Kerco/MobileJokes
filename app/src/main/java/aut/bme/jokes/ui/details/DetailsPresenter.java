package aut.bme.jokes.ui.details;

import javax.inject.Inject;

import aut.bme.jokes.interactor.JokesInteractor;
import aut.bme.jokes.model.Joke;
import aut.bme.jokes.model.JokeModel;
import aut.bme.jokes.repository.JokesRepository;
import aut.bme.jokes.ui.Presenter;

public class DetailsPresenter extends Presenter<DetailsScreen> {

    JokesInteractor interactor;
    JokesRepository repository;

    @Inject
    public DetailsPresenter(JokesInteractor interactor, JokesRepository repository){
        this.interactor = interactor;
        this.repository = repository;
    }

    public void getJoke() throws Exception {
        JokeModel joke = interactor.getJoke();
        screen.showJokeActivity(joke);
    }

    public void saveJoke(JokeModel joke){
        Joke entity = new Joke();
        entity.setId(joke.getId());
        entity.setSetup(joke.getSetup());
        entity.setPunchline(joke.getPunchline());
        repository.Save(entity);
    }

}
