package aut.bme.jokes.ui.list;

import java.util.List;

import aut.bme.jokes.model.JokeModel;
import aut.bme.jokes.model.JokesModel;

public interface ListScreen {
    void showActivities(List<JokeModel> jokes);
}
