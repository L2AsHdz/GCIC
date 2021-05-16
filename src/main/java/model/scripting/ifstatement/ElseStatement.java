package model.scripting.ifstatement;

import java.util.List;
import model.scripting.Instruction;

/**
 *
 * @date 15/05/2021
 * @time 11:10:07
 * @author asael
 */
public class ElseStatement implements IfType {
    
    private List<Instruction> instructions;

    public ElseStatement() {
    }

    public ElseStatement(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }
}
