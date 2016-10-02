package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 9/30/2016.
 */

public class CookingStartActivity extends AppCompatActivity {
    private static final String RATING_CHANGE = "davidchan.pocketchef.rating_change";

    Bundle recipe;
    RatingBar ratingBar;
    int position;
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_cooking_start);

        Intent received = getIntent();
        recipe= received.getExtras();
        position = received.getIntExtra( "position", 0 );
        float rating = received.getFloatExtra( "rating", 0 );
        String recipeName = recipe.getString("recipeName");
        List<Ingredient> ingredientList =(List<Ingredient>) recipe.getSerializable("ingredients");
        IngredientAdapter adapter = new IngredientAdapter(getApplicationContext(), R.layout.ingredient_row, ingredientList);
        ListView recipeList = (ListView) findViewById(R.id.itemList);
        recipeList.setAdapter(adapter);
        ImageView food = (ImageView) findViewById(R.id.foodImage);
        int recipeImage = recipe.getInt("recipeImage");
        food.setImageResource(recipeImage);
        Button button = (Button) findViewById(R.id.startcooking);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startcooking= new Intent(CookingStartActivity.this, CookingProgressActivity.class);
                startcooking.putExtras(recipe);
                startActivity(startcooking);
            }
        });

        ratingBar = (RatingBar) findViewById(R.id.rating_bar );
        ratingBar.setRating( rating );
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
            {
                Intent i = new Intent( );
                i.putExtra( "ratingID", R.id.rating_bar );
                i.putExtra( RATING_CHANGE, ratingBar.getRating() );
                i.putExtra( "position", position );
                setResult( RESULT_OK, i );
            }
        });}

        public static float ratingChange(Intent result)
        {
            return result.getFloatExtra( RATING_CHANGE, (float) 1.2);
        }

    }
