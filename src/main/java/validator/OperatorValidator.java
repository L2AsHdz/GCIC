package validator;

import model.scripting.Expresion;
import model.scripting.TipoDato;

/**
 *
 * @date 12/05/2021
 * @time 19:41:50
 * @author asael
 */
public abstract class OperatorValidator {
    
    protected Expresion expr = new Expresion(null);

    public abstract Expresion validate(Expresion expr1, Expresion expr2);
    
    protected void setExpresion(TipoDato tipoDato) {
        expr = new Expresion(tipoDato);
    }
    
    protected void setTipos(Expresion expr2, TipoDato dataTypes[]) {
        switch (expr2.getTipo()) {
            case INTEGER -> setExpresion(dataTypes[0]);
            case STRING -> setExpresion(dataTypes[1]);
            case DECIMAL -> setExpresion(dataTypes[2]);
            case CHAR -> setExpresion(dataTypes[3]);
            case BOOLEAN -> setExpresion(dataTypes[4]);
        }
    }
}
