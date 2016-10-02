package davidchan.pocketchef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/1/2016.
 */

public class Ingredient implements Serializable {

    private List<String> ingredients;
    private double amount;
    private MEASUREMENT format;

    public enum MEASUREMENT {
        Cup,
        Tbsp,
        Tsp,
        Oz,
        Lb,
        Error
    }

    public Ingredient() {
        ingredients = new ArrayList<String>();
        amount = 0;
        format = MEASUREMENT.Error;
    }

    public Ingredient(List<String> ingredients, double amount, MEASUREMENT format) {
        this.ingredients = ingredients;
        this.amount = amount;
        this.format = format;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public double getAmount() {
        return amount;
    }

    public MEASUREMENT getFormat() {
        return format;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setFormat(MEASUREMENT format) {
        this.format = format;
    }

}
