package aut.bme.jokes.ui.list;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import aut.bme.jokes.model.JokesModel;

public class ListActivity extends AppCompatActivity implements ListScreen {
    @Inject
    ListPresenter presenter;


    @Override
    public void showActivities(JokesModel jokes) {

    }
}
