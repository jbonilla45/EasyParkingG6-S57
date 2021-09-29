<%@ page import="logica.Parqueadero" %><%--
  Created by IntelliJ IDEA.
  User: JorgePapa
  Date: 22/09/2021
  Time: 7:29 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Parqueadero</title>
</head>
<body>
<div class="container">
    <div>
        <h1>PARQUEADERO</h1>
    </div>
    <% Parqueadero p = new Parqueadero();
        String mensaje = "Bienvenido!";
        int id = 0;

        if (request.getAttribute("id") != null) {
            id = (int) request.getAttribute("id");
        }

        if (request.getAttribute("mensaje") != null) {
            mensaje = (String) request.getAttribute("mensaje");
        }

        if (request.getAttribute("objParqueadero") != null) {
            p = (Parqueadero) request.getAttribute("objParqueadero");
        }
    %>

    <form name="parqueadero" action="indexServlet" method="POST">
        <div>
            <table class="table table-striped table-bordered">
                <tbody>
                <tr>
                    <th><label>RAZON SOCIAL</label></th>
                    <th>
                        <input type="text" name="razonSocial" value="<%=p.getRazonSocial()%>" class="form-control"/>
                    </th>
                </tr>
                <tr>
                    <th><label>PLAZAS CARRO</label></th>
                    <th><input type="text" name="numPlazasCarro" value="<%=p.getNumPlazasCarro()%>"
                               class="form-control"/></th>
                </tr>
                <tr>
                    <th><label>PLAZAS MOTO</label></th>
                    <th><input type="text" name="numPlazasMoto" value="<%=p.getNumPlazasMoto()%>" class="form-control"/>
                    </th>
                </tr>
                <tr>
                    <th><label>VALOR MINUTO CARRO</label></th>
                    <th><input type="text" name="valorMinutoCarro" value="<%=p.getValorMinutoCarro()%>"
                               class="form-control"/></th>
                </tr>
                <tr>
                    <th><label>VALOR MINUTO MOTO</label></th>
                    <th><input type="text" name="valorMinutoMoto" value="<%=p.getValorMinutoMoto()%>"
                               class="form-control"/></th>
                </tr>
                </tbody>
            </table>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">ID</span>
                <input type="text" name="id" value="<%=id%>" class="form-control">
                <input type="submit" value="LEER" name="action">
                <input type="submit" value="ELIMINAR" name="action">
                <input type="submit" value="CREAR" name="action"/>
                <input type="submit" value="MODIFICAR" name="action"/>
                <a href="index.jsp" class="btn btn-primary" role="button" data-bs-toggle="button">Inicio</a>
            </div>
        </div>
        <div class="alert alert-primary" role="alert">
            <%=mensaje%>
        </div>
        <ul class="list-unstyled small text-muted">
            <li class="mb-2">Para CREAR adicione los datos solicitados, no digite ID este se genera automáticamente</li>
            <li class="mb-2">Para LEER digite el ID y presione LEER los datos se mostraran en las casillas</li>
            <li class="mb-2">Para MODIFICAR primero el ID y presione LEER modifique los datos y luego presione
                MODIFICAR
            </li>
            <li class="mb-2">Para ELIMINAR digite el ID y presione ELIMINAR los datos se eliminaran de la BD</li>
        </ul>
    </form>
</div>

</body>
</html>
