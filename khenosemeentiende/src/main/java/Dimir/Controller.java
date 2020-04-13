package Dimir;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import sun.awt.X11.XSystemTrayPeer;

import java.sql.*;
public class Controller {
    private App ventanas = new App();
    @FXML
    Button boton_crear_plan,boton_crear_mat,boton_crear_carrera,boton_crear_aula,boton_crear_profesor,boton_buscar_plan,boton_modi_plan,
    boton_buscar_aula,boton_modificar_aula,boton_buscar_materia,boton_modificar_materia;
    @FXML
    TextField nuevacladeprofesor,nuevoestudiosprofesor,nuevonombresprofesor;
    @FXML
    TextField nuevaclavedeaula,nuevotipodeaula,nuevoedificio,claveaulabuscar,clavebuscaraula,nuevotipoaula,nuevoedificioaula;
    @FXML
    TextField nuevacrearcarreraid,nuevacrearcarreranombre;
    @FXML
    TextField textonuevoplanestudioclave,nuevonombreplanestudios,nuevonivelplanestudio,nuevoidplandeestudio,planbuscado,planclavemodificar,nuevonombredeplan,nuevoniveldeplan;
    @FXML
    TextField nuevaclavedemateria,nombredemateria,nuevocreditosmateria,nuevocuatrimateria,NuevaPosicionmateria,nuevoclavedeplan,nuevotipodeplanmateria
    ,clavemateriaabuscar;
    @FXML
    TextField clavemateriadebuscar,nuevonombredemateria,nuevocreditodemateria,nuevocuatridemateria,nuevaposiciondemateria,nuevoplandeestudio;
    public void basededatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement smnt = con.createStatement();
            ResultSet rs = smnt.executeQuery(" select * from usuarios");
            while(rs.next()){
                // System.out.println(rs.getString( 1 + " "+ rs.getString(2) + " "+ rs.getString(3)
                //+ " " +rs.getString(4) + " "+ rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7)+"\n"));
                //smnt.close();
                //con.close();
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)
                        + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString( 7) );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println( "Hello World!" );
    }
    public void crearplan(){
        Stage stage = (Stage) this.boton_crear_plan.getScene().getWindow();
        stage.close();
        ventanas.plandeestudio();
    }
    public void crearmateria(){
        Stage stage = (Stage) this.boton_crear_mat.getScene().getWindow();
        stage.close();
        ventanas.materias();
    }
    public void creacarrera(){
        Stage stage = (Stage) this.boton_crear_carrera.getScene().getWindow();
        stage.close();
        ventanas.carreras();
    }
    public void creaaulas(){
        Stage stage = (Stage) this.boton_crear_aula.getScene().getWindow();
        stage.close();
        ventanas.aulas();
    }
    public void crearprofe(){
        Stage stage = (Stage) this.boton_crear_profesor.getScene().getWindow();
        stage.close();
        ventanas.profesores();
    }
    public void buscarplan(){
        Stage stage = (Stage) this.boton_buscar_plan.getScene().getWindow();
        stage.close();
        ventanas.buscarplan();
    }
    public void modiplan(){
        Stage stage = (Stage) this.boton_modi_plan.getScene().getWindow();
        stage.close();
        ventanas.modificarplan();
    }
    public void buscaaula(){
        Stage stage = (Stage) this.boton_buscar_aula.getScene().getWindow();
        stage.close();
        ventanas.buscaraula();
    }
    public void modifiaula(){
        Stage stage = (Stage) this.boton_modificar_aula.getScene().getWindow();
        stage.close();
        ventanas.modificaraula();
    }
    public void buscamateria(){
        Stage stage = (Stage) this.boton_buscar_materia.getScene().getWindow();
        stage.close();
        ventanas.buscarmateria();
    }
    public void modimateria(){
        Stage stage = (Stage) this.boton_modificar_materia.getScene().getWindow();
        stage.close();
        ventanas.modificarmateria();
    }
    public void fernanflo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
       PreparedStatement pstmt = null;
        String sql = "INSERT INTO plan_estudios (clv_plan, nombre_plan, nivel, idcarrera) VALUES (?,?,?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,textonuevoplanestudioclave.getText());
        pstmt.setString(2,nuevonombreplanestudios.getText());
        pstmt.setString(3,nuevonivelplanestudio.getText());
        pstmt.setString(4,nuevoidplandeestudio.getText());
        pstmt.executeUpdate();
        System.out.println("que dios me perdone");
    }
    public void crearcarreras() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO carrera (idcarrera, nombre_carrera) VALUES (?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,nuevacrearcarreraid.getText());
        pstmt.setString(2,nuevacrearcarreranombre.getText());
        pstmt.executeUpdate();
        System.out.println("que dios me perdone");
    }
    public void crearaulas() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO aula (claveaula, tipo, Edificio) VALUES (?,?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,nuevaclavedeaula.getText());
        pstmt.setString(2,nuevotipodeaula.getText());
        pstmt.setString(3,nuevoedificio.getText());
        pstmt.executeUpdate();
        System.out.println("que dios me perdone");
    }
    public void crearprofesor() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO profesores (claveprofe, estudios, nombre) VALUES (?,?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,nuevacladeprofesor.getText());
        pstmt.setString(2,nuevoestudiosprofesor.getText());
        pstmt.setString(3,nuevonombresprofesor.getText());
        pstmt.executeUpdate();
        System.out.println("que dios me perdone");
    }
    public void willy() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO materias (clv_materia, nombre_materia, creditos, cuatrimestre, posicion, clv_plan, tipo_materia) VALUES (?,?,?,?,?,?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,nuevaclavedemateria.getText());
        System.out.println("1");
        pstmt.setString(2,nombredemateria.getText());
        System.out.println("2");
        pstmt.setString(3,nuevocreditosmateria.getText());
        System.out.println("3");
        pstmt.setString(4,nuevocuatrimateria.getText());
        System.out.println("4");
        pstmt.setString(5,NuevaPosicionmateria.getText());
        System.out.println("5");
        pstmt.setString(6,nuevoclavedeplan.getText());
        System.out.println("6");
        pstmt.setString(7,nuevotipodeplanmateria.getText());
        System.out.println("7");
        pstmt.executeUpdate();
        System.out.println("que dios me perdone");
    }
    public void encontrarplan() {
        try {
            String buscado = planbuscado.getText();
            String buscado2;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement smnt = con.createStatement();
            ResultSet rs = smnt.executeQuery(" select * from plan_estudios");
            while(rs.next()){
                // System.out.println(rs.getString( 1 + " "+ rs.getString(2) + " "+ rs.getString(3)
                //+ " " +rs.getString(4) + " "+ rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7)+"\n"));
                //smnt.close();
                //con.close();
                buscado2 = rs.getString(1);
                //System.out.println(buscado);
                //System.out.println(buscado2);
               //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                if(buscado2.equals(buscado)){
                    System.out.println("Encontrando");
                    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void deletearplan() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM plan_estudios WHERE clv_plan = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,planbuscado.getText());
        pstmt.executeUpdate();
        System.out.println("que dios me perdone");
    }

    public void modificarplan() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        PreparedStatement pstmt = null;
        String sql = "UPDATE plan_estudios SET nombre_plan='" + nuevonombredeplan.getText().toString() + "' , nivel='" + nuevoniveldeplan.getText().toString() + "' WHERE clv_plan='" + planclavemodificar.getText().toString()+"'";
        pstmt = con.prepareStatement(sql);

        pstmt.executeUpdate();
        System.out.println("que dios me perdone");
    }
    public void buscaraula() {
        try {
            String buscado = claveaulabuscar.getText();
            String buscado2;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement smnt = con.createStatement();
            ResultSet rs = smnt.executeQuery(" select * from aula");
            while(rs.next()){
                // System.out.println(rs.getString( 1 + " "+ rs.getString(2) + " "+ rs.getString(3)
                //+ " " +rs.getString(4) + " "+ rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7)+"\n"));
                //smnt.close();
                //con.close();
                buscado2 = rs.getString(1);
                //System.out.println(buscado);
                //System.out.println(buscado2);
                //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                if(buscado2.equals(buscado)){
                    System.out.println("Encontrando");
                    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void deletearaula() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM aula WHERE claveaula = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,claveaulabuscar.getText());
        pstmt.executeUpdate();
        System.out.println("que dios me perdone");
    }
    public void modificaraula() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        PreparedStatement pstmt = null;
        String sql = "UPDATE plan_estudios SET tipo='" + nuevotipoaula.getText().toString() + "' , Edificio='" + nuevoedificioaula.getText().toString() + "' WHERE clv_plan='" + clavebuscaraula.getText().toString()+"'";
        pstmt = con.prepareStatement(sql);

        pstmt.executeUpdate();
        System.out.println("que dios me perdone");
    }
    public void buscarmateria() {
        try {
            String buscado = clavemateriaabuscar.getText();
            String buscado2;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement smnt = con.createStatement();
            ResultSet rs = smnt.executeQuery(" select * from materias");
            while(rs.next()){
                // System.out.println(rs.getString( 1 + " "+ rs.getString(2) + " "+ rs.getString(3)
                //+ " " +rs.getString(4) + " "+ rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7)+"\n"));
                //smnt.close();
                //con.close();
                buscado2 = rs.getString(1);
                //System.out.println(buscado);
                //System.out.println(buscado2);
                //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                if(buscado2.equals(buscado)){
                    System.out.println("Encontrando");
                    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void deletearmaterias() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM materias WHERE clv_materia = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,clavemateriaabuscar.getText());
        pstmt.executeUpdate();
        System.out.println("que dios me perdone");
    }
    public void modificarmateria() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        PreparedStatement pstmt = null;
        String sql = "UPDATE materias SET nombre_materia='" + nuevonombredemateria.getText().toString() + "' , creditos='" + nuevocreditodemateria.getText().toString() + "', cuatrimestre='" + nuevocuatridemateria.getText().toString() + "', posicion='" + nuevaposiciondemateria.getText().toString() + "', clv_plan='" + nuevoplandeestudio.getText().toString() + "'   WHERE clv_materia='" + clavemateriadebuscar.getText().toString()+"'";
        pstmt = con.prepareStatement(sql);

        pstmt.executeUpdate();
        System.out.println("que dios me perdone");
    }
    }

