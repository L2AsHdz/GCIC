package model.tags.body;

import java.util.ArrayList;
import java.util.List;
import model.tags.Parametro;
import model.tags.Tag;

/**
 *
 * @date 26/04/2021
 * @time 16:56:59
 * @author asael
 */
public class Body extends Tag {
    
    private List<Tag> etiquetas;

    public Body(List<Tag> etiquetas, List<Parametro> parametros) {
        this.etiquetas = etiquetas;
        initParameters(parametros);
    }

    public List<Tag> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Tag> etiquetas) {
        this.etiquetas = etiquetas;
    }

    private void initParameters(List<Parametro> parametros) {
        super.parametros = new ArrayList();
        super.parametros.add(new Parametro("background", "black"));
        
        parametros.forEach(p -> {
            Parametro aux = find(p.getName());
            
            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }

}
