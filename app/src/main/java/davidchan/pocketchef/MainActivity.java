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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 //       startActivity(new Intent(this, RecipeListActivity.class));
        TextView description = (TextView) findViewById(R.id.description);
        description.setText("Blah Blah Blah Blah Blah Blah Blah Blah");
//        ImageButton featured = (ImageButton) findViewById(R.id.feature_item);
//        featured.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent showFeatured = new Intent(this,RecipeListActivity.class);
//
//            }
//        });
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
        Intent featured = new Intent(this, RecipeListActivity.class);
        startActivity(featured);
    }
}
