package aut.bme.jokes.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import aut.bme.jokes.model.Joke;
import aut.bme.jokes.model.JokeModel;
import aut.bme.jokes.model.JokesModel;

@Dao
public interface DaoAccess {
    @Insert
    void insertJoke(Joke model);

    @Query("SELECT * FROM Joke")
    List<JokeModel> getAllJokes();

    @Delete
    void deleteJoke(Joke model);
}
