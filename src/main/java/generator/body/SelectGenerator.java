package generator.body;

import model.tags.body.Option;
import model.tags.body.Select;

/**
 *
 * @date 30/04/2021
 * @time 15:18:48
 * @author asael
 */
public class SelectGenerator extends TextTagGenerator {

    private Select select;

    SelectGenerator(Select select) {
        super(select);
        this.select = select;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();

        htmlCode.append("<select id=\"").append(textTag.getParameterValue("id")).append("\" ");
        htmlCode.append("style=\"").append(getStyles()).append("\"").append(">\n");

        select.getOptions().forEach(o -> {
            if (o instanceof Option) {
                Option op = (Option) o;
                htmlCode.append("<option>").append(op.getText()).append("</option>\n");
            }
        });

        htmlCode.append("</select>");

        return htmlCode.toString();
    }

    @Override
    protected String getStyles() {
        StringBuilder styles = new StringBuilder(super.getStyles());

        styles.append(" color:").append(select.getParameterValue("color")).append(";");

        return styles.toString();
    }

}
