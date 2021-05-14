package validator.equalto;

import model.scripting.Expresion;
import model.scripting.TipoDato;
import static model.scripting.TipoDato.*;
import validator.OperatorValidator;

/**
 *
 * @date 13/05/2021
 * @time 09:38:50
 * @author asael
 */
public class EqualToValidator extends OperatorValidator {

    public EqualToValidator() {
    }

    @Override
    public Expresion validate(Expresion expr1, Expresion expr2) {
        if (expr1.getTipo() != null && expr2.getTipo() != null) {
            switch (expr1.getTipo()) {
                case INTEGER    -> setTipos(expr2, new TipoDato[]{BOOLEAN,  null,    BOOLEAN,  BOOLEAN, BOOLEAN});
                case STRING     -> setTipos(expr2, new TipoDato[]{null,     BOOLEAN, null,     BOOLEAN, null});
                case DECIMAL    -> setTipos(expr2, new TipoDato[]{BOOLEAN,  null,    BOOLEAN,  null,    null});
                case CHAR       -> setTipos(expr2, new TipoDato[]{BOOLEAN,  BOOLEAN, null,     BOOLEAN, null});
                case BOOLEAN    -> setTipos(expr2, new TipoDato[]{BOOLEAN,  null,    null,     null,    BOOLEAN});
            }

            switch (expr1.getTipo()) {
                case INTEGER -> {
                    switch (expr2.getTipo()) {
                        case CHAR -> expr.setText(expr1.getText() + "==" + expr2.getText() + ".charCodeAt(0)");
                        default   -> expr.setText(expr1.getText() + "==" + expr2.getText());
                    }
                }
                case CHAR -> {
                    switch (expr2.getTipo()) {
                        case INTEGER -> expr.setText(expr1.getText() + ".charCodeAt(0)" + "==" + expr2.getText());
                        default      -> expr.setText(expr1.getText() + "==" + expr2.getText());
                    }
                }
                default -> expr.setText(expr1.getText() + "==" + expr2.getText());
            }
        }

        return expr;
    }

}
