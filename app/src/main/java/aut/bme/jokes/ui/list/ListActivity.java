package aut.bme.jokes.ui.list;

import android.graphics.Canvas;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aut.bme.jokes.JokesApplication;
import aut.bme.jokes.R;
import aut.bme.jokes.model.Joke;
import aut.bme.jokes.model.JokeModel;
import aut.bme.jokes.model.JokesModel;

public class ListActivity extends AppCompatActivity implements ListScreen {
    @Inject
    public ListPresenter presenter;

    private RecyclerView recyclerView;
    private ActivityAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    List<JokeModel> jokes = new ArrayList<JokeModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        JokesApplication.injector.inject(this);

        recyclerView = findViewById(R.id.jokesRv);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ActivityAdapter(jokes);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));



        SwipeController swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                JokeModel model = adapter.dataset.get(position);
                Joke jokeToRemove = new Joke();
                jokeToRemove.setId(model.getId());
                jokeToRemove.setSetup(model.getSetup());
                jokeToRemove.setPunchline(model.getPunchline());
                adapter.dataset.remove(position);
                presenter.repository.remove(jokeToRemove);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, adapter.getItemCount());
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
        try {
            presenter.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void showActivities(List<JokeModel> savedJokes) {
        jokes.clear();
        jokes.addAll(savedJokes);
        adapter.notifyDataSetChanged();
    }
}
