package generator.body;

import model.tags.body.TextArea;

/**
 *
 * @date 30/04/2021
 * @time 15:05:31
 * @author asael
 */
public class TextAreaGenerator extends TextTagGenerator {
    
    private final TextArea textArea;

    public TextAreaGenerator(TextArea textArea) {
        super(textArea);
        this.textArea = textArea;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        htmlCode.append("<textarea rows=\"").append(textArea.getParameterValue("rows")).append("\" ");
        htmlCode.append("cols=\"").append(textArea.getParameterValue("cols")).append("\" ");
        htmlCode.append("style=\"").append(getStyles()).append("\" ");
        htmlCode.append("id=\"").append(textArea.getParameterValue("id")).append("\">");
        htmlCode.append("</textarea>");

        return htmlCode.toString();
    }

}
