package persistencia;

import logica.Parqueadero;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConexionBD b;
        logica.Parqueadero parq;
        String par="parqueadero "+Math.random();
        //b.insertarBD("INSERT INTO parqueadero (razonSocial, numPlazasCarro, numPlazasMoto, valorMinutoCarro, valorMinutoMoto) VALUES ('parqueadero 3', 101, 101, 60, 50)");
        //ResultSet ps;

        b = new ConexionBD();
        String sql;

        sql="SELECT razonSocial FROM parqueadero WHERE idparqueadero=1";

        try (ResultSet rs=b.consultarBD(sql)){
            while (rs.next()){
                String razonSocial=rs.getString("razonSocial");
                System.out.println("razonSocial = " + razonSocial);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }





    }
}
