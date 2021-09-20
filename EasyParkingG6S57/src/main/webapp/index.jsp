<!DOCTYPE html>

<head><title>Saludo JSP</title></head>
<body>
<h1>Hola
<% if (request.getParameter("cliente")!=null)
out.println(request.getParameter("cliente")); %>
</h1>
</body>
