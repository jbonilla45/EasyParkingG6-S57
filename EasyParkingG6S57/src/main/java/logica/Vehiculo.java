package logica;

import com.mycompany.easyparkingg6s57.ParqueaderoCltr;
import persistencia.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Vehiculo {

    //atributos
    private String placa;
    private String tipoVehiculo;
    private String medioPago;
    private String fechaHoraEntrada;
    private String fechaHoraSalida;
    private int totalTiempo;
    private int ticketId;
    private int facturaId;
    private int idParqueadero;
    private Double totalPagar;

    //constructores

    public Vehiculo() {
    }

    public Vehiculo(String placa, String tipoVehiculo, String medioPago) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.medioPago = medioPago;
    }

    public Vehiculo(String placa, String tipoVehiculo, String medioPago, String fechaHoraEntrada, String fechaHoraSalida, int totalTiempo, int ticketId, int facturaId, int idParqueadero, Double totalPagar) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.medioPago = medioPago;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.totalTiempo = totalTiempo;
        this.ticketId = ticketId;
        this.facturaId = facturaId;
        this.idParqueadero = idParqueadero;
        this.totalPagar = totalPagar;
    }

    //get & setter

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(String fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public String getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(String fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public int getTotalTiempo() {
        return totalTiempo;
    }

    public void setTotalTiempo(int totalTiempo) {
        this.totalTiempo = totalTiempo;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(int facturaId) {
        this.facturaId = facturaId;
    }

    public int getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(int idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    //metodos

    public String impTicket() {

        String impTicket = "----------------------------------------------" + "\n" +
                "Ticket #      : " + this.ticketId + "\n" +
                "Placa         : " + this.placa + "\n" +
                "Tipo Vehiculo : " + this.tipoVehiculo + "\n" +
                "Fecha y hora de entrada : " + this.fechaHoraEntrada + "\n" +
                "----------------------------------------------";
        return impTicket;
    }

    public String impFactura() {

        String impFactura = "----------------------------------------------" + "\n" +
                "Factura #       : fac " + this.ticketId + "\n" +
                "Placa              : " + this.placa + "\n" +
                "Tipo Vehiculo : " + this.tipoVehiculo + "\n" +
                "Fecha y hora de entrada : " + this.fechaHoraEntrada + "\n" +
                "Fecha y hora de salida    : " + this.fechaHoraSalida + "\n" +
                "Tiempo de permanencia : " + this.totalTiempo + "\n" +
                "Total a pagar                 : " + this.totalPagar + "\n" +
                "----------------------------------------------";
        return impFactura;
    }

    //obtener ticket y factura ID
    public int generarTickedID() {
        ConexionBD conBD = new ConexionBD();
        int tick = 0;
        String sql = "SELECT ticketId FROM vehiculo WHERE idvehiculo = (SELECT MAX(idvehiculo) FROM vehiculo)";
        try (ResultSet rs = conBD.consultarBD(sql)) {
            while (rs.next()) {
                tick = rs.getInt("ticketId");
                tick++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conBD.cerrarConexion();
        //System.out.println("ticketIde = " + tick);
        return tick;
    }

    //obtener hora entrada
    public String getHoraEntrada(int id) {
        ConexionBD conBD = new ConexionBD();
        String tem = "";
        String sql = "SELECT fechaHoraEntrada FROM vehiculo WHERE idvehiculo =" + id + "  ";
        try (ResultSet rs = conBD.consultarBD(sql)) {
            while (rs.next()) {
                tem = rs.getString("fechaHoraEntrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conBD.cerrarConexion();
        //System.out.println("ticketIde = " + tick);
        return tem;
    }

    //obtener tiempo total
    public int tiempoTotal(int id) {
        String sql;
        int temTiempoTotal = 0;

        ConexionBD conBD = new ConexionBD();
        sql = "UPDATE vehiculo SET totalTiempo =TIMESTAMPDIFF(MINUTE,fechaHoraEntrada,fechaHoraSalida)";
        conBD.actualizarBD(sql);

        sql = "SELECT totalTiempo FROM vehiculo WHERE idvehiculo = " + id + "";
        try (ResultSet rs = conBD.consultarBD(sql)) {
            while (rs.next()) {
                temTiempoTotal = rs.getInt("totalTiempo");
                System.out.println("tiempoTotal = " + temTiempoTotal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conBD.cerrarConexion();

        return temTiempoTotal;
    }

    public void totalPagar() {
        ParqueaderoCltr pCltr = new ParqueaderoCltr();
        Parqueadero p = pCltr.consultar(this.idParqueadero);

        p.getValorMinutoCarro();

        switch (this.tipoVehiculo) {
            case "carro":
                if (this.totalTiempo <= 120) {
                    this.totalPagar = this.totalTiempo * p.getValorMinutoCarro();
                }
                if (this.totalTiempo > 120 && this.totalTiempo <= 360) {
                    this.totalPagar = this.totalTiempo * (p.getValorMinutoCarro() * 0.70);
                }
                if (this.totalTiempo > 360) {
                    this.totalPagar = this.totalTiempo * (p.getValorMinutoCarro() * 0.50);
                }
            case "moto":
                if (this.totalTiempo <= 120) {
                    this.totalPagar = this.totalTiempo * p.getValorMinutoMoto();
                }
                if (this.totalTiempo > 120 && this.totalTiempo <= 360) {
                    this.totalPagar = this.totalTiempo * (p.getValorMinutoMoto() * 0.70);
                }
                if (this.totalTiempo > 360) {
                    this.totalPagar = this.totalTiempo * (p.getValorMinutoMoto() * 0.50);
                }
        }
    }

    //consultar recibe una sentencia sql, este devuelve un resulset y este lo transformamos en un objeto
    public Vehiculo consultar(int id) {
        System.out.println("consultar");
        ConexionBD conBD = new ConexionBD();
        Vehiculo v = new Vehiculo();
        String sql;
        sql = "SELECT * FROM vehiculo WHERE idvehiculo=" + id + "";
        try (ResultSet rs = conBD.consultarBD(sql)) {
            while (rs.next()) {
                v = new Vehiculo(rs.getString("placa"), rs.getString("tipoVehiculo"), rs.getString("medioPago"), rs.getString("fechaHoraEntrada"), rs.getString("fechaHoraSalida"), rs.getInt("totalTiempo"), rs.getInt("ticketId"), rs.getInt("facturaId"), rs.getInt("idParqueadero"), rs.getDouble("totalPagar"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conBD.cerrarConexion();
        return v;
    }

    //Ingreso vehiculo
    public boolean ingreso() {
        ConexionBD conBD = new ConexionBD();
        setTicketId(generarTickedID());
        setFacturaId(generarTickedID());
        setIdParqueadero(1);
        String sql = "INSERT INTO vehiculo (placa, tipoVehiculo, medioPago, ticketId, facturaId, idParqueadero) VALUES ('" + this.placa + "','" + this.tipoVehiculo + "','" + this.medioPago + "'," + this.ticketId + "," + this.facturaId + "," + this.idParqueadero + " )";

        if (conBD.insertarBD(sql)) {
            this.fechaHoraEntrada = getHoraEntrada(this.ticketId);
            System.out.println(impTicket());
            conBD.cerrarConexion();
            return true;
        } else
            return false;

    }

    //salida vehiculo
    public boolean salida(int id) {

        ConexionBD conBD = new ConexionBD();
        String sql = "UPDATE vehiculo SET fechaHoraSalida =CURRENT_TIMESTAMP WHERE (idvehiculo=" + id + ")";
        conBD.actualizarBD(sql);
        setTotalTiempo(tiempoTotal(id));
        //Vehiculo v =consultar(id);
        totalPagar();
        sql = "UPDATE vehiculo SET totalPagar =" + this.totalPagar + " WHERE (idvehiculo=" + id + ")";
        conBD.actualizarBD(sql);
        conBD.cerrarConexion();
        //Vehiculo v = consultar(id);
        //System.out.println(impFactura());

        return true;
    }

    public static void main(String[] args) {
        Vehiculo v = new Vehiculo("zaq123","moto","efectivo");

        v.ingreso();
        v = v.consultar(12);
        v.salida(12);
        v = v.consultar(12);
        System.out.println(v.impFactura());
        //System.out.println(v.getHoraEntrada(6));


    }
}
