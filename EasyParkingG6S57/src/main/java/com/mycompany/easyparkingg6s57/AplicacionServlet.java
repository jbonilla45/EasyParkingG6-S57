package com.mycompany.easyparkingg6s57;

import logica.Vehiculo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AplicacionServlet", urlPatterns = {"/AplicacionServlet"})
public class AplicacionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String placa = request.getParameter("placa").toUpperCase();
        String tipoVehiculo = request.getParameter("tipoVehiculo");
        String medioPago = request.getParameter("medioPago");

        String accion = request.getParameter("action");
        String mensaje = "inicio";
        int ticketId = 0;

        Vehiculo v;

        switch (accion) {
            case "INGRESO":
                v = new Vehiculo(placa, tipoVehiculo, medioPago);
                if (v.ingreso()) {
                    mensaje = "Ingreso exitoso\n" + v.impTicket();
                } else
                    mensaje = "Error no se ingreso";
                break;
            case "SALIDA":
                ticketId = Integer.parseInt(request.getParameter("ticketId"));
                v = new Vehiculo();
                v = v.consultar(ticketId);
                if (v.salida(ticketId)) {
                    v = v.consultar(ticketId);
                    request.setAttribute("objVehiculo", v);
                    System.out.println(v.impFactura());
                    mensaje = "Salida registrada!\n" + v.impFactura();

                } else
                    mensaje = "no se registro la salida";

        }
        request.setAttribute("ticketId", ticketId);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("paginaAplicacion.jsp").forward(request, response);

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
