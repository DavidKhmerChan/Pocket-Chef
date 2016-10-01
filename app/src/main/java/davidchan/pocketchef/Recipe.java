package davidchan.pocketchef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/30/2016.
 */

public class Recipe implements Serializable {

    private String recipeName;
    private List<String> ingredients;

    public Recipe() {
        recipeName = "";
        ingredients = new ArrayList<>();
    }

    public Recipe(String recipeName, List<String> ingredients) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

}
