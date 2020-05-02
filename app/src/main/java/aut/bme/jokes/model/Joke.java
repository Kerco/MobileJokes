package aut.bme.jokes.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Joke {

    @PrimaryKey
    private Integer id;

    private String setup;

    private String punchline;

    public Integer getId() {
        return id;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }
}
