package persistencia;

import logica.Parqueadero;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ConexionBD b = new ConexionBD();
        logica.Parqueadero parq;
        String par="parqueadero "+Math.random();
        //b.insertarBD("INSERT INTO parqueadero (razonSocial, numPlazasCarro, numPlazasMoto, valorMinutoCarro, valorMinutoMoto) VALUES ('parqueadero 3', 101, 101, 60, 50)");

        PreparedStatement ps;
        try {
            parq=new Parqueadero(par,100,50,60,30);
            ps = b.con.prepareStatement("INSERT INTO parqueadero (razonSocial, numPlazasCarro, " +
                    "numPlazasMoto, valorMinutoCarro, valorMinutoMoto) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, parq.getRazonSocial());     //razonSocial
            ps.setInt(2, parq.getNumPlazasCarro());     //numPlazasCarro
            ps.setInt(3, parq.getNumPlazasMoto());      //numPlazasMoto
            ps.setDouble(4, parq.getValorMinutoCarro());//valorMinutoCarro
            ps.setDouble(5, parq.getValorMinutoMoto()); //valorMinutoMoto
            ps.execute();
            System.out.println("ingreso exitoso!!");
            b.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("no se ingreso :( ");
            e.printStackTrace();
        }
    }
}
