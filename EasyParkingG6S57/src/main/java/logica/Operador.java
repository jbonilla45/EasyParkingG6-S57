package logica;

import persistencia.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Operador {
    //atributos pendiente agregar usuario y contraseña para log
    private String nombre;
    private String apellido;
    private String cargo;
    private int id;

    //constructor


    public Operador() {
    }

    public Operador(String nombre, String apellido, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
    }

    public Operador(String nombre, String apellido, String cargo, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.id = id;
    }
    //get & setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean guardarOperador() {
        ConexionBD conBD = new ConexionBD();
        String sql = "INSERT INTO operador(nombre, apellido, cargo) VALUES ('" + this.nombre + "','" + this.apellido + "','" + this.cargo + "')";

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

    public boolean borrarOperador(int id) {
        ConexionBD conBD = new ConexionBD();
        String sql = "DELETE from operador WHERE idoperador =" + id + "";

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

    public boolean actualizarContacto(int id) {
        ConexionBD conBD = new ConexionBD();
        String sql = "UPDATE `operador` SET nombre='" + this.nombre + "',apellido='" + this.apellido + "',cargo='" + this.cargo + "' WHERE idoperador=" + id + "";

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

    public List<Operador> listarOperador() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        String sql = "SELECT * FROM operador;";
        List<Operador> listaOperador = new ArrayList<>();
        ResultSet datos = conexion.consultarBD(sql);

        Operador o;
        while (datos.next()) {
            o = new Operador();
            o.setId(Integer.parseInt(datos.getString("idoperador")));
            o.setNombre(datos.getString("nombre"));
            o.setApellido(datos.getString("apellido"));
            o.setCargo(datos.getString("cargo"));

            listaOperador.add(o);
        }
        conexion.cerrarConexion();
        return listaOperador;
    }

    public Operador obtenerOperador(int id) throws SQLException {
        ConexionBD conBD = new ConexionBD();
        String sql = "SELECT * FROM operador WHERE idoperador = '" + id + "';";
        ResultSet datos = conBD.consultarBD(sql);
        if (datos.next()) {
            Operador o = new Operador();
            o.setNombre(datos.getString("nombre"));
            o.setApellido(datos.getString("apellido"));
            o.setCargo(datos.getString("cargo"));

            return o;
        } else {
            conBD.cerrarConexion();
            return null; //no había contacto
        }
    }

    public static void main(String[] args) {
        Operador o = new Operador("jorge1", "bonilla1", "operador1");
        o.guardarOperador();
    }
}
