package davidchan.pocketchef;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

        String fileName = "recipes.dat";
        recipes = loadRecipes(fileName);
        if (recipes.isEmpty())
        {
            recipes = new ArrayList <>();

            List<Ingredient> friedRiceIngredients = new ArrayList<>();
            friedRiceIngredients.add(new Ingredient("Rice", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Egg", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Rice", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Egg", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Rice", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Egg", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Rice", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Egg", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Rice", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Egg", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Rice", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Egg", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Rice", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Egg", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Rice", 0, Ingredient.MEASUREMENT.Error));
            friedRiceIngredients.add(new Ingredient("Egg", 0, Ingredient.MEASUREMENT.Error));
            List<Instruction> friedRiceInstructions = new ArrayList<>();
            friedRiceInstructions.add(new Instruction("something", 10));
            friedRiceInstructions.add(new Instruction("water", 5));
            friedRiceInstructions.add(new Instruction("air", 12));
            recipes.add(new Recipe("Fried Rice", friedRiceIngredients, friedRiceInstructions, R.drawable.friedrice));

            List < Ingredient > hotDogIngredients = new ArrayList <>();
            hotDogIngredients.add( new Ingredient( "Hot Dog", 0, Ingredient.MEASUREMENT.Error ) );
            hotDogIngredients.add( new Ingredient( "Bun", 0, Ingredient.MEASUREMENT.Error ) );
            List < Instruction > hotDogInstructions = new ArrayList <>();
            hotDogInstructions.add( new Instruction( "Something", 0 ) );
            recipes.add( new Recipe( "Hot Dogs", hotDogIngredients, hotDogInstructions, R.drawable.friedrice ) );

            //        ImageButton accessRecipeList = (ImageButton) findViewById(R.id.featured_pic);
            List < Instruction > friedRiceInstruction = new ArrayList <>();
            friedRiceInstruction.add( new Instruction( "Rice", 0 ) );
            friedRiceInstruction.add( new Instruction( "Egg", 0 ) );

            recipes.add( new Recipe( "Fried Rice", friedRiceIngredients, R.drawable.friedrice, "Hello this is my world famous recipe." ) );
            recipes.add( new Recipe( "Hot Dogs", hotDogIngredients, R.drawable.hotdog, "Hot dogs suck" ) );
            List < Ingredient > tacoIngredient = new ArrayList <>();
            tacoIngredient.add( new Ingredient( "Ground Beef/Pork", 0, Ingredient.MEASUREMENT.Error ) );
            tacoIngredient.add( new Ingredient( "Tortilla Bun", 0, Ingredient.MEASUREMENT.Error ) );
            tacoIngredient.add( new Ingredient( "Taco Sauce", 0, Ingredient.MEASUREMENT.Error ) );
            tacoIngredient.add( new Ingredient( "Cooking Oil", 0, Ingredient.MEASUREMENT.Error ) );
            tacoIngredient.add( new Ingredient( "Onions", 0, Ingredient.MEASUREMENT.Error ) );
            tacoIngredient.add( new Ingredient( "Salt", 0, Ingredient.MEASUREMENT.Error ) );
            recipes.add( new Recipe( "Taco", tacoIngredient, R.drawable.taco, "Tacos are the best" ) );
        }

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

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Would you like to save your Recipes?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.this.saveRecipes();
                        finish();
                        //close();


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                })
                .show();

    }

    private ArrayList <Recipe> loadRecipes(String fileName)
    {
        ArrayList <Recipe> recipes = new ArrayList <Recipe>(  );
        try
        {
            FileInputStream file = this.openFileInput( fileName );
            ObjectInputStream objectStream = new ObjectInputStream( file );
            recipes = (ArrayList <Recipe> ) objectStream.readObject();
        }
        catch (IOException io)
        {

            Toast.makeText(this, "Failed to Load Recipes. Loading Default Recipes", Toast.LENGTH_SHORT).show();

        }

        catch ( ClassNotFoundException cnf)
        {
            Toast.makeText(this, "Failed to Load Recipes. Loading Defualt Recipes", Toast.LENGTH_SHORT).show();
        }
        return recipes;
    }

    private void saveRecipes()
    {
        try
        {
            FileOutputStream file = this.openFileOutput("recipes.dat", Context.MODE_PRIVATE);
            ObjectOutputStream objectStream = new ObjectOutputStream( file );
            objectStream.writeObject(recipes);
            objectStream.close();
            file.close();
        }
        catch ( IOException io)
        {
            System.out.println("Error - Failed to Process File");
            System.out.println(io);
        }
    }
}
