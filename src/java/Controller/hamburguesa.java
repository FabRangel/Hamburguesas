/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import configuration.ConnectionBD;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "hamburguesa", urlPatterns = {"/hamburguesa"})
public class hamburguesa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConnectionBD conexion = new ConnectionBD();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        System.out.println("tamos en doget");
        try {
            String sql = "SELECT MAX(id) + 1 AS siguienteId FROM hamburguesas";
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                int siguienteId = rs.getInt("siguienteId");
                request.setAttribute("siguienteId", siguienteId);
                System.out.println(siguienteId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar conexiones
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        request.getRequestDispatcher("/jsp/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Establecer la codificación para la solicitud y respuesta
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("doPost");
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String tamañoCarneStr = request.getParameter("carne");
        String quesoStr = request.getParameter("queso");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String instrucciones = request.getParameter("instrucciones");
        String idPedido = request.getParameter("idPedido");

        double carne = 0;
        double queso = 0;

        try {
            carne = Double.parseDouble(tamañoCarneStr);
            queso = Double.parseDouble(quesoStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        Cookie cookieNombre = new Cookie("nombre", URLEncoder.encode(nombre, "UTF-8"));
        Cookie cookieTipo = new Cookie("tipo", URLEncoder.encode(tipo, "UTF-8"));
        Cookie cookieCarne = new Cookie("carne", URLEncoder.encode(tamañoCarneStr, "UTF-8"));
        Cookie cookieQueso = new Cookie("queso", URLEncoder.encode(String.valueOf(queso), "UTF-8"));
        Cookie cookieFecha = new Cookie("fecha", URLEncoder.encode(fecha, "UTF-8"));
        Cookie cookieHora = new Cookie("hora", URLEncoder.encode(hora, "UTF-8"));
        Cookie cookieId = new Cookie("idPedido", URLEncoder.encode(idPedido, "UTF-8"));
        Cookie cookieInstrucciones = new Cookie("instrucciones", instrucciones.isEmpty() ? "Ninguna" : URLEncoder.encode(instrucciones, "UTF-8"));

        int maxAge = 60 * 60 * 24; // 1 día
        cookieNombre.setMaxAge(maxAge);
        cookieTipo.setMaxAge(maxAge);
        cookieCarne.setMaxAge(maxAge);
        cookieQueso.setMaxAge(maxAge);
        cookieFecha.setMaxAge(maxAge);
        cookieHora.setMaxAge(maxAge);
        cookieId.setMaxAge(maxAge);
        cookieInstrucciones.setMaxAge(maxAge);

        cookieNombre.setPath("/");
        cookieTipo.setPath("/");
        cookieCarne.setPath("/");
        cookieQueso.setPath("/");
        cookieFecha.setPath("/");
        cookieHora.setPath("/");
        cookieId.setPath("/");
        cookieInstrucciones.setPath("/");

        response.addCookie(cookieNombre);
        response.addCookie(cookieTipo);
        response.addCookie(cookieCarne);
        response.addCookie(cookieQueso);
        response.addCookie(cookieFecha);
        response.addCookie(cookieHora);
        response.addCookie(cookieId);
        response.addCookie(cookieInstrucciones);

        response.sendRedirect(request.getContextPath() + "/verify-hamburguesa");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
