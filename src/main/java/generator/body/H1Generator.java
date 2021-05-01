package generator.body;

import model.tags.body.H1;

/**
 *
 * @date 1/05/2021
 * @time 10:36:32
 * @author asael
 */
public class H1Generator extends TextTagGenerator {
    
    private final H1 h1;

    public H1Generator(H1 h1) {
        super(h1);
        this.h1 = h1;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();

        htmlCode.append("<h1 style=\"").append(getStyles()).append("\" ");
        htmlCode.append("id=\"").append(h1.getParameterValue("id")).append("\">");
        htmlCode.append(h1.getText());
        htmlCode.append("</h1>");

        return htmlCode.toString();
    }

    @Override
    protected String getStyles() {
        StringBuilder styles = new StringBuilder(super.getStyles());

        styles.append(" color:").append(h1.getParameterValue("color")).append(";");
        
        return styles.toString();
    }

}
