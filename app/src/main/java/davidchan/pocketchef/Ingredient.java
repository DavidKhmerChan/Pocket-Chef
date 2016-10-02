package davidchan.pocketchef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/1/2016.
 */

public class Ingredient implements Serializable {

    private String ingredient;
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
        ingredient = "";
        amount = 0;
        format = MEASUREMENT.Error;
    }

    public Ingredient(String ingredient, double amount, MEASUREMENT format) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.format = format;
    }

    public String getIngredient() {
        return ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public MEASUREMENT getFormat() {
        return format;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setFormat(MEASUREMENT format) {
        this.format = format;
    }

}
