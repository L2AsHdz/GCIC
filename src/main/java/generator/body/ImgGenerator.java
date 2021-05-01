package generator.body;

import generator.Generator;
import model.tags.body.Img;

/**
 *
 * @date 1/05/2021
 * @time 09:00:32
 * @author asael
 */
public class ImgGenerator extends Generator {
    
    private Img img;

    public ImgGenerator(Img img) {
        this.img = img;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        htmlCode.append("<img src=\"").append(img.getParameterValue("src")).append("\"");
        htmlCode.append(" class=\"rounded\" ").append("alt=\"").append(img.getParameterValue("alt")).append("\" ");
        htmlCode.append("width=\"").append(img.getParameterValue("width")).append("\" ");
        htmlCode.append("height=\"").append(img.getParameterValue("height")).append("\"");
        htmlCode.append("id=\"").append(img.getParameterValue("id")).append("\">");
        
        return htmlCode.toString();
    }

}
