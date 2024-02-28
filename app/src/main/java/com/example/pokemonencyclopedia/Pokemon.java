package com.example.pokemonencyclopedia;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Pokemon Class represents Pokemon entity
 */
public class Pokemon {
    private String id;
    private String name;
    private String rank;
    private String generation;
    private String evolves_from;
    private String type1;
    private String type2;
    private String hp;
    private String atk;
    private String def;
    private String spatk;
    private String spdef;
    private String speed;
    private String total;
    private String height;
    private String weight;
    private String abilities;
    private String desc;

        public Pokemon(JSONObject obj) throws JSONException {
                id = obj.getString("id");
                name = obj.getString("name");
                rank = obj.getString("rank");
                generation = obj.getString("generation");
                evolves_from = obj.getString("evolves_from");
                type1 = obj.getString("type1");
                type2 = obj.getString("type2");
                hp = obj.getString("hp");
                atk = obj.getString("atk");
                def = obj.getString("def");
                spatk = obj.getString("spatk");
                spdef = obj.getString("spdef");
                speed = obj.getString("speed");
                total = obj.getString("total");
                height = obj.getString("height");
                weight = obj.getString("weight");
                abilities = obj.getString("abilities");
                desc = obj.getString("desc");
        }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getGeneration() {
        return generation;
    }

    public String getEvolves_from() {
        return evolves_from;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getHp() {
        return hp;
    }

    public String getAtk() {
        return atk;
    }

    public String getDef() {
        return def;
    }

    public String getSpatk() {
        return spatk;
    }

    public String getSpdef() {
        return spdef;
    }

    public String getSpeed() {
        return speed;
    }

    public String getTotal() {
        return total;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getAbilities() {
        return abilities;
    }
    public String getDesc() {
        return desc;
    }
}
