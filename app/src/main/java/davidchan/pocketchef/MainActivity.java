package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Recipe> recipes;
    private final int ADD_RECIPE = 1;
    private final int UPDATE_RECIPE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random rd = new Random();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recipes = new ArrayList<>();

        Ingredient friedRiceIngredients = new Ingredient();
        friedRiceIngredients.getIngredients().add("Rice");
        friedRiceIngredients.getIngredients().add("Egg");
        friedRiceIngredients.getIngredients().add("Rice");
        friedRiceIngredients.getIngredients().add("Egg");
        friedRiceIngredients.getIngredients().add("Rice");
        friedRiceIngredients.getIngredients().add("Egg");
        friedRiceIngredients.getIngredients().add("Rice");
        friedRiceIngredients.getIngredients().add("Egg");
        friedRiceIngredients.getIngredients().add("Rice");
        friedRiceIngredients.getIngredients().add("Egg");
        friedRiceIngredients.getIngredients().add("Rice");
        friedRiceIngredients.getIngredients().add("Egg");
        friedRiceIngredients.getIngredients().add("Rice");
        friedRiceIngredients.getIngredients().add("Egg");
        friedRiceIngredients.getIngredients().add("Rice");
        friedRiceIngredients.getIngredients().add("Egg");
        Instruction friedRiceInstructions = new Instruction();
        friedRiceInstructions.getInstructions().add("Something");
        recipes.add(new Recipe("Fried Rice", friedRiceIngredients, friedRiceInstructions, R.drawable.friedrice));

        Ingredient hotDogIngredients = new Ingredient();
        hotDogIngredients.getIngredients().add("Hot Dog");
        hotDogIngredients.getIngredients().add("Bun");
        Instruction hotDogInstructions = new Instruction();
        hotDogInstructions.getInstructions().add("Something");
        recipes.add(new Recipe("Hot Dogs", hotDogIngredients, hotDogInstructions, R.drawable.hotdog));

//        ImageButton accessRecipeList = (ImageButton) findViewById(R.id.featured_pic);
        Instruction friedRiceInstruction = new Instruction();
        friedRiceInstruction.getInstructions().add("Rice");
        friedRiceInstruction.getInstructions().add("Egg");

        recipes.add(new Recipe("Fried Rice", friedRiceIngredients, R.drawable.friedrice, "Hello this is my world famous recipe."));
        recipes.add(new Recipe("Hot Dogs", hotDogIngredients, R.drawable.hotdog, "Hot dogs suck"));
        Ingredient tacoIngredient = new Ingredient();
        tacoIngredient.getIngredients().add("Ground Beef/Pork");
        tacoIngredient.getIngredients().add("Tortilla Bun");
        tacoIngredient.getIngredients().add("Taco Sauce");
        tacoIngredient.getIngredients().add("Cooking Oil");
        tacoIngredient.getIngredients().add("Onions");
        tacoIngredient.getIngredients().add("Salt");
        recipes.add(new Recipe("Taco", tacoIngredient, R.drawable.taco, "Tacos are the best"));
        ImageButton accessRecipeList = (ImageButton) findViewById(R.id.featured_pic);

        accessRecipeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent featured = new Intent(v.getContext(), RecipeListActivity.class);
                Bundle recipeData = new Bundle();
                recipeData.putSerializable("recipes", (Serializable) recipes);
                featured.putExtra("recipeData", recipeData);
                startActivityForResult(featured, UPDATE_RECIPE);
            }
        });
 //       startActivity(new Intent(this, RecipeListActivity.class));


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

        int randomizer = rd.nextInt(recipes.size());
        TextView description = (TextView) findViewById(R.id.featured_description);
        description.setText(recipes.get(randomizer).getDescription());
        ImageButton featuredItem = (ImageButton) findViewById(R.id.featured_pic);
        featuredItem.setImageResource(recipes.get(randomizer).getFilename());

        TextView title = (TextView) findViewById(R.id.featured_title);
        title.setText("Featured Recipe : " + recipes.get(randomizer).getRecipeName());

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
            case UPDATE_RECIPE:
                if (resultCode == Activity.RESULT_OK) {
                    Bundle temp = data.getExtras().getBundle("recipeData");
                    recipes = (List<Recipe>) temp.get("recipes");
                }
            default: break;
        }
    }
}
