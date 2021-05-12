package model.scripting;

import java.util.List;

/**
 *
 * @date 12/05/2021
 * @time 10:22:56
 * @author asael
 */
public class Process {
    
    private String name;
    private List<Instruction> instructions;

    public Process(String name, List<Instruction> instructions) {
        this.name = name;
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
