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
    private List<String> ingredients;
    private List<String> instructions;
    private int filename;
    private RatingBar rateBar;

    public Recipe() {
        recipeName = "";
        ingredients = new ArrayList<>();
    }


    public Recipe(String recipeName, List<String> ingredients, List<String> instructions, int filename) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.filename = filename;
    }

    public Recipe(String recipeName, List<String> ingredients, int filename, String description) {
            this.recipeName = recipeName;
            this.ingredients = ingredients;
            this.filename = filename;
            this.description = description;
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void initializeRating(RatingBar ratingBar)
    {
        rateBar = ratingBar;
    }

    public void setRating(float rating)
    {
        rateBar.setRating( rating );
    }
    public float getRating()
    {
        return rateBar.getRating();
    }
    public RatingBar getRateBar()
    {
        return rateBar;
    }
    
}
