package model.tags;

/**
 *
 * @date 26/04/2021
 * @time 19:33:01
 * @author asael
 */
public class Parametro {

    private String name;
    private String value;

    public Parametro() {
    }

    public Parametro(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
