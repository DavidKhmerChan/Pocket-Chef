package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Recipe> recipes;
    private final int ADD_RECIPE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recipes = new ArrayList<Recipe>();
        List<String> friedRiceIngredients = new ArrayList<>();
        friedRiceIngredients.add("Rice");
        friedRiceIngredients.add("Egg");
        friedRiceIngredients.add("Rice");
        friedRiceIngredients.add("Egg");
        friedRiceIngredients.add("Rice");
        friedRiceIngredients.add("Egg");
        friedRiceIngredients.add("Rice");
        friedRiceIngredients.add("Egg");
        friedRiceIngredients.add("Rice");
        friedRiceIngredients.add("Egg");
        friedRiceIngredients.add("Rice");
        friedRiceIngredients.add("Egg");
        friedRiceIngredients.add("Rice");
        friedRiceIngredients.add("Egg");
        friedRiceIngredients.add("Rice");
        friedRiceIngredients.add("Egg");
        List<String> friedRiceInstructions = new ArrayList<>();
        friedRiceInstructions.add("Something");

        recipes.add(new Recipe("Fried Rice", friedRiceIngredients, friedRiceInstructions, R.drawable.friedrice));
        List<String> hotDogRecipe = new ArrayList<>();
        hotDogRecipe.add("Hot Dog");
        hotDogRecipe.add("Bun");
        List<String> hotDogInstructions = new ArrayList<>();
        hotDogInstructions.add("Something");
        recipes.add(new Recipe("Hot Dogs", hotDogRecipe, hotDogInstructions, R.drawable.friedrice));

        ImageButton accessRecipeList = (ImageButton) findViewById(R.id.feature_item);
        accessRecipeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent featured = new Intent(v.getContext(), RecipeListActivity.class);
                Bundle recipeData = new Bundle();
                recipeData.putSerializable("recipes", (Serializable) recipes);
                featured.putExtra("recipeData", recipeData);
                startActivity(featured);
            }
        });
 //       startActivity(new Intent(this, RecipeListActivity.class));

        TextView description = (TextView) findViewById(R.id.description);
        description.setText("Blah Blah Blah Blah Blah Blah Blah Blah");

        Button createRecipe = (Button) findViewById(R.id.create_recipe);
        createRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newRecipe = new Intent(v.getContext(), AddRecipeActivity.class);
                Bundle recipeData = new Bundle();
                recipeData.putSerializable("recipes", (Serializable) recipes);
                newRecipe.putExtra("recipeData", recipeData);
                startActivityForResult(newRecipe, ADD_RECIPE);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.setting:
                Intent intent = new Intent(this, SettingsActivity.class);
                this.startActivity(intent);
                break;
            case R.id.category:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ADD_RECIPE:
                if (resultCode == Activity.RESULT_OK) {
                    Bundle temp = data.getExtras().getBundle("recipeData");
                    recipes = (List<Recipe>) temp.get("recipes");
                }
                break;
            default: break;
        }
    }
}
