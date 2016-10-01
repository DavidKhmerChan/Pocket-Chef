package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by hello on 9/30/2016.
 */

public class CookingStartActivity extends Activity{

    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_cookingstart);
        Intent received = getIntent();


        ImageView food = (ImageView) findViewById(R.id.foodImage);

        Button button = (Button) findViewById(R.id.startcooking);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startcooking= new Intent(CookingStartActivity.this, CookingProgressActivity.class);
                startActivity(startcooking);
            }
        });
    }
}
