package web.analyzer;

import analyzer.GCICAnalyzer;
import generator.Generator;
import generator.HtmlGenerator;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.tags.GCIC;
import static controller.FileController.saveFile;
import static controller.FileController.createDirectory;
import java.util.List;
import model.errores.ErrorAnalisis;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String inputText = request.getParameter("inputText");
        analyzer = new GCICAnalyzer(inputText);
        analyzer.analyze();

        List<ErrorAnalisis> errores = analyzer.getErrores();
        text = new StringBuilder();

        if (errores.isEmpty()) {
            GCIC gcic = analyzer.getGcic();
            String PATH_CAPTCHAS = "/home/asael/NetBeansProjects/GCIC/src/main/webapp/captchas/";
            Generator htmlGenerator = new HtmlGenerator(gcic);
            createDirectory(PATH_CAPTCHAS);
            saveFile(PATH_CAPTCHAS + gcic.getParameterValue("id") + ".html", htmlGenerator.generate());
            text.append("Captcha generado correctamente");
        } else {
            errores.forEach(e -> {
                addLine(e.getDescripcion() + " - " + e.getSolucion());
            });
        }

        request.setAttribute("inputText", inputText);
        request.setAttribute("info", text.toString());

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void addLine(String s) {
        text.append(s).append("\n");
    }
}
