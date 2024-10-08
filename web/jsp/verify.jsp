<%-- 
    Document   : verify
    Created on : 2 oct 2024, 19:19:10
    Author     : fgmrr
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Verifica tu pedido</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }

            h2{
                text-align: center;
            }

            form {
                background-color: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                width: 800px;
                display: flex;
                justify-content: center;
                flex-direction: column;
                align-items: center;
            }

            form input[type="text"],
            form input[type="number"],
            form input[type="date"],
            form input[type="time"] {
                width: 100%;
                padding: 10px;
                margin: 8px 0;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 14px;
                text-align: start;
            }

            form input[type="submit"] {
                background-color: #007bff;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-top: 20px;
                width: 100%;
                font-size: 16px;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }

            form input[type="submit"]:hover {
                background-color: #0056b3;
                transform: translateY(-3px);
            }

            form input[type="submit"]:active {
                transform: translateY(0);
            }
            a {
                text-decoration: none;
                text-align: center;
                background-color: #6c757d;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                width: 100%;
                font-size: 16px;
                margin-top: 10px;
                margin-bottom: 30px;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }

            a:hover {
                background-color: #5a6268;
                transform: translateY(-3px);
            }
            
           .btn {
                text-decoration: none;
                text-align: center;
                background-color: #6c757d;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                width: 100%;
                font-size: 16px;
                display: inline-block;
                margin-top: 10px;
                margin-bottom: 30px;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }

            .btn:hover {
                background-color: #5a6268;
                transform: translateY(-3px);
            }

        </style>
    </head>
    <body>
        <div class="container">
            <h2>Verifique que sus datos sean correctos</h2>

            <form method="POST" action="${pageContext.request.contextPath}/to-db">
                <label  for="nombre">Nombre del cliente:</label>
                <input readOnly type="text" id="nombre" name="nombre" value="${nombre}" placeholder="Escribe tu nombre" required>
                <br><br>
                <label for="tipo">¿Qué tipo de hamburguesa te gustaría?</label>
                <input readOnly  type="text" id="tipo" name="tipo" placeholder="Clásica, Doble, Vegetariana, etc." value="${tipo}" required>
                <br><br>
                <label for="tamañoCarne">Tamaño de la carne (gramos):</label>
                <input readOnly type="text" id="carne" name="carne" value="${carne}" placeholder="Ej. 150.50" step="0.01" required>
                <br><br>

                <label for="queso">Cantidad de queso (gramos):</label>
                <input readOnly type="text" id="queso" name="queso" value="${queso}" placeholder="Ej. 30.00" step="0.01" required>
                <br><br>

                <label for="fecha">Fecha de pedido:</label>
                <input readOnly type="date" value="${fecha}" id="fecha" name="fecha" required>
                <br><br>

                <label for="hora">Hora de recogida (24hrs):</label>
                <input readOnly  type="time" value="${hora}" id="hora" name="hora" required>
                <br><br>

                <label for="instrucciones">Instrucciones adicionales:</label>
                <input readOnly type="text" value="${instrucciones}" id="instrucciones" name="instrucciones" placeholder="Ej. Sin cebolla, extra salsa, etc.">
                <br><br>

                <!-- Botón de envío -->
                <input type="submit" value="Registrar Pedido">
            </form>
            <a href="${pageContext.request.contextPath}" class="btn">Atrás</a>
        </div>
    </body>
</html>