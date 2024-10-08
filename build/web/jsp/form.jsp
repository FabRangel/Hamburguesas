<%-- 
    Document   : form
    Created on : 2 oct 2024, 19:11:41
    Author     : fgmrr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro de Hamburguesas</title>
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
            button {
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

            button:hover {
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
            <h2>Formulario de Registro de Hamburguesa Personalizada</h2>

            <form method="POST" action="${pageContext.request.contextPath}/hamburguesa">

                <label for="pedido"><strong>No. Pedido</strong></label>
                <input type="text" id="idPedido" name="idPedido" readonly value="${siguienteId}" >
                <label for="nombre">Nombre del cliente:</label>
                <input type="text" id="nombre" name="nombre" placeholder="Escribe tu nombre" required>
                <br><br>
                <label for="tipo">¿Qué tipo de hamburguesa te gustaría?</label>
                <input type="text" id="tipo" name="tipo" placeholder="Clásica, Doble, Vegetariana, etc." required>
                <br><br>
                <label for="tamañoCarne">Tamaño de la carne (gramos):</label>
                <input type="number" id="carne" name="carne" placeholder="Ej. 150.50" step="0.01" min="0.5" max="1550" required>
                <br><br>

                <label for="queso">Cantidad de queso (gramos):</label>
                <input type="number" id="queso" name="queso" placeholder="Ej. 30.00" step="0.01" min="0.5" max="1550" required>
                <br><br>

                <label for="fecha">Fecha de pedido:</label>
                <input type="date" id="fecha" name="fecha" min="2024-10-07" max="2024-12-31" required>
                <br><br>

                <label for="hora">Hora de recogida (24hrs):</label>
                <input type="time" id="hora" name="hora" required>
                <br><br>

                <label for="instrucciones">Instrucciones adicionales:</label>
                <input type="text" id="instrucciones" name="instrucciones" placeholder="Ej. Sin cebolla, extra salsa, etc.">
                <br><br>

                <input type="submit" value="Confirmar Pedido">

            </form>
            <a href="${pageContext.request.contextPath}" class="btn">Atrás</a>
        </div>
    </body>
</html>