package generator;

import model.tags.head.Head;
import model.tags.head.Title;

/**
 *
 * @date 29/04/2021
 * @time 02:36:01
 * @author asael
 */
public class HeadGenerator extends Generator {
    
    private Head head;

    public HeadGenerator(Head head) {
        this.head = head;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        head.getEtiquetas().forEach(e -> {
            if (e instanceof Title) {
                Title t = (Title) e;
                addLine("<title>"+t.getTitle()+"</title>", 0);
            }
        });
        
        return htmlCode.toString();
    }
    
    
}
