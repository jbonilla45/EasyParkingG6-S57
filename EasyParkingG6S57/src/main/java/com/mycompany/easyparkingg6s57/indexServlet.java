package com.mycompany.easyparkingg6s57;

import logica.Parqueadero;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "indexServlet", urlPatterns = {"/indexServlet"})
public class indexServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String razonSocial = request.getParameter("razonSocial") != null ? request.getParameter("razonSocial") : "";
        String numPlazasCarro = request.getParameter("numPlazasCarro") != null ? request.getParameter("numPlazasCarro") : "";
        String numPlazasMoto = request.getParameter("numPlazasMoto") != null ? request.getParameter("numPlazasMoto") : "";
        String valorMinutoCarro = request.getParameter("valorMinutoCarro") != null ? request.getParameter("valorMinutoCarro") : "";
        String valorMinutoMoto = request.getParameter("valorMinutoMoto") != null ? request.getParameter("valorMinutoMoto") : "";

        String accion = request.getParameter("action");
        String mensaje = "inicio";
        int id = 0;

        ParqueaderoCltr cltr = new ParqueaderoCltr();

        switch (accion) {
            case "CREAR":
                if (cltr.guardar(razonSocial, Integer.parseInt(numPlazasCarro), Integer.parseInt(numPlazasMoto), Double.parseDouble(valorMinutoCarro), Double.parseDouble(valorMinutoMoto))) {
                    mensaje = "Registro Agregado";
                } else {
                    mensaje = "no se agrego";
                }
                break;
            case "LEER":
                id = Integer.parseInt(request.getParameter("id"));
                Parqueadero ptem = cltr.consultar(id);
                request.setAttribute("objParqueadero", ptem);
                mensaje = "Consulta realizada";
                break;
            case "MODIFICAR":
                id = Integer.parseInt(request.getParameter("id"));
                if (cltr.modificar(id, razonSocial, Integer.parseInt(numPlazasCarro), Integer.parseInt(numPlazasMoto), Double.parseDouble(valorMinutoCarro), Double.parseDouble(valorMinutoMoto))) {
                    mensaje = "Registro Modificado";
                } else {
                    mensaje = "no se agrego";
                }
                break;
            case "ELIMINAR":
                id = Integer.parseInt(request.getParameter("id"));
                if (cltr.eliminar(id)) {
                    mensaje = "Registro Eliminado";
                } else {
                    mensaje = "no se elimino";
                }
                break;
        }

        request.setAttribute("id", id);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("paginaParqueadero.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
