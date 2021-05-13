package validator.or;

import model.scripting.Expresion;
import model.scripting.TipoDato;
import static model.scripting.TipoDato.BOOLEAN;
import validator.OperatorValidator;

/**
 *
 * @date 13/05/2021
 * @time 09:34:47
 * @author asael
 */
public class OrValidator extends OperatorValidator {

    public OrValidator() {
    }

    @Override
    public Expresion validate(Expresion expr1, Expresion expr2) {
        switch (expr1.getTipo()) {
            case BOOLEAN    -> setTipos(expr2, new TipoDato[]{null,  null, null, null, BOOLEAN});
            default         -> setTipos(expr2, new TipoDato[]{null,  null, null, null, null});
        }
        expr.setText(expr1.getText() + "||" + expr2.getText());

        return expr;
    }

}
