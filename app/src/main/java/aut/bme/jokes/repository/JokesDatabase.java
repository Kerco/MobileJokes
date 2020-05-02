package aut.bme.jokes.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import aut.bme.jokes.model.Joke;

@Database(entities = Joke.class, version = 1, exportSchema = false)
public abstract class JokesDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
