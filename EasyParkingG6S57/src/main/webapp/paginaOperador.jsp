
<%@ page import="logica.Operador" %>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Operador Easy Parking</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


</head>
<body>
<div class="container fluid">
    <div>
        <h1>OPERADOR</h1>
    </div>
    <% Operador o = new Operador();
        String mensaje = "Bienvenido!";
        int id = 0;

        if (request.getAttribute("id") != null) {
            id = (int) request.getAttribute("id");
        }

        if (request.getAttribute("mensaje") != null) {
            mensaje = (String) request.getAttribute("mensaje");
        }

        if (request.getAttribute("objOperador") != null) {
            o = (Operador) request.getAttribute("objOperador");
        }
    %>

    <form name="operador" action="OperadorServlet" method="POST">
        <div>
            <table class="table table-striped table-bordered">
                <tbody>
                <tr>
                    <th><label>NOMBRE</label></th>
                    <th><input type="text" name="nombre" value="<%=o.getNombre()%>" class="form-control"/>
                    </th>
                </tr>
                <tr>
                    <th><label>APELLIDO</label></th>
                    <th><input type="text" name="apellido" value="<%=o.getApellido()%>"
                               class="form-control"/></th>
                </tr>
                <tr>
                    <th><label>CARGO</label></th>
                    <th><input type="text" name="cargo" value="<%=o.getCargo()%>" class="form-control"/>
                    </th>
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
