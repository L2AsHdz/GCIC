package model.scripting.statement;

import model.scripting.Instruction;

/**
 *
 * @date 13/05/2021
 * @time 19:59:02
 * @author asael
 */
public class Assignment implements Instruction {

    private String variable;
    private String expresion;

    public Assignment(String variable, String expresion) {
        this.variable = variable;
        this.expresion = expresion;
    }

    public Assignment() {
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
}
