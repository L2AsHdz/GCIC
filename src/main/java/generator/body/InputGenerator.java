package generator.body;

import model.tags.body.Input;

/**
 *
 * @date 30/04/2021
 * @time 03:22:54
 * @author asael
 */
public class InputGenerator extends TextTagGenerator {

    public InputGenerator(Input input) {
        super(input);
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();

        htmlCode.append("<input type=\"").append(((Input) textTag).getParameterValue("type")).append("\" ");
        htmlCode.append("style=\"").append(getStyles()).append(" color:").append(((Input)textTag).getParameterValue("color"));
        htmlCode.append("; \" id=\"").append(textTag.getParameterValue("id")).append("\">");

        return htmlCode.toString();
    }

}
