package model.tags.head;

import java.util.List;
import model.tags.Tag;

/**
 *
 * @date 26/04/2021
 * @time 16:56:43
 * @author asael
 */
public class Head extends Tag {

    private List<Tag> etiquetas;

    public Head(List<Tag> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Tag> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Tag> etiquetas) {
        this.etiquetas = etiquetas;
    }
}
