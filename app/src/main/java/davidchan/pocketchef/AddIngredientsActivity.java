package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddIngredientsActivity extends AppCompatActivity {

    Ingredient ingredients;
    EditText ingredientBox;
    EditText amountBox;
    Spinner measurementSelector;
    ListView listOfIngredients;
    ArrayAdapter<String> adapter;
    int measurement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Bundle ingredientData = getIntent().getExtras().getBundle("ingredientData");
        ingredients = (Ingredient) ingredientData.get("ingredients");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredients);
        Button addIngredient = (Button) findViewById(R.id.add_ingredient);
        Button finishAdding = (Button) findViewById(R.id.add_ingredients_finish);
        ingredientBox = (EditText) findViewById(R.id.ingredient);
        amountBox = (EditText) findViewById(R.id.amount);
        measurementSelector = (Spinner) findViewById(R.id.measurement_selection);
        listOfIngredients = (ListView) findViewById(R.id.ingredients_list_preview);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients.getIngredients());
        listOfIngredients.setAdapter(adapter);

        measurementSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                measurement = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ingredientBox.getText().toString().length() != 0 && amountBox.getText().toString().length() != 0){
                    ingredients.getIngredients().add(ingredientBox.getText().toString());
                    ingredients.setAmount(Double.parseDouble(amountBox.getText().toString()));
                    switch(measurement) {
                        case 0:
                            ingredients.setFormat(Ingredient.MEASUREMENT.Cup);
                            break;
                        case 1:
                            ingredients.setFormat(Ingredient.MEASUREMENT.Tbsp);
                            break;
                        case 2:
                            ingredients.setFormat(Ingredient.MEASUREMENT.Tsp);
                            break;
                        case 3:
                            ingredients.setFormat(Ingredient.MEASUREMENT.Oz);
                            break;
                        case 4:
                            ingredients.setFormat(Ingredient.MEASUREMENT.Lb);
                            break;
                    }
                    adapter.notifyDataSetChanged();
                }
                else {
                    if(ingredientBox.getText().toString().length() == 0 && amountBox.getText().toString().length() == 0) {
                        Toast.makeText(v.getContext(), "Please enter an amount and an ingredient!", Toast.LENGTH_LONG).show();
                    }
                    else if(ingredientBox.getText().toString().length() == 0) {
                        Toast.makeText(v.getContext(), "Please enter an ingredient!", Toast.LENGTH_LONG).show();
                    }
                    else if(amountBox.getText().toString().length() == 0) {
                        Toast.makeText(v.getContext(), "Please enter an amount!", Toast.LENGTH_LONG).show();
                    }
                }
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

    @Override
    public void onBackPressed() {
        Intent data = new Intent();
        Bundle ingredientsData = new Bundle();
        ingredientsData.putSerializable("ingredients", (Serializable) ingredients);
        data.putExtra("ingredientsData", ingredientsData);
        setResult(Activity.RESULT_OK, data);
        finish();
    }

}
