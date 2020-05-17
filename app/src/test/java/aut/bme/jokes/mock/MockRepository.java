package aut.bme.jokes.mock;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import aut.bme.jokes.model.Joke;
import aut.bme.jokes.repository.JokesRepository;

public class MockRepository extends JokesRepository {

    public static List<Joke> mockTable = new ArrayList<>();
    public MockRepository(Context context) {
        super(context);

        Joke mockEntity = new Joke();
        mockEntity.setId(1);
        mockEntity.setSetup("Test Setup");
        mockEntity.setPunchline("Test Punchline");
        mockTable.add(mockEntity);
    }


    @Override
    public void Save(Joke joke) {
        mockTable.add(joke);
    }

    @Override
    public List<Joke> getAll() {
        return mockTable;
    }

    @Override
    public void remove(Joke joke) {
        mockTable.removeIf(boredActivityEntity -> boredActivityEntity.getId() == joke.getId());
    }
}
