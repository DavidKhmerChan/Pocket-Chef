package davidchan.pocketchef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/1/2016.
 */

public class Instruction implements Serializable {

    private List<String> instructions;
    private double duration;

    public Instruction() {
        instructions = new ArrayList<>();
        duration = 0;
    }

    public Instruction(List<String> instructions, double duration) {
        this.instructions = instructions;
        this.duration = duration;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public double getDuration() {
        return duration;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

}
