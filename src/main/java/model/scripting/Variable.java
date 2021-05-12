package model.scripting;

/**
 *
 * @date 12/05/2021
 * @time 10:43:38
 * @author asael
 */
public class Variable {
    
    private String id;
    private TipoDato type;
    private String valor;
    private String modo;
    private String process;

    public Variable(String id, TipoDato type, String valor, String modo, String process) {
        this.id = id;
        this.type = type;
        this.valor = valor;
        this.modo = modo;
        this.process = process;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoDato getType() {
        return type;
    }

    public void setType(TipoDato type) {
        this.type = type;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
