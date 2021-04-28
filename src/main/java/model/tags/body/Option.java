package model.tags.body;

import model.tags.Tag;

/**
 *
 * @date 27/04/2021
 * @time 02:17:43
 * @author asael
 */
public class Option extends Tag {

    private String text;

    public Option(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
