package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddInstructionsActivity extends AppCompatActivity {

    List<Instruction> instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle instructionData = getIntent().getExtras().getBundle("instructionData");
        instructions = (List<Instruction>) instructionData.get("instructions");
        instructions.add(new Instruction());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_instructions);

        final EditText instruction = (EditText) findViewById(R.id.instructions_text);
        Button addInstructions = (Button) findViewById(R.id.add_instructions_go);
        Button finishAdding = (Button) findViewById(R.id.add_instructions_finish);
        ListView listOfInstructions = (ListView) findViewById(R.id.instructions_list_preview);
        final InstructionAdapter adapter = new InstructionAdapter(this, R.layout.instruction_row, instructions);
        listOfInstructions.setAdapter(adapter);

        addInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(instruction.getText().toString().length() != 0){
                    instructions.get(0).setInstruction(instruction.getText().toString());
                    instructions.get(0).setDuration(0); // Dummy value atm.
                    adapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(v.getContext(), "Please enter an instruction!", Toast.LENGTH_LONG).show();
                }
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

    @Override
    public void onBackPressed() {
        Intent data = new Intent();
        Bundle instructionsData = new Bundle();
        instructionsData.putSerializable("instructions", (Serializable) instructions);
        data.putExtra("instructionsData", instructionsData);
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}
