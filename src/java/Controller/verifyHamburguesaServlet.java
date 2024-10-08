package Controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "verify-hamburguesa", urlPatterns = {"/verify-hamburguesa"})
public class verifyHamburguesaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Establecer la codificación de la respuesta
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Cookie[] cookies = request.getCookies();
        String idPedido="",nombre = "", tipo = "", carne = "", queso = "", fecha = "", hora = "", instrucciones = "";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // Usar directamente StandardCharsets.UTF_8
                String cookieValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
                switch (cookie.getName()) {
                    case "nombre":
                        nombre = cookieValue;
                        break;
                    case "tipo":
                        tipo = cookieValue;
                        break;
                    case "carne":
                        carne = cookieValue;
                        System.out.println(carne);
                        break;
                    case "queso":
                        queso = cookieValue;
                        break;
                    case "fecha":
                        fecha = cookieValue;
                        break;
                    case "hora":
                        hora = cookieValue;
                        break;
                    case "instrucciones":
                        instrucciones = cookieValue;
                        break;
                    case "idPedido":
                        idPedido = cookieValue;
                        break;
                }
            }
        }

        request.setAttribute("nombre", nombre);
        request.setAttribute("tipo", tipo);
        request.setAttribute("carne", carne);
        request.setAttribute("queso", queso);
        request.setAttribute("fecha", fecha);
        request.setAttribute("hora", hora);
        request.setAttribute("instrucciones", instrucciones);
        request.setAttribute("id", idPedido);
        request.getRequestDispatcher("/jsp/verify.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}