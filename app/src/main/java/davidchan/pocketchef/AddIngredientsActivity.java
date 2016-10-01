package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddIngredientsActivity extends AppCompatActivity {

    List<String> ingredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ingredients = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredients);
        Button addIngredient = (Button) findViewById(R.id.add_ingredient);
        Button finishAdding = (Button) findViewById(R.id.add_ingredients_finish);
        final EditText ingredientBox = (EditText) findViewById(R.id.ingredient);
        EditText amountBox = (EditText) findViewById(R.id.amount);
        Spinner measurementSelector = (Spinner) findViewById(R.id.measurement_selection);

        addIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredients.add("Test");
            }
        });

        finishAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                Bundle ingredientsData = new Bundle();
                ingredientsData.putSerializable("ingredients", (Serializable) ingredients);
                data.putExtra("ingredientsData", ingredientsData);
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });

    }
}
