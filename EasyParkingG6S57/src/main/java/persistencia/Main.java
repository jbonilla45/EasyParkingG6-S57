package persistencia;

import logica.Parqueadero;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ConexionBD b;
        logica.Parqueadero parq;
        String par="parqueadero "+Math.random();
        //b.insertarBD("INSERT INTO parqueadero (razonSocial, numPlazasCarro, numPlazasMoto, valorMinutoCarro, valorMinutoMoto) VALUES ('parqueadero 3', 101, 101, 60, 50)");


    }
}
