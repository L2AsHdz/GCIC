package web.captcha;

import datos.CaptchaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Captcha;

/**
 *
 * @date 18/05/2021
 * @time 09:32:39
 * @author asael
 */
@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {
    
    private CaptchaDAO captchaDAO = new CaptchaDAO();

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
            case "listar" -> {
                List<Captcha> captchas = (List<Captcha>) captchaDAO.getObject();
                request.setAttribute("captchas", captchas);
                request.getRequestDispatcher("listadoCaptchas.jsp").forward(request, response);
            }
            case "use" -> {}
        }
    }
}
