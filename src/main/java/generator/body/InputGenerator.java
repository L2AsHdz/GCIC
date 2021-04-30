package generator.body;

import model.tags.body.Input;

/**
 *
 * @date 30/04/2021
 * @time 03:22:54
 * @author asael
 */
public class InputGenerator extends TextTagGenerator {
    
    private Input input;

    public InputGenerator(Input input) {
        super(input);
        this.input = input;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();

        htmlCode.append("<input type=\"").append(input.getParameterValue("type")).append("\" ");
        htmlCode.append("style=\"").append(getStyles()).append("\" ");
        htmlCode.append("id=\"").append(textTag.getParameterValue("id")).append("\">");

        return htmlCode.toString();
    }

    @Override
    protected String getStyles() {
        StringBuilder styles = new StringBuilder(super.getStyles());

        styles.append(" color:").append(input.getParameterValue("color")).append(";");

        return styles.toString();
    }

}
