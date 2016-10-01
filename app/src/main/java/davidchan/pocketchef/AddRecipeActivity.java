package davidchan.pocketchef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredients);
        boolean AddIngredient = false;

        Button button3 = (Button) findViewById(R.id.button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Ingredient = (EditText) findViewById(R.id.ingredient);
                ArrayList<String> IngredientList = new ArrayList<String>();
                IngredientList.add(Ingredient.getText().toString());
            }
        });

        while(AddIngredient)
        {
            Button button2=(Button)findViewById(R.id.button);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    EditText Ingredient = (EditText) findViewById(R.id.ingredient);
                    ArrayList<String> IngredientList = new ArrayList<String>();
                    IngredientList.add(Ingredient.getText().toString());
                }
            });




            Button button=(Button)findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    boolean AddIngredient = false;
                }
            });
        }
    }
}
