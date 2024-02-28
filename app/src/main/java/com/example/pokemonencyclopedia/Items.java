package com.example.pokemonencyclopedia;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Items Class to hold all Pokemon attributes.
 */
public class Items {
    private String Name;
    private String EffectAlt;
    private String Effect;
    private String UsageAttributes;
    private String SpecificCategory;
    private String GeneralCategory;
    public Items(JSONObject obj) throws JSONException {
        Name = obj.getString("Name");
        EffectAlt = obj.getString("Effect (alt.)");
        Effect = obj.getString("Effect");
        UsageAttributes = obj.getString("Usage Attributes");
        SpecificCategory = obj.getString("Specific Category");
        GeneralCategory = obj.getString("General Category");
    }

    public String getName() {
        return Name;
    }

    public String getEffectAlt() {
        return EffectAlt;
    }

    public String getEffect() {
        return Effect;
    }

    public String getUsageAttributes() {
        return UsageAttributes;
    }

    public String getSpecificCategory() {
        return SpecificCategory;
    }

    public String getGeneralCategory() {
        return GeneralCategory;
    }
}
