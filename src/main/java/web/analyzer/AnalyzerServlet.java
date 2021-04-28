package web.analyzer;

import analyzer.GCICAnalyzer;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.tags.GCIC;
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
import model.tags.head.Head;
import model.tags.head.Link;
import model.tags.head.Title;

/**
 *
 * @date 28/04/2021
 * @time 01:32:12
 * @author asael
 */
@WebServlet("/analizador")
public class AnalyzerServlet extends HttpServlet {
    
    private GCICAnalyzer analyzer;
    StringBuilder text;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse responsep) throws ServletException, IOException {
        processRequest(request, responsep);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse responsep) throws ServletException, IOException {
        processRequest(request, responsep);
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse responsep) throws ServletException, IOException {
        String inputText = request.getParameter("inputText");
        analyzer = new GCICAnalyzer(inputText);
        analyzer.analyze();
        
        GCIC gcic = analyzer.getGcic();
        
        text = new StringBuilder();
        
        addLine("GCIC: ");
        gcic.getParametros().forEach(p -> addLine("\t" + p.getName() + ": " + p.getValue()));
        
        addLine("Head: ");
        Head head = (Head) gcic.getHead();
        head.getEtiquetas().forEach(e -> {
            if (e instanceof Link) {
                Link l = (Link) e;
                addLine("Link:");
                l.getParametros().forEach(p -> addLine("\t" + p.getName() + ": " + p.getValue()));
            } else if (e instanceof Title) {
                Title t = (Title) e;
                addLine("Title: " + t.getTitle());
            }
        });
        
        addLine("\nBody:");
        Body body = (Body) gcic.getBody();
        printTags(body.getEtiquetas());
        
        request.setAttribute("inputText", inputText);
        request.setAttribute("info", text.toString());
        
        request.getRequestDispatcher("index.jsp").forward(request, responsep);
    }
    
    private void printTags(List<Tag> tags){
        tags.forEach(e -> {
            if (e instanceof Span) {
                Span s = (Span) e;
                addLine("Span: " + s.getText());
                s.getParametros().forEach(p -> addLine("\t" + p.getName() + ": " + p.getValue()));
            } else if (e instanceof Input) {
                Input i = (Input) e;
                addLine("Input: " + i.getText());
                i.getParametros().forEach(p -> addLine("\t" + p.getName() + ": " + p.getValue()));
            } else if (e instanceof TextArea) {
                TextArea ta = (TextArea) e;
                addLine("TextArea: " + ta.getText());
                ta.getParametros().forEach(p -> addLine("\t" + p.getName() + ": " + p.getValue()));
            } else if (e instanceof Select) {
                Select s = (Select) e;
                addLine("Select: ");
                s.getParametros().forEach(p -> addLine("\t" + p.getName() + ": " + p.getValue()));
                s.getOptions().forEach(o -> {
                    if (o instanceof Option) {
                        Option op = (Option) o;
                        addLine("\tOption: " + op.getText());
                    }
                });
            } else if (e instanceof Div) {
                Div d = (Div) e;
                addLine("Div:");
                d.getParametros().forEach(p -> addLine("\t" + p.getName() + ": " + p.getValue()));
                printTags(d.getEtiquetas());
                addLine("Fin div");
            } else if (e instanceof Img) {
                Img i = (Img) e;
                addLine("Img:");
                i.getParametros().forEach(p -> addLine("\t" + p.getName() + ": " + p.getValue()));
            } else if (e instanceof Br) {
                addLine("BR");
            } else if (e instanceof Button) {
                Button b = (Button) e;
                addLine("Button: " + b.getText());
                b.getParametros().forEach(p -> addLine("\t" + p.getName() + ": " + p.getValue()));
            } else if (e instanceof H1) {
                H1 h = (H1) e;
                addLine("H1: " + h.getText());
                h.getParametros().forEach(p -> addLine("\t" + p.getName() + ": " + p.getValue()));
            } else if (e instanceof P) {
                P pp = (P) e;
                addLine("P: " + pp.getText());
                pp.getParametros().forEach(p -> addLine("\t" + p.getName() + ": " + p.getValue()));
            }
        });
    }
    
    private void addLine(String s) {
        text.append(s).append("\n");
    }

}
