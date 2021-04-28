package model.tags.body;

import java.util.List;
import model.tags.Parametro;

/**
 *
 * @date 27/04/2021
 * @time 02:03:43
 * @author asael
 */
public class TextArea extends TextTag {

    public TextArea(String text, List<Parametro> parametros) {
        super(text);
        initParameters(parametros);
    }

    private void initParameters(List<Parametro> parametros) {
        super.parametros.add(new Parametro("cols", "25"));
        super.parametros.add(new Parametro("rows", "10"));
        
        parametros.forEach(p -> {
            Parametro aux = find(p.getName());
            
            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }
}
