package davidchan.pocketchef;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by Demon on 10/1/2016.
 */

public class GetIngredientsActivity extends Activity
{
    protected void onCreate(Bundle saveInstantBundle)
    {
        super.onCreate(saveInstantBundle);
        setContentView(R.layout.activity_ingredients);

        boolean AddIngredient = true;

        while(AddIngredient)
        {
            Button button2=(Button)findViewById(R.id.button2);
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
