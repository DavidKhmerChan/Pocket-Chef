package davidchan.pocketchef;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
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

        Bundle recipeData = getIntent().getExtras().getBundle("recipeData");
        recipes = (List<Recipe>) recipeData.get("recipes");

        recipes = new ArrayList<Recipe>();
        List<String> friedRiceRecipe = new ArrayList<>();
        friedRiceRecipe.add("Rice");
        friedRiceRecipe.add("Egg");
        friedRiceRecipe.add("Rice");
        friedRiceRecipe.add("Egg");
        friedRiceRecipe.add("Rice");
        friedRiceRecipe.add("Egg");
        friedRiceRecipe.add("Rice");
        friedRiceRecipe.add("Egg");
        friedRiceRecipe.add("Rice");
        friedRiceRecipe.add("Egg");
        friedRiceRecipe.add("Rice");
        friedRiceRecipe.add("Egg");
        friedRiceRecipe.add("Rice");
        friedRiceRecipe.add("Egg");
        friedRiceRecipe.add("Rice");
        friedRiceRecipe.add("Egg");

        recipes.add(new Recipe("Fried Rice", friedRiceRecipe, R.drawable.friedrice));
        List<String> hotDogRecipe = new ArrayList<>();
        hotDogRecipe.add("Hot Dog");
        hotDogRecipe.add("Bun");
        recipes.add(new Recipe("Hot Dogs", hotDogRecipe, R.drawable.friedrice));

        final EditText searchBar = (EditText) findViewById(R.id.list_searchbar);
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

        recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView search = (TextView) findViewById(R.id.list_searchbar);
                Intent intent = new Intent(RecipeListActivity.this , CookingStartActivity.class);
                Bundle bundle= new Bundle();
                bundle.putString("recipeName", recipes.get(position).getRecipeName());
                ArrayList<String> listToArrayList = new ArrayList<String>();
                Iterator i =recipes.get(position).getIngredients().iterator();
                while(i.hasNext()){
                    listToArrayList.add(i.next().toString());
                }
                bundle.putStringArrayList("ingredients", listToArrayList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        
    }
}
