<%@ page import="logica.Parqueadero" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<head><title>Parqueadero JSP</title></head>
<body>
<h1>PARQUEADERO</h1>
<% Parqueadero p = new Parqueadero();
    String mensaje = "Bienvenido!";
    int id =0;

    if (request.getAttribute("id")!=null){
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
    RAZON SOCIAL:      <input type="text" name="razonSocial" value="<%=p.getRazonSocial()%>" /><br>
    PLAZAS CARRO:      <input type="text" name="numPlazasCarro" value="<%=p.getNumPlazasCarro()%>" /><br>
    PLAZAS MOTO:       <input type="text" name="numPlazasMoto" value="<%=p.getNumPlazasMoto()%>" /><br>
    VALOR MINUTO CARRO:<input type="text" name="valorMinutoCarro" value="<%=p.getValorMinutoCarro()%>" /><br>
    VALOR MINUTO MOTO: <input type="text" name="valorMinutoMoto" value="<%=p.getValorMinutoMoto()%>" /><br>
    ID: <input type="text" name="id" value="<%=id%>" /><br>
    <input type="submit" value="CREAR" name="action" />
    <input type="submit" value="LEER" name="action" />
    <input type="submit" value="MODIFICAR" name="action" />
    <input type="submit" value="ELIMINAR" name="action" />
    <h4><%=mensaje%></h4>
</form>
</body>
    