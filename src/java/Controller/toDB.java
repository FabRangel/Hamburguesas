/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import configuration.ConnectionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fgmrr
 */
@WebServlet(name = "to-db", urlPatterns = {"/to-db"})
public class toDB extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet toDB</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet toDB at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ConnectionBD conexion = new ConnectionBD();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Cookie[] cookies = request.getCookies();
        int pedidoId = -1; 

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("idPedido".equals(cookie.getName())) {
                   
                    pedidoId = Integer.parseInt(cookie.getValue());
                    break; 
                }
            }
        }

        
        if (pedidoId != -1) {
            conn = conexion.getConnectionBD();

            String sqlSelect = "SELECT * FROM hamburguesas WHERE id = ?";
            ps = conn.prepareStatement(sqlSelect);
            ps.setInt(1, pedidoId);
            rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                double carne = rs.getDouble("carne");
                double queso = rs.getDouble("queso");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                String instrucciones = rs.getString("instrucciones");

                request.setAttribute("nombre", nombre);
                request.setAttribute("tipo", tipo);
                request.setAttribute("carne", carne);
                request.setAttribute("queso", queso);
                request.setAttribute("fecha", fecha);
                request.setAttribute("hora", hora);
                request.setAttribute("instrucciones", instrucciones);

                 request.getRequestDispatcher("/jsp/successRegister.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Pedido no encontrado");
                request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "ID de pedido no disponible");
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
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
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String tamañoCarneStr = request.getParameter("carne");
        System.out.println("To db:" +tamañoCarneStr);
        String quesoStr = request.getParameter("queso");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String instrucciones = request.getParameter("instrucciones");

        double carne = 0;
        double queso = 0;

        if (tamañoCarneStr != null && !tamañoCarneStr.isEmpty()) {
            try {
                carne = Double.parseDouble(tamañoCarneStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        if (quesoStr != null && !quesoStr.isEmpty()) {
            try {
                queso = Double.parseDouble(quesoStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        ConnectionBD conexion = new ConnectionBD();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO hamburguesas (nombre, tipo, carne, queso, fecha, hora, instrucciones) VALUES (?, ?, ?, ?, ?, ?, ?)";
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);

            ps.setString(1, nombre != null ? nombre : "");
            ps.setString(2, tipo != null ? tipo : "");
            ps.setDouble(3, carne);
            System.out.println(carne);
            ps.setDouble(4, queso);
            ps.setString(5, fecha != null ? fecha : "");
            ps.setString(6, hora != null ? hora : "");
            ps.setString(7, instrucciones != null && !instrucciones.isEmpty() ? instrucciones : "Ninguna");

            int filasInsertadas = ps.executeUpdate();
            if (filasInsertadas > 0) {
                request.setAttribute("mensaje", "Hamburguesa registrada con éxito!");
                response.sendRedirect(request.getContextPath() + "/to-db");
                //request.getRequestDispatcher("/jsp/successRegister.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "Error al registrar tu pedido de hamburguesa, intenta nuevamente :C");
                request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("mensaje", e);
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        } finally {
            // Close resources
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
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
