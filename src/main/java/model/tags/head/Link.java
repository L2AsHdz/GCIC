package model.tags.head;

import java.util.ArrayList;
import java.util.List;
import model.tags.Parametro;
import model.tags.Tag;

/**
 *
 * @date 27/04/2021
 * @time 01:35:02
 * @author asael
 */
public class Link extends Tag {

    public Link(List<Parametro> parametros) {
        initParameters(parametros);
    }

    private void initParameters(List<Parametro> parametros) {
        super.parametros = new ArrayList();
        super.parametros.add(new Parametro("href", "http://www.google.com"));
        
        parametros.forEach(p -> {
            Parametro aux = find(p.getName());
            
            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }
}
