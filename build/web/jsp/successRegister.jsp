<%-- 
    Document   : successRegister
    Created on : 2 oct 2024, 22:33:00
    Author     : fgmrr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Éxito en el pedido</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .pedido-container {
                background-color: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                width: 400px;
                text-align: center;
            }

            h1 {
                font-size: 24px;
                margin-bottom: 20px;
                color: #333;
            }

            .pedido-info p {
                font-size: 18px;
                line-height: 1.6;
                color: #555;
            }

            .pedido-info p strong {
                color: #333;
            }

            .volver-btn {
                display: inline-block;
                margin-top: 20px;
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .volver-btn:hover {
                background-color: #45a049;
            }

            .limpiar-btn {
                display: inline-block;
                margin-top: 20px;
                padding: 10px 20px;
                background-color: #f44336; 
                color: white;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .limpiar-btn:hover {
                background-color: #d32f2f; 
            }
        </style>
    </head>
    <body>

        <div class="pedido-container">
            <h1>Tu pedido ha sido registrado con éxito</h1>
            <h5>Ya estamos preparando tu hamburguesita !yomi¡</h5>

            <div class="pedido-info">
                <p>Nombre del cliente: ${nombre}</p>
                <p>Tipo de hamburguesa: ${tipo}</p>
                <p>Tamaño de la carne (gramos): ${carne}</p>
                <p>Cantidad de queso (gramos): ${queso}</p>
                <p>Fecha del pedido: ${fecha}</p>
                <p>Hora de recogida: ${hora}</p>
                <p>Instrucciones adicionales: ${instrucciones}</p>
            </div>

            <a href="limpiarCookies" class="limpiar-btn">Limpiar</a>
            <a href="hamburguesa" class="volver-btn">Volver al Inicio</a>
        </div>

    </body>
</html>