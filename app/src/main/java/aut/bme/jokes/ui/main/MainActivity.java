package aut.bme.jokes.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import javax.inject.Inject;

import aut.bme.jokes.JokesApplication;
import aut.bme.jokes.R;
import aut.bme.jokes.ui.details.DetailsActivity;
import aut.bme.jokes.ui.list.ListActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {
    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        JokesApplication.injector.inject(this);
    }

    public void showRandomJoke(View view){
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }

    public void showSavedJokes(View view){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
