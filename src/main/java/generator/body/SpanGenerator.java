package generator.body;

import model.tags.body.Span;

/**
 *
 * @date 30/04/2021
 * @time 02:27:54
 * @author asael
 */
public class SpanGenerator extends TextTagGenerator {

    public SpanGenerator(Span span) {
        super(span);
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();

        addLine("<span style=\"" + getStyles() + "\" id=\"" + textTag.getParameterValue("id") + "\">" + textTag.getText() + "</span>", 0);

        return htmlCode.toString();
    }

    @Override
    protected String getStyles() {
        StringBuilder styles = new StringBuilder(super.getStyles());
        
        styles.append(" color:").append(((Span)textTag).getParameterValue("color")).append(";");
        
        return styles.toString();
    }
    
    

}
