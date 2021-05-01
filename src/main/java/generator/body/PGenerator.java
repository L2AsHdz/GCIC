package generator.body;

import model.tags.body.P;


/**
 *
 * @date 1/05/2021
 * @time 10:50:19
 * @author asael
 */
public class PGenerator extends TextTagGenerator {
    
    private final P p;

    public PGenerator(P p) {
        super(p);
        this.p = p;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();

        htmlCode.append("<p style=\"").append(getStyles()).append("\">");
        htmlCode.append(p.getText().trim());
        htmlCode.append("</p>");

        return htmlCode.toString();
    }

    @Override
    protected String getStyles() {
        StringBuilder styles = new StringBuilder(super.getStyles());
        
        styles.append(" color:").append(p.getParameterValue("color")).append(";");
        
        return styles.toString();
    }
}
