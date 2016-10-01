package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddInstructionsActivity extends AppCompatActivity {

    List<String> instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        instructions = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_instructions);

        final EditText instruction = (EditText) findViewById(R.id.instructions_text);
        Button addInstructions = (Button) findViewById(R.id.add_instructions_go);
        Button finishAdding = (Button) findViewById(R.id.add_instructions_finish);

        addInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instructions.add("Test");
            }
        });

        finishAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                Bundle instructionsData = new Bundle();
                instructionsData.putSerializable("instructions", (Serializable) instructions);
                data.putExtra("instructionsData", instructionsData);
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });

    }
}
