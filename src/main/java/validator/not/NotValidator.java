package validator.not;

import model.scripting.Expresion;
import static model.scripting.TipoDato.BOOLEAN;
import validator.OperatorValidator;

/**
 *
 * @date 13/05/2021
 * @time 09:35:47
 * @author asael
 */
public class NotValidator extends OperatorValidator {

    public NotValidator() {
    }

    @Override
    public Expresion validate(Expresion expr1, Expresion expr2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Expresion validate(Expresion expr1) {
        switch (expr1.getTipo()) {
            case BOOLEAN -> setExpresion(BOOLEAN);
            default -> setExpresion(null);
        }
        expr.setText("!" + expr1.getText());

        return expr;
    }

}
