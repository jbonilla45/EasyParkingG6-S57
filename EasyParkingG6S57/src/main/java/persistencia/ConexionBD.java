/*configuracion de la conexion a la base de datos de acuerdo al del material del curso
* las demas aplicaciones del la app que requieren conexion usan esta instacia*/
package persistencia;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    // Configuracion de la conexion a la base de datos
    private String DB_driver = "";
    private String url = "";
    private String db = "";
    private String host = "";
    private String username = "";
    private String password = "";
    public Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private boolean local;

    //Constructor sin parmetros
    public ConexionBD() {
        local = false;//pude establecer este valor en falso para conectarse al servidor remoto
        DB_driver = "com.mysql.jdbc.Driver";
        if (local) {
            host = "localhost:3306";
            db = "c3s57grupo6";
            url = "jdbc:mysql://" + host + "/" + db; //URL DB
            username = "c3s57grupo6"; //usuario base de datos global
            password = "sXYcj7c1";
        } else {
            host = "localhost:3306";
            db = "eparkingg6-s57";
            url = "jdbc:mysql://" + host + "/" + db; //URL DB
            username = "root"; //usuario base de datos global
            password = "B3b3s1t@";
        }
        try {
//Asignacin del Driver
            Class.forName(DB_driver);
            System.out.println("asignacion driver ok");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("asignacion driver fallo");
        }
        try {
// Realizar la conexion
            con = DriverManager.getConnection(url, username, password);
            con.setTransactionIsolation(8);
            System.out.println("conectado");
        } catch (SQLException ex) {
            System.out.println("no se realizo la conexion");
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
// Realizar la conexin
    }

    //Retornar la conexin
    public Connection getConnection() {
        return con;
    }

    //Cerrar la conexin
    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Mtodo que devuelve un ResultSet de una consulta (tratamiento de SELECT)
    public ResultSet consultarBD(String sentencia) {
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sentencia);
        } catch (SQLException sqlex) {
        } catch (RuntimeException rex) {
        } catch (Exception ex) {
        }
        return rs;
    }

    // Mtodo que realiza un INSERT y devuelve TRUE si la operacin fue existosa
    public boolean insertarBD(String sentencia) {
        try {
            stmt = con.createStatement();
            stmt.execute(sentencia);
            System.out.println("Ingreso exitoso!");
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
            return false;
        }
        return true;
    }

    public boolean borrarBD(String sentencia) {
        try {
            stmt = con.createStatement();
            stmt.execute(sentencia);
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
            return false;
        }
        return true;
    }

    // Mtodo que realiza una operacin como UPDATE, DELETE, CREATE TABLE, entre otras
// y devuelve TRUE si la operacin fue existosa
    public boolean actualizarBD(String sentencia) {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(sentencia);
       } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
            return false;
        }
        return true;
    }

    public boolean setAutoCommitBD(boolean commit){
        try {
            con.setAutoCommit(commit);
            return true;
        } catch (SQLException | RuntimeException ex) {
            System.out.println("Error en set Autocommit");
            return false;
        }
    }

    public void cerrarConexion() {
        closeConnection(con);
        System.out.println("conexi??n cerrada");
    }

    public boolean commitBD(){
        try {
            con.commit();
            return true;
        } catch (SQLException | RuntimeException ex) {
            System.out.println("Error en commit a la BD");
            return false;
        }
    }

    public boolean rollbackBD() {
        try {
            con.rollback();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error al hacer rollback " + sqlex.getMessage());
            return false;
        }
    }
}
