package logica;

import persistencia.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    //atributos
    private String razonSocial;
    private int numPlazasCarro;
    private int numPlazasMoto;
    private double valorMinutoCarro;
    private double valorMinutoMoto;
    private int id;

    //constructor

    public Parqueadero() {
    }

    public Parqueadero(String razonSocial, int numPlazasCarro, int numPlazasMoto, double valorMinutoCarro, double valorMinutoMoto) {
        this.razonSocial = razonSocial;
        this.numPlazasCarro = numPlazasCarro;
        this.numPlazasMoto = numPlazasMoto;
        this.valorMinutoCarro = valorMinutoCarro;
        this.valorMinutoMoto = valorMinutoMoto;
    }

    public Parqueadero(String razonSocial, int numPlazasCarro, int numPlazasMoto, double valorMinutoCarro, double valorMinutoMoto, int id) {
        this.razonSocial = razonSocial;
        this.numPlazasCarro = numPlazasCarro;
        this.numPlazasMoto = numPlazasMoto;
        this.valorMinutoCarro = valorMinutoCarro;
        this.valorMinutoMoto = valorMinutoMoto;
        this.id = id;
    }
    //get & setter

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getNumPlazasCarro() {
        return numPlazasCarro;
    }

    public void setNumPlazasCarro(int numPlazasCarro) {
        this.numPlazasCarro = numPlazasCarro;
    }

    public int getNumPlazasMoto() {
        return numPlazasMoto;
    }

    public void setNumPlazasMoto(int numPlazasMoto) {
        this.numPlazasMoto = numPlazasMoto;
    }

    public double getValorMinutoCarro() {
        return valorMinutoCarro;
    }

    public void setValorMinutoCarro(double valorMinutoCarro) {
        this.valorMinutoCarro = valorMinutoCarro;
    }

    public double getValorMinutoMoto() {
        return valorMinutoMoto;
    }

    public void setValorMinutoMoto(double valorMinutoMoto) {
        this.valorMinutoMoto = valorMinutoMoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean guardarParqueadero() {
        ConexionBD conBD = new ConexionBD();
        String sql = "INSERT INTO parqueadero (razonSocial, numPlazasCarro,numPlazasMoto, valorMinutoCarro, valorMinutoMoto) VALUES ('" + this.razonSocial + "'," + this.numPlazasCarro + "," + this.numPlazasMoto + "," + this.valorMinutoCarro + "," + this.valorMinutoMoto + ")";

        if (conBD.setAutoCommitBD(false)) {
            if (conBD.insertarBD(sql)) {
                conBD.commitBD();
                conBD.cerrarConexion();
                return true;
            } else {
                conBD.rollbackBD();
                conBD.cerrarConexion();
                return false;
            }
        } else {
            conBD.cerrarConexion();
            return false;
        }
    }

    public boolean eliminarParqueadero(int id) {
        ConexionBD conBD = new ConexionBD();
        String sql = "DELETE from parqueadero WHERE idparqueadero=" + id + "";

        if (conBD.setAutoCommitBD(false)) {
            if (conBD.borrarBD(sql)) {
                conBD.commitBD();
                conBD.cerrarConexion();
                return true;
            } else {
                conBD.rollbackBD();
                conBD.cerrarConexion();
                return false;
            }
        } else {
            conBD.cerrarConexion();
            return false;
        }
    }

    public boolean actualizarParqueadero(int id) {
        ConexionBD conBD = new ConexionBD();
        String sql = "UPDATE parqueadero SET razonSocial ='" + this.razonSocial + "', numPlazasCarro=" + this.numPlazasCarro + ", numPlazasMoto=" + this.numPlazasMoto + ", valorMinutoCarro=" + this.valorMinutoCarro + ", valorMinutoMoto=" + this.valorMinutoMoto + " WHERE (idparqueadero=" + id + ")";

        if (conBD.setAutoCommitBD(false)) {
            if (conBD.actualizarBD(sql)) {
                conBD.commitBD();
                conBD.cerrarConexion();
                return true;
            } else {
                conBD.rollbackBD();
                conBD.cerrarConexion();
                return false;
            }

        } else {
            conBD.cerrarConexion();
            return false;
        }
    }

    public List<Parqueadero> listarParqueadero() throws SQLException {
        ConexionBD conBD = new ConexionBD();
        String sql = "SELECT * FROM parqueadero";
        List<Parqueadero> parqueaderoList = new ArrayList<>();
        ResultSet rs = conBD.consultarBD(sql);

        Parqueadero p;
        while (rs.next()) {
            p = new Parqueadero();
            p.setId(Integer.parseInt(rs.getString("idparqueadero")));
            p.setRazonSocial(rs.getString("razonSocial"));
            p.setNumPlazasCarro(Integer.parseInt(rs.getString("numPlazasCarro")));
            p.setNumPlazasMoto(Integer.parseInt(rs.getString("numPlazasMoto")));
            p.setValorMinutoCarro(Double.parseDouble(rs.getString("valorMinutoCarro")));
            p.setValorMinutoMoto(Double.parseDouble(rs.getString("valorMinutoMoto")));

            parqueaderoList.add(p);
        }
        conBD.cerrarConexion();
        return parqueaderoList;
    }
}
