package model.scripting;

/**
 *
 * @date 12/05/2021
 * @time 10:47:21
 * @author asael
 */
public class Expresion {

    private TipoDato tipo;
    private String text;

    public Expresion(TipoDato tipo, String text) {
        this.tipo = tipo;
        this.text = text;
    }

    public TipoDato getTipo() {
        return tipo;
    }

    public void setTipo(TipoDato tipo) {
        this.tipo = tipo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
