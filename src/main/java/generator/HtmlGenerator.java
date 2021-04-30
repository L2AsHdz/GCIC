package generator;

import generator.body.BodyGenerator;
import model.tags.GCIC;
import model.tags.body.Body;
import model.tags.head.Head;

/**
 *
 * @date 29/04/2021
 * @time 02:35:47
 * @author asael
 */
public class HtmlGenerator extends Generator {
    
    private GCIC gcic;

    public HtmlGenerator(GCIC gcic) {
        this.gcic = gcic;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        addLine("<!DOCTYPE html>", 0);
        addLine("<html>", 0);
        //head
        addLine("<head>", 1);
        addLine("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">", 2);

        HeadGenerator headG = new HeadGenerator((Head) gcic.getHead());
        addLine(headG.generate(), 2);
        
        //extras css
        addLine("<link rel=\"stylesheet\" href=\"/GCIC/css/bootstrap.css\">", 2);
        addLine("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.2/css/all.css\">", 2);
        addLine("</head>", 1);
        //fin head

        //body
        addLine("<body style=\"background:"+((Body) gcic.getBody()).getParameterValue("background")+"\">", 1);
        //addLine("<div class=\"container-fluid\">", 2);
        //addLine("<div class=\"row\">", 3);
        //addLine("<div class=\"col-2\"></div>", 4);
        //addLine("<div class=\"col-8\">", 4);
        
        Generator bodyG = new BodyGenerator((Body) gcic.getBody());
        addLine(bodyG.generate(), 2);
        
        //addLine("</div>", 4);
        //addLine("</div>", 3);
        //addLine("</div>", 2);

        //extras js
        addLine("<script src=\"/GCIC/js/jquery-3.6.0.js\"></script>", 2);
        addLine("<script src=\"/GCIC/js/popper.js\"></script>", 2);
        addLine("<script src=\"/GCIC/js/bootstrap.js\"></script>", 2);
        addLine("</body>", 1);
        //fin body

        addLine("</html>", 0);
        
        return htmlCode.toString();
    }
     
}
