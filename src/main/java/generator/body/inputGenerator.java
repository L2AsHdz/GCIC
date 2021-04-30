package generator.body;

import generator.Generator;
import model.tags.body.Input;

/**
 *
 * @date 30/04/2021
 * @time 03:22:54
 * @author asael
 */
public class inputGenerator extends Generator {
    
    private final Input input;

    public inputGenerator(Input input) {
        this.input = input;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        addLine("<input type=\""+input.getParameterValue("type")+"\">"+input.getText()+"</input>", 0);

        return htmlCode.toString();
    }

}
