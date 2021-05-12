package model;

import model.scripting.TipoDato;

/**
 *
 * @date 12/05/2021
 * @time 10:52:34
 * @author asael
 */
public class TypeToken extends Token {

    private TipoDato type;

    public TypeToken(TipoDato type, int linea, int columna, String lexema) {
        super(linea, columna, lexema);
        this.type = type;
    }

    public TipoDato getType() {
        return type;
    }

    public void setType(TipoDato type) {
        this.type = type;
    }
}
