package com.mycompany.easyparkingg6s57;

import logica.Operador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OperadorServlet", urlPatterns = {"/OperadorServlet"})
public class OperadorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
        String apellido = request.getParameter("apellido") != null ? request.getParameter("apellido") : "";
        String cargo = request.getParameter("cargo") != null ? request.getParameter("cargo") : "";

        String accion = request.getParameter("action");
        String mensaje = "inicio";
        int id = 0;

        OperadorCltr cltr = new OperadorCltr();

        switch (accion) {
            case "CREAR":
                if (cltr.guardar(nombre, apellido, cargo))
                    mensaje = "Registro Agregado";
                else
                    mensaje = "no se agrego";
                break;
            case "LEER":
                id = Integer.parseInt(request.getParameter("id"));
                Operador o = cltr.consultar(id);
                request.setAttribute("objOperador", o);
                mensaje = "Consulta realizada";
                break;
            case "MODIFICAR":
                id = Integer.parseInt(request.getParameter("id"));
                if (cltr.modificar(id, nombre, apellido, cargo))
                    mensaje = "Registro Modificado";
                else
                    mensaje = "no se agrego";
                break;
            case "ELIMINAR":
                id = Integer.parseInt(request.getParameter("id"));
                if (cltr.eliminar(id))
                    mensaje = "Registro Eliminado";
                else
                    mensaje = "no se elimino";
                break;
        }
        request.setAttribute("id", id);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("paginaOperador.jsp").forward(request, response);

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
