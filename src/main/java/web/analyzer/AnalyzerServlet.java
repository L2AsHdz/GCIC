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
import datos.CaptchaDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Captcha;
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
    private final CaptchaDAO captchaDAO = new CaptchaDAO();

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

        if (errores.isEmpty()) {
            GCIC gcic = analyzer.getGcic();
            String PATH_CAPTCHAS = "/home/asael/NetBeansProjects/GCIC/src/main/webapp/captchas/";
            Generator htmlGenerator = new HtmlGenerator(gcic);
            createDirectory(PATH_CAPTCHAS);
            saveFile(PATH_CAPTCHAS + gcic.getParameterValue("id") + ".html", htmlGenerator.generate());

            List<Captcha> captchas;
            if (!captchaDAO.exists()) {
                captchas = new ArrayList();
            } else {
                captchas = captchaDAO.getObject();
            }
            captchas.add(new Captcha(gcic.getParameterValue("id"),
                    gcic.getParameterValue("name"),
                    "0", "0", "0", LocalDate.now().toString()));

            captchaDAO.create(captchas);

            request.setAttribute("vars", analyzer.getVariables());
        } else {
            request.setAttribute("errores", errores);
        }

        request.setAttribute("inputText", inputText);

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
