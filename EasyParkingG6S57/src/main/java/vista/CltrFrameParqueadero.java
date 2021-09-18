package vista;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import logica.Parqueadero;
import persistencia.ConexionBD;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CltrFrameParqueadero {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lblPlazasCarro;

    @FXML
    private TextField lblRazonSocial;

    @FXML
    private TextField lblPlazasMoto;

    @FXML
    private TextField lblValorMinCarro;

    @FXML
    private TextField lblValorMinMoto;

    @FXML
    private TextField lblId;

    @FXML
    private TableView tblParqueaderos;

    @FXML
    private Button cmdCrear;

    @FXML
    private Button cmdLeer;

    @FXML
    private Button cmdCerrar;

    @FXML
    private Button cmdLimpiar;

    @FXML
    private Button cmdActualizar;

    @FXML
    private Button cmdBorrar;

    @FXML
    void actualizarParqueadero(ActionEvent event) {
        logica.Parqueadero parq;
        ConexionBD b;
        PreparedStatement ps;
        try {
            b = new ConexionBD();
            parq = new Parqueadero(lblRazonSocial.getText(), Integer.parseInt(lblPlazasCarro.getText()),
                    Integer.parseInt(lblPlazasMoto.getText()), Double.parseDouble(lblValorMinCarro.getText()),
                    Double.parseDouble(lblValorMinMoto.getText()));
            ps = b.con.prepareStatement("UPDATE parqueadero SET razonSocial =?, numPlazasCarro=?, " +
                    "numPlazasMoto=?, valorMinutoCarro=?, valorMinutoMoto=? WHERE (idparqueadero=?)");
            ps.setString(1, parq.getRazonSocial());     //razonSocial
            ps.setInt(2, parq.getNumPlazasCarro());  //numPlazasCarro
            ps.setInt(3, parq.getNumPlazasMoto());   //numPlazasMoto
            ps.setDouble(4, parq.getValorMinutoCarro());//valorMinutoCarro
            ps.setDouble(5, parq.getValorMinutoMoto()); //valorMinutoMoto
            ps.setDouble(6, Integer.parseInt(lblId.getText())); //idParqueadero
            ps.execute();
            System.out.println("Actualizacion exitosa!!");
<<<<<<< HEAD
            //buildData();
=======
            updateData();
>>>>>>> jorgeB
            b.cerrarConexion();
            cmdActualizar.defaultButtonProperty();
        } catch (SQLException e) {
            System.out.println("no se actualizo :( ");
            e.printStackTrace();
        }
    }

    @FXML
    void borrarParqueadero(ActionEvent event) {
        ConexionBD b = new ConexionBD();
        String sql;
        sql="DELETE FROM parqueadero WHERE idparqueadero="+Integer.parseInt(lblId.getText())+"";
        b.borrarBD(sql);
        updateData();
        System.out.println("Dato borrado exitosamente");
    }

    @FXML
    void cerrarAplicacion(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void crearParqueadero(ActionEvent event) {
        logica.Parqueadero parq;
        ConexionBD b;
        PreparedStatement ps;
        try {
            b = new ConexionBD();
            parq = new Parqueadero(lblRazonSocial.getText(), Integer.parseInt(lblPlazasCarro.getText()),
                    Integer.parseInt(lblPlazasMoto.getText()), Double.parseDouble(lblValorMinCarro.getText()),
                    Double.parseDouble(lblValorMinMoto.getText()));
            ps = b.con.prepareStatement("INSERT INTO parqueadero (razonSocial, numPlazasCarro, " +
                    "numPlazasMoto, valorMinutoCarro, valorMinutoMoto) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, parq.getRazonSocial());     //razonSocial
            ps.setInt(2, parq.getNumPlazasCarro());     //numPlazasCarro
            ps.setInt(3, parq.getNumPlazasMoto());      //numPlazasMoto
            ps.setDouble(4, parq.getValorMinutoCarro());//valorMinutoCarro
            ps.setDouble(5, parq.getValorMinutoMoto()); //valorMinutoMoto
            ps.execute();
            updateData();
            System.out.println("ingreso exitoso!!");
            b.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("no se ingreso :( ");
            e.printStackTrace();
        }
    }

    @FXML
    void leerFila(MouseEvent event) {

    }

    @FXML
    void leerParqueadero(ActionEvent event) {
        ConexionBD b = new ConexionBD();
        String sql;

        sql="SELECT * FROM parqueadero WHERE idparqueadero="+Integer.parseInt(lblId.getText())+"";
        try (ResultSet rs=b.consultarBD(sql)){
            while (rs.next()){
                lblRazonSocial.setText(rs.getString("razonSocial"));
                lblPlazasCarro.setText(rs.getString("numPlazasCarro"));
                lblPlazasMoto.setText(rs.getString("numPlazasMoto"));
                lblValorMinCarro.setText(rs.getString("valorMinutoCarro"));
                lblValorMinMoto.setText(rs.getString("valorMinutoMoto"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    void limpiarLbl(ActionEvent event) {
        lblRazonSocial.setText(null);
        lblPlazasCarro.setText(null);
        lblPlazasMoto.setText(null);
        lblValorMinCarro.setText(null);
        lblValorMinMoto.setText(null);
    }

    @FXML
    void initialize() {
        assert lblPlazasCarro != null : "fx:id=\"lblPlazasCarro\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert lblRazonSocial != null : "fx:id=\"lblRazonSocial\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert lblPlazasMoto != null : "fx:id=\"lblPlazasMoto\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert lblValorMinCarro != null : "fx:id=\"lblValorMinCarro\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert lblValorMinMoto != null : "fx:id=\"lblValorMinMoto\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert tblParqueaderos != null : "fx:id=\"tblParqueaderos\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert lblId != null : "fx:id=\"lblId\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert cmdCrear != null : "fx:id=\"cmdCrear\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert cmdLeer != null : "fx:id=\"cmdLeer\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert cmdCerrar != null : "fx:id=\"cmdCerrar\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert cmdLimpiar != null : "fx:id=\"cmdLimpiar\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert cmdActualizar != null : "fx:id=\"cmdActualizar\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";
        assert cmdBorrar != null : "fx:id=\"cmdBorrar\" was not injected: check your FXML file 'FrameParqueadero.fxml'.";

        //buildData();

    }

    //private TableView tableview;
    public void buildData(){
        ConexionBD b;
        b = new ConexionBD();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        String SQL = "SELECT * from parqueadero";
        //ResultSet
        try {
            ResultSet rs = b.con.createStatement().executeQuery(SQL);

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tblParqueaderos.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tblParqueaderos.setItems(data);
            b.cerrarConexion();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }
    public void updateData(){
        ConexionBD b;
        b = new ConexionBD();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        String SQL = "SELECT * from parqueadero";
        //ResultSet
        try {
            ResultSet rs = b.con.createStatement().executeQuery(SQL);

            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);
            }

            //FINALLY ADDED TO TableView
            tblParqueaderos.setItems(data);
            b.cerrarConexion();
            tblParqueaderos.refresh();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

}