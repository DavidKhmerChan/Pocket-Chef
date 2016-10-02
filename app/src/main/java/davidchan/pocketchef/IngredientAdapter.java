package davidchan.pocketchef;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by David on 10/1/2016.
 */

public class IngredientAdapter extends ArrayAdapter<Ingredient> {

    private List<Ingredient> ingredients;

    public IngredientAdapter(Context context, int resource, List<Ingredient> ingredients) {
        super(context, resource, ingredients);
        this.ingredients = ingredients;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ingredient ingredient = ingredients.get(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.ingredient_row, null);

        TextView overview = (TextView) row.findViewById(R.id.ingredient_overview);
        String measurement = "";
        switch (ingredient.getFormat()) {
            case Cup:
                measurement = "Cup(s)";
                break;
            case Tbsp:
                measurement = "Tbsp(s)";
                break;
            case Tsp:
                measurement = "Tsp(s)";
                break;
            case Oz:
                measurement = "Oz(s)";
                break;
            case Lb:
                measurement = "Lb(s)";
                break;
        }
        overview.setText(ingredient.getAmount() + " " + measurement + " of " + ingredient.getIngredient());

        return row;
    }

}
