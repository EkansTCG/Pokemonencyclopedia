package com.example.pokemonencyclopedia;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Ability Class to hold all information related to the pokemon ability.
 */
public class Abilities {
    private String Name;
    private String Generation;
    private String Description;
    public Abilities(JSONObject obj) throws JSONException {
        Name = obj.getString("Name");
        Generation = obj.getString("Generation");
        Description = obj.getString("Description");
    }

    public String getName() {
        return Name;
    }

    public String getGeneration() {
        return Generation;
    }

    public String getDescription() {
        return Description;
    }
}
