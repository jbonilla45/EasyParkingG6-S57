package com.mycompany.easyparkingg6s57;

import logica.Parqueadero;
import persistencia.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ControllerJSP {
    Scanner sc = new Scanner(System.in);
    Parqueadero p;

    public void crearPersona(String razonSocial, int numPlazasCarro, int numPlazasMoto, double valorMinutoCarro, double valorMinutoMoto) {
        System.out.println("Crear parqueadero");
        p = new Parqueadero(razonSocial, numPlazasCarro,numPlazasMoto, valorMinutoCarro, valorMinutoMoto);
        System.out.println("Parqueadero creado = " + "Razon Social: " + p.getRazonSocial() + " Plazas carro: " + p.getNumPlazasCarro() + " Plazas moto: " + p.getNumPlazasMoto() + " Valor minuto carro: " + p.getValorMinutoCarro()+ " Valor minuto moto: " + p.getValorMinutoMoto());
    }

    public boolean guardarPersona(String razonSocial, int numPlazasCarro, int numPlazasMoto, double valorMinutoCarro, double valorMinutoMoto) {
        crearPersona(razonSocial, numPlazasCarro,numPlazasMoto, valorMinutoCarro, valorMinutoMoto);
        System.out.println("Guardar Parqueadero");
        ConexionBD conBD = new ConexionBD();
        String sql;
        sql = "INSERT INTO parqueadero (razonSocial, numPlazasCarro,numPlazasMoto, valorMinutoCarro, valorMinutoMoto) VALUES ('" + p.getRazonSocial() + "'," + p.getNumPlazasCarro() + "," + p.getNumPlazasMoto() +  "," + p.getValorMinutoCarro() + "," + p.getValorMinutoMoto() + ")";
        return conBD.insertarBD(sql);
    }

    public Parqueadero consultarPersona(int id, Parqueadero p) {
        System.out.println("consultarPersona");
        ConexionBD conBD = new ConexionBD();
        //Parqueadero p = new Parqueadero();
        String sql;
        sql = "SELECT * FROM parqueadero WHERE idparqueadero=" + id + "";
        try (ResultSet rs = conBD.consultarBD(sql)) {
            while (rs.next()) {
                p = new Parqueadero(rs.getString("razonSocial"), rs.getInt("numPlazasCarro"), rs.getInt("numPlazasMoto"), rs.getDouble("valorMinutoCarro"), rs.getDouble("valorMinutoMoto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Consulta = " + "Razon Social: " + p.getRazonSocial() + " Plazas carro: " + p.getNumPlazasCarro() + " Plazas moto: " + p.getNumPlazasMoto() + " Valor minuto carro: " + p.getValorMinutoCarro()+ " Valor minuto moto: " + p.getValorMinutoMoto());
        return p;
    }

    public boolean modificarPersona(int id, String razonSocial, int numPlazasCarro, int numPlazasMoto, double valorMinutoCarro, double valorMinutoMoto) {
        System.out.println("Modificar parqueadero");
        ConexionBD conBD = new ConexionBD();
        String sql;
        crearPersona(razonSocial, numPlazasCarro,numPlazasMoto, valorMinutoCarro, valorMinutoMoto);
        sql = "UPDATE parqueadero SET razonSocial ='" + p.getRazonSocial() + "', numPlazasCarro=" + p.getNumPlazasCarro() + ", numPlazasMoto=" + p.getNumPlazasMoto() + ", valorMinutoCarro=" + p.getValorMinutoCarro() + ", valorMinutoMoto=" + p.getValorMinutoMoto()+" WHERE (idparqueadero=" + id + ")";
        return conBD.actualizarBD(sql);
    }

    public boolean eliminarPersona(int id) {
        System.out.println("Eliminar parqueadero");
        ConexionBD b = new ConexionBD();
        String sql;
        sql = "DELETE FROM parqueadero WHERE idparqueadero=" + id + "";
        return b.borrarBD(sql);
    }

    public static void main(String[] args) {
        ControllerJSP c=new ControllerJSP();
        c.guardarPersona("park 12",120,60,120,60);
        //c.consultarPersona(12, );
        c.modificarPersona(12,"park prueba",1,1,1,1);
        c.eliminarPersona(16);
    }

}
