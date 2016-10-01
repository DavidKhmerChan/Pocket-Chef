package davidchan.pocketchef;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/30/2016.
 */

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    private List<Recipe> recipes;
    private List<Recipe> filteredRecipes;

    public RecipeAdapter(Context context, int resource, List<Recipe> recipes) {
        super(context, resource, recipes);
        this.recipes = recipes;
        this.filteredRecipes = recipes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (filteredRecipes.size() == 0) {
            return inflater.inflate(R.layout.recipe_row, null);
        }
        Recipe recipe = filteredRecipes.get(position);
        View row = inflater.inflate(R.layout.recipe_row, null);

        TextView recipeName = (TextView) row.findViewById(R.id.recipe_row_name);
        recipeName.setText(recipe.getRecipeName());

        return row;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults results = new FilterResults();
                if (charSequence == null || charSequence.length() == 0) {
                    results.values = recipes;
                    results.count = recipes.size();
                }
                else {
                    List<Recipe> filteredRecipesData = new ArrayList<>();
                    for (Recipe recipe : recipes) {
                        if (recipe.getRecipeName().contains(charSequence)) {
                            filteredRecipesData.add(recipe);
                        }
                    }
                    results.values = filteredRecipesData;
                    results.count = filteredRecipesData.size();
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredRecipes = (List<Recipe>) filterResults.values;
                notifyDataSetChanged();
            }
        };

    }

    @Override
    public int getCount() {
        return filteredRecipes.size();
    }

}
