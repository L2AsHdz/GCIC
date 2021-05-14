package validator.minus;

import model.scripting.Expresion;
import model.scripting.TipoDato;
import static model.scripting.TipoDato.*;
import validator.OperatorValidator;

/**
 *
 * @date 12/05/2021
 * @time 20:10:46
 * @author asael
 */
public class MinusValidator extends OperatorValidator {

    public MinusValidator() {
    }

    @Override
    public Expresion validate(Expresion expr1, Expresion expr2) {
        if (expr1.getTipo() != null && expr2.getTipo() != null) {
            switch (expr1.getTipo()) {
                case INTEGER    -> setTipos(expr2, new TipoDato[]{INTEGER,  null, DECIMAL,  INTEGER, INTEGER});
                case STRING     -> setTipos(expr2, new TipoDato[]{null,     null, null,     null,    null});
                case DECIMAL    -> setTipos(expr2, new TipoDato[]{DECIMAL,  null, DECIMAL,  DECIMAL, DECIMAL});
                case CHAR       -> setTipos(expr2, new TipoDato[]{INTEGER,  null, DECIMAL,  INTEGER, null});
                case BOOLEAN    -> setTipos(expr2, new TipoDato[]{INTEGER,  null, DECIMAL,  null,    null});
            }

            switch (expr1.getTipo()) {
                case INTEGER, DECIMAL -> {
                    switch (expr2.getTipo()) {
                        case CHAR -> expr.setText(expr1.getText() + "-" + expr2.getText() + ".charCodeAt(0)");
                        default   -> expr.setText(expr1.getText() + "-" + expr2.getText());
                    }
                }
                case CHAR -> {
                    switch (expr2.getTipo()) {
                        case CHAR -> expr.setText(expr1.getText() + ".charCodeAt(0)" + "-" + expr2.getText() + ".charCodeAt(0)");
                        default   -> expr.setText(expr1.getText() + ".charCodeAt(0)" + "-" + expr2.getText());
                    }
                }
                default -> expr.setText(expr1.getText() + "-" + expr2.getText());
            }
        }

        return expr;
    }

}
