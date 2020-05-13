package aut.bme.jokes.ui.details;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import javax.inject.Inject;

import aut.bme.jokes.JokesApplication;
import aut.bme.jokes.R;
import aut.bme.jokes.model.JokeModel;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {
    @Inject
    DetailsPresenter presenter;

    TextView setup;
    TextView punchline;
    JokeModel currentJoke = new JokeModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        JokesApplication.injector.inject(this);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        setup = findViewById(R.id.setuptv);
        punchline = findViewById(R.id.puncchLinetv);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);

        try {
            presenter.getJoke();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findNewJoke(View view) {
        try {
            presenter.getJoke();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveJoke(View view) {
        presenter.saveJoke(currentJoke);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void showJokeActivity(JokeModel jokeModel) {
        currentJoke = jokeModel;
        setup.setText(jokeModel.getSetup());
        punchline.setText(jokeModel.getPunchline());
    }
}
