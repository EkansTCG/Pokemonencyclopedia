package com.example.pokemonencyclopedia;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Moves Class describes movement/fight related attributes.
 */
public class Moves {
    private String Name;
    private String introduced_in;
    private String Type;
    private String Power;
    private String Acc;
    private String PP;
    private String Damage_class;
    private String Effect;
    private String Prob;

    public Moves(JSONObject obj) throws JSONException {
        Name = obj.getString("Name");
        introduced_in = obj.getString("introduced_in");
        Type = obj.getString("Type");
        Power = obj.getString("Power");
        Acc = obj.getString("Acc.");
        PP = obj.getString("PP");
        Damage_class = obj.getString("Damage_class");
        Effect = obj.getString("Effect");
        Prob = obj.getString("Prob. (%)");
    }

    public String getName() {
        return Name;
    }

    public String getIntroduced_in() {
        return introduced_in;
    }

    public String getType() {
        return Type;
    }

    public String getPower() {
        return Power;
    }

    public String getAcc() {
        return Acc;
    }

    public String getPP() {
        return PP;
    }

    public String getDamage_class() {
        return Damage_class;
    }

    public String getEffect() {
        return Effect;
    }

    public String getProb() {
        return Prob;
    }
}
