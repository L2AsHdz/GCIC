package generator.body;

import model.tags.body.Div;

/**
 *
 * @date 1/05/2021
 * @time 11:25:09
 * @author asael
 */
public class DivGenerator extends TextTagGenerator {

    private final Div div;

    public DivGenerator(Div div) {
        super(div);
        this.div = div;
    }
    
    @Override
    public String generate() {
        htmlCode = new StringBuilder();

        htmlCode.append("<div style=\"").append(getStyles()).append("\" ");
        htmlCode.append("id=\"").append(div.getParameterValue("id")).append("\">");
        //htmlCode.append("class=\"").append(div.getParameterValue("class")).append("\">");

        return htmlCode.toString();
    }

    @Override
    protected String getStyles() {
        StringBuilder styles = new StringBuilder(super.getStyles());
        
        styles.append(" color:").append(div.getParameterValue("color")).append(";");
        styles.append(" background:").append(div.getParameterValue("background")).append(";");
        
        return styles.toString();
    }

}
