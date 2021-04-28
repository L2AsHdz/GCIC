package model.tags.body;

import java.util.List;
import model.tags.Parametro;

/**
 *
 * @date 27/04/2021
 * @time 01:58:21
 * @author asael
 */
public class Input extends TextTag {

    public Input(String text, List<Parametro> parametros) {
        super(text);
        initParameters(parametros);
    }

    private void initParameters(List<Parametro> parametros) {
        super.parametros.add(new Parametro("type", "text"));
        super.parametros.add(new Parametro("color", "white"));
        
        parametros.forEach(p -> {
            Parametro aux = find(p.getName());
            
            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }
}
