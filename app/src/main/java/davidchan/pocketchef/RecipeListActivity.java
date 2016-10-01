package davidchan.pocketchef;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/30/2016.
 */

public class RecipeListActivity extends AppCompatActivity {

    List<Recipe> recipes;
    ListView recipeListView;
    RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_recipe_list);

        recipes = new ArrayList<Recipe>();
        List<String> friedRiceRecipe = new ArrayList<>();
        friedRiceRecipe.add("Rice");
        friedRiceRecipe.add("Egg");
        recipes.add(new Recipe("Fried Rice", friedRiceRecipe));
        List<String> hotDogRecipe = new ArrayList<>();
        hotDogRecipe.add("Hot Dog");
        hotDogRecipe.add("Bun");
        recipes.add(new Recipe("Hot Dogs", hotDogRecipe));

        final EditText searchBar = (EditText) findViewById(R.id.list_searchbar);
        final String temp = searchBar.getText().toString();
        Button searchButton = (Button) findViewById(R.id.list_search_go);
        recipeListView = (ListView) findViewById(R.id.list_recipe_list);
        adapter = new RecipeAdapter(this, R.layout.recipe_row, recipes);
        recipeListView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getFilter().filter(searchBar.getText());
            }
        });

    }

}
