package validator.greaterorequal;

import model.scripting.Expresion;
import model.scripting.TipoDato;
import static model.scripting.TipoDato.BOOLEAN;
import static model.scripting.TipoDato.DECIMAL;
import validator.OperatorValidator;

/**
 *
 * @date 13/05/2021
 * @time 09:59:44
 * @author asael
 */
public class GreaterOrEqualValidator extends OperatorValidator {

    public GreaterOrEqualValidator() {
    }

    @Override
    public Expresion validate(Expresion expr1, Expresion expr2) {
        if (expr1.getTipo() != null && expr2.getTipo() != null) {
            switch (expr1.getTipo()) {
                case INTEGER, DECIMAL -> setTipos(expr2, new TipoDato[]{BOOLEAN,  null,    BOOLEAN,  null,    null});
                default               -> setTipos(expr2, new TipoDato[]{null,     null,    null,     null,    null});
            }
            expr.setText(expr1.getText() + ">=" + expr2.getText());
        }

        return expr;
    }

}
