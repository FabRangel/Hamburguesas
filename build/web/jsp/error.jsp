<%-- 
    Document   : error
    Created on : 2 oct 2024, 22:38:32
    Author     : fgmrr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                display: flex; /* Utilizar flexbox para centrar el contenido */
                justify-content: center; /* Centrar horizontalmente */
                align-items: center; /* Centrar verticalmente */
                height: 100vh; /* Altura completa de la ventana */
            }

            .container {
                text-align: center;
                background-color: white;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                max-width: 400px;
                width: 100%;
            }

            h2 {
                font-size: 24px;
                color: #333;
                margin-bottom: 10px;
            }

            p {
                font-size: 18px;
                color: #555;
                margin-bottom: 20px;
            }

            a {
                display: inline-block;
                text-decoration: none;
                background-color: #007bff;
                color: white;
                padding: 10px 20px;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            a:hover {
                background-color: #0056b3;
            }

            a:active {
                background-color: #003d80;
            }

        </style>
    </head>
    <body>
       <div class="container">
            <h2>Operación</h2>
            <p><%= request.getAttribute("mensaje")%></p>
            <a href="${pageContext.request.contextPath}/jsp/form.jsp">Volver al formulario</a>
        </div>
    </body>
</html>
