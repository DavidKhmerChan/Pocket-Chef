package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Demon on 10/1/2016.
 */

public class GetIngredientsActivity extends Activity
{
    ArrayList<String> IngredientList = new ArrayList<String>();
    protected void onCreate(Bundle saveInstantBundle)
    {
        super.onCreate(saveInstantBundle);
        setContentView(R.layout.activity_add_ingredients);



            Button button=(Button)findViewById(R.id.button2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    EditText Ingredient = (EditText) findViewById(R.id.ingredient);
                    IngredientList.add(Ingredient.getText().toString());
                }
            });

            Button button2=(Button)findViewById(R.id.button);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent returnaction= new Intent(v.getContext(), MainActivity.class);
                    startActivity(returnaction);

                }
            });








    }

}
