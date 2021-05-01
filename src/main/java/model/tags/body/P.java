package model.tags.body;

import java.util.List;
import model.tags.Parametro;

/**
 *
 * @date 27/04/2021
 * @time 02:56:37
 * @author asael
 */
public class P extends TextTag {

    public P(String text, List<Parametro> parametros) {
        super(text);
        initParameters(parametros);
    }

    private void initParameters(List<Parametro> parametros) {
        super.parametros.add(new Parametro("color", "black"));
        
        parametros.forEach(p -> {
            Parametro aux = find(p.getName());
            
            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }

    
}
