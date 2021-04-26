package web.texteditor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @date 26/04/2021
 * @time 03:02:34
 * @author asael
 */
@WebServlet("/textEditor")
public class TextEditorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "export" -> {
                String inputText = request.getParameter("inputText");
                response.setContentType("application/octet-stream");
                response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=captcha.gcic");

                File form = new File("temp.gcic");
                FileWriter fileWriter = new FileWriter(form);
                try ( BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.write(inputText);
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }

                FileInputStream inputStream = new FileInputStream(form);
                try ( PrintWriter out = response.getWriter()) {
                    int i;
                    while ((i = inputStream.read()) != -1) {
                        out.write(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        }
    }
}
