package davidchan.pocketchef;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by David on 10/1/2016.
 */

public class InstructionAdapter extends ArrayAdapter<Instruction> {

    private List<Instruction> instructions;

    public InstructionAdapter(Context context, int resource, List<Instruction> instructions) {
        super(context, resource, instructions);
        this.instructions = instructions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Instruction instruction = instructions.get(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.instruction_row, null);

        TextView overview = (TextView) row.findViewById(R.id.instruction_overview);

        overview.setText(instruction.getInstruction() + " - " + instruction.getDuration() + " seconds");

        return row;
    }

}
