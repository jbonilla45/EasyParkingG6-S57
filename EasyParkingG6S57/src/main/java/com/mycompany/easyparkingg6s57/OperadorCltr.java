package com.mycompany.easyparkingg6s57;

import logica.Operador;

import persistencia.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperadorCltr {
    Operador o;
    //crear operador
    public void crear(String nombre, String apellido, String cargo){
        System.out.println("crear operador");
        o = new Operador(nombre, apellido, cargo);
        System.out.println("o = " + o.getNombre()+" "+o.getApellido()+" "+o.getCargo());
    }
    //guardar operador
    public boolean guardar(String nombre, String apellido, String cargo){
        crear(nombre, apellido, cargo);
        System.out.println("Guardar operador");
        ConexionBD conBD  = new ConexionBD();
        String sql;
        sql = "INSERT INTO operador (nombre, apellido, cargo) VALUES ('" + o.getNombre() + "','" + o.getApellido() + "','" + o.getCargo() + "' )";
        return conBD.insertarBD(sql);
    }
    //consultar
    public Operador consultar(int id){
        System.out.println("consultar operador");
        ConexionBD conBD = new ConexionBD();
        Operador o=new Operador();
        String sql;
        sql = "SELECT * FROM operador WHERE idoperador=" + id + "";
        try (ResultSet rs = conBD.consultarBD(sql)){
            while (rs.next()){
                o=new Operador(rs.getString("nombre"),rs.getString("apellido"),rs.getString("cargo"));
                System.out.println("o = " + o.getNombre()+" "+o.getApellido()+" "+o.getCargo());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return o;
    }
    //modificar
    public boolean modificar(int id,String nombre, String apellido, String cargo){
        System.out.println("Modificar operador");
        ConexionBD conBD = new ConexionBD();
        String sql;
        crear(nombre, apellido, cargo);
        sql = "UPDATE operador SET nombre ='" + o.getNombre() + "', apellido='" + o.getApellido() + "', cargo='" + o.getCargo() + "' WHERE (idoperador=" + id + ")";
        return conBD.actualizarBD(sql);
    }
    //eliminar
    public boolean eliminar(int id){
        System.out.println("Eliminar Operador");
        ConexionBD b = new ConexionBD();
        String sql;
        sql = "DELETE FROM operador WHERE idoperador=" + id + "";
        return b.borrarBD(sql);
    }

    public static void main(String[] args) {
        OperadorCltr operadorCltr= new OperadorCltr();
        operadorCltr.guardar("jorge","bonilla","operador");
        operadorCltr.modificar(3,"Jorge","Bonilla", "Operador");
        //operadorCltr.eliminar(1);
    }

}
