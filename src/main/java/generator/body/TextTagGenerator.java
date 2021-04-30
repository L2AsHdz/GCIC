package generator.body;

import generator.Generator;
import model.tags.body.TextTag;

/**
 *
 * @date 30/04/2021
 * @time 14:30:13
 * @author asael
 */
public abstract class TextTagGenerator extends Generator {
    
    protected TextTag textTag;

    public TextTagGenerator(TextTag textTag) {
        this.textTag = textTag;
    }

    protected String getStyles() {
        StringBuilder styles = new StringBuilder();
        
        styles.append("font-size:").append(textTag.getParameterValue("font-size")).append(";");
        styles.append(" font-family:").append(textTag.getParameterValue("font-family")).append(";");
        styles.append(" text-align:").append(textTag.getParameterValue("text-align")).append(";");
        
        return styles.toString();
    }
}
