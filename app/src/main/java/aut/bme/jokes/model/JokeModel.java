package aut.bme.jokes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JokeModel {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("setup")
    @Expose
    private String setup;

    @SerializedName("punchline")
    @Expose
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
