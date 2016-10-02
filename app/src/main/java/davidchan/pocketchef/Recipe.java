package davidchan.pocketchef;

import android.content.Context;
import android.widget.RatingBar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/30/2016.
 */

public class Recipe implements Serializable {

    private String recipeName, description;
    private List<Ingredient> ingredients;
    private List<Instruction> instructions;
    private int filename;
    private float rating;

    public Recipe() {
        recipeName = "";
        ingredients = new ArrayList<>();
        instructions = new ArrayList<>();
        rating = 0;
    }


    public Recipe(String recipeName, List<Ingredient> ingredients, List<Instruction> instructions, int filename) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.filename = filename;
        rating = 0;
    }

    public Recipe(String recipeName, List<Ingredient> ingredients, int filename, String description) {
            this.recipeName = recipeName;
            this.ingredients = ingredients;
            this.filename = filename;
            this.description = description;
            rating = 0;
        }

    public int getFilename() {
        return this.filename;
    }

    public String getDescription() {
        return this.description;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public List<Ingredient> getIngredientObject() {
        return ingredients;
    }

    public List<Instruction> getInstructionObject() {
        return instructions;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setIngredientObject(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public float getRating()
    {
        return rating;
    }

    public void setRating(float rating)
    {
        this.rating = rating;
    }
    
}
