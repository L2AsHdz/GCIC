package model.scripting.statement;

import model.scripting.TipoDato;

/**
 *
 * @date 13/05/2021
 * @time 19:48:22
 * @author asael
 */
public class FullStatement implements Statement {

    private TipoDato type;
    private boolean isGlobal;
    private String variables[];
    private String expresion;

    public FullStatement() {
    }

    public TipoDato getType() {
        return type;
    }

    public void setType(TipoDato type) {
        this.type = type;
    }

    public boolean isIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(boolean isGlobal) {
        this.isGlobal = isGlobal;
    }

    public String[] getVariables() {
        return variables;
    }

    public void setVariables(String[] variables) {
        this.variables = variables;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
}
