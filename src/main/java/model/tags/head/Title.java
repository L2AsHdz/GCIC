package model.tags.head;

import model.tags.Tag;

/**
 *
 * @date 27/04/2021
 * @time 01:39:53
 * @author asael
 */
public class Title extends Tag {

    private String title;

    public Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
