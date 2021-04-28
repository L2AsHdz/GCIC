package model.tags.body;

import java.util.List;
import model.tags.Parametro;

/**
 *
 * @date 27/04/2021
 * @time 02:44:51
 * @author asael
 */
public class Button extends TextTag {

    public Button(String text, List<Parametro> parametros) {
        super(text);
        initParametros(parametros);
    }

    private void initParametros(List<Parametro> parametros) {
        super.parametros.add(new Parametro("color", "white"));
        super.parametros.add(new Parametro("background", "black"));

        parametros.forEach(p -> {
            Parametro aux = find(p.getName());

            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }
}
