package davidchan.pocketchef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/1/2016.
 */

public class Instruction implements Serializable {

    private String instruction;
    private double duration;

    public Instruction() {
        instruction = "";
        duration = 0;
    }

    public Instruction(String instruction, double duration) {
        this.instruction = instruction;
        this.duration = duration;
    }

    public String getInstruction() {
        return instruction;
    }

    public double getDuration() {
        return duration;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

}
