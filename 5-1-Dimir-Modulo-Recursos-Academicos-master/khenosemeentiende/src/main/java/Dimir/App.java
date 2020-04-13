package Dimir;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import java.sql.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * Hello world!
 *
 */
public class App extends Application {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement smnt = con.createStatement();
            ResultSet rs = smnt.executeQuery(" select * from usuarios");
            while (rs.next()) {
                // System.out.println(rs.getString( 1 + " "+ rs.getString(2) + " "+ rs.getString(3)
                //+ " " +rs.getString(4) + " "+ rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7)+"\n"));
                //smnt.close();
                //con.close();
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)
                        + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World!");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage = FXMLLoader.load(getClass().getResource("/fxml/menuverdaderodeinicio.fxml"));
        stage.show();
    }

    public void inicio() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/menuverdaderodeinicio.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void materias() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/materias.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void plandeestudio() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/inicio.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void carreras() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/crearcarreras.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void aulas() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/crearaula.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void profesores() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/profesores.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void buscarplan() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/BuscarPlan.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void modificarplan() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/modificarplan.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void buscaraula() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/BuscarAula.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void modificaraula() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/modificaraula.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void buscarmateria() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/BuscarMateria.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void modificarmateria() {
        try {
            Stage ven = FXMLLoader.load(getClass().getResource("/fxml/modificarrmateria.fxml"));
            ven.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

