package aut.bme.jokes.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import aut.bme.jokes.model.JokeModel;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {
    @Inject
    DetailsPresenter presenter;


    @Override
    public void showJokeActivity(JokeModel jokeModel) {

    }
}
