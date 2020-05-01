package aut.bme.jokes.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.renderscript.ScriptIntrinsicYuvToRGB;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import aut.bme.jokes.model.Joke;
import aut.bme.jokes.model.JokeModel;
import aut.bme.jokes.model.JokesModel;

public class JokesRepository {
    @Inject
    Context context;

    private JokesDatabase jokesDatabase;

    public JokesRepository(){
        jokesDatabase = Room.databaseBuilder(context, JokesDatabase.class, "db_joke").build();
    }


    void Save(final Joke joke){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                jokesDatabase.daoAccess().insertJoke(joke);
                return null;
            }
        }.execute();
    }

    List<JokeModel> getAll() throws Exception {
        try {
            return new AsyncTask<Void, Void, List<JokeModel>>() {

                @Override
                protected List<JokeModel> doInBackground(Void... voids) {
                    return jokesDatabase.daoAccess().getAllJokes();
                }
            }.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    void remove(final Joke model){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                jokesDatabase.daoAccess().deleteJoke(model);
                return null;
            }
        }.execute();
    }



}
