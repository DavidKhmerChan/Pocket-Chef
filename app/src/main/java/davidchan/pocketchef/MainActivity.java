package davidchan.pocketchef;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.setting:
                Intent intent = new Intent(this, Settings.class);
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

    public void openRecipeList(View view) {
    }

    public void addRecipe(View view) {
        Intent newRecipe = new Intent(this, AddRecipe.class);
        startActivity(newRecipe);
    }
}
