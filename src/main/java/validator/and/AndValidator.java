package validator.and;

import model.scripting.Expresion;
import model.scripting.TipoDato;
import static model.scripting.TipoDato.*;
import validator.OperatorValidator;

/**
 *
 * @date 12/05/2021
 * @time 20:57:05
 * @author asael
 */
public class AndValidator extends OperatorValidator {

    public AndValidator() {
    }

    @Override
    public Expresion validate(Expresion expr1, Expresion expr2) {
        switch (expr1.getTipo()) {
            case BOOLEAN    -> setTipos(expr2, new TipoDato[]{null,  null, null, null, BOOLEAN});
            default         -> setTipos(expr2, new TipoDato[]{null,  null, null, null, null});
        }
        expr.setText(expr1.getText() + "&&" + expr2.getText());

        return expr;
    }

}
