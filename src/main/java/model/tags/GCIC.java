package model.tags;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @date 26/04/2021
 * @time 16:56:26
 * @author asael
 */
public class GCIC extends Tag {

    private Tag head;
    private Tag body;

    public GCIC(Tag head, Tag body, List<Parametro> parametros) {
        this.head = head;
        this.body = body;
        initParameters(parametros);
    }

    public Tag getHead() {
        return head;
    }

    public void setHead(Tag head) {
        this.head = head;
    }

    public Tag getBody() {
        return body;
    }

    public void setBody(Tag body) {
        this.body = body;
    }

    private void initParameters(List<Parametro> parametros) {
        super.parametros = new ArrayList();
        super.parametros.add(new Parametro("id", "1"));
        super.parametros.add(new Parametro("name", "DefaultCaptcha"));
        
        parametros.forEach(p -> {
            Parametro aux = find(p.getName());
            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }
    
}
