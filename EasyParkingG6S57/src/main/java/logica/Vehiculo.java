package logica;

public class Vehiculo {
    //atributos
    private String placa;
    private String tipoVehiculo;
    private String fechaHoraEntrada;
    private String fechaHoraSalida;
    private String totalTiempo;
    private int ticket;
    private Double totalPagar;

    //constructor

    public Vehiculo(String placa, String tipoVehiculo, String fechaHoraEntrada) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    //metodos

    public String Ticked(String placa, String tipoVehiculo, String fechaHoraEntrada, int ticket) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.ticket = ticket;
        String impTicket =
                        "Ticket #                  : " + ticket +
                        "Placa                     : " + placa +
                        "Tipo Vehiculo             : " + tipoVehiculo +
                        "Fecha y hora de entrada   : " + fechaHoraEntrada;
        return impTicket;
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

    public String getTotalTiempo() {
        return totalTiempo;
    }

    public void setTotalTiempo(String totalTiempo) {
        this.totalTiempo = totalTiempo;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }
}
