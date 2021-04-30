package generator.body;

import generator.Generator;
import java.util.List;
import model.tags.Tag;
import model.tags.body.Body;
import model.tags.body.Br;
import model.tags.body.Button;
import model.tags.body.Div;
import model.tags.body.H1;
import model.tags.body.Img;
import model.tags.body.Input;
import model.tags.body.Option;
import model.tags.body.P;
import model.tags.body.Select;
import model.tags.body.Span;
import model.tags.body.TextArea;

/**
 *
 * @date 30/04/2021
 * @time 02:17:16
 * @author asael
 */
public class BodyGenerator extends Generator {
    
    private final Body body;

    public BodyGenerator(Body body) {
        this.body = body;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        generateTags(body.getEtiquetas());
        
        return htmlCode.toString();
    }
    
    private void generateTags(List<Tag> tags){
        tags.forEach(e -> {
            if (e instanceof Span) {
                Span s = (Span) e;
                Generator spanG = new SpanGenerator(s);
                addLine(spanG.generate(), 0);
            } else if (e instanceof Input) {
                Input i = (Input) e;
                Generator inputG = new inputGenerator(i);
                addLine(inputG.generate(), 0);
            } else if (e instanceof TextArea) {
                TextArea ta = (TextArea) e;
            } else if (e instanceof Select) {
                Select s = (Select) e;
                s.getOptions().forEach(o -> {
                    if (o instanceof Option) {
                        Option op = (Option) o;
                    }
                });
            } else if (e instanceof Div) {
                Div d = (Div) e;
            } else if (e instanceof Img) {
                Img i = (Img) e;
            } else if (e instanceof Br) {
            } else if (e instanceof Button) {
                Button b = (Button) e;
            } else if (e instanceof H1) {
                H1 h = (H1) e;
            } else if (e instanceof P) {
                P pp = (P) e;
            }
        });
    }

}
