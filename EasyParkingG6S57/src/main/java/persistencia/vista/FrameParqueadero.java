package persistencia.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FrameParqueadero extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FrameParqueadero.class.getResource("/FrameParqueadero.fxml"));
        Scene scene= new Scene(fxmlLoader.<Parent>load());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
