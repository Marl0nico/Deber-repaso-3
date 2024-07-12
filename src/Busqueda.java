import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Busqueda {
    private JTextArea cedulaEstudiante;
    private JTextField entradaCedula;
    private JButton botonBusqueda;
    private JTextArea nombreEstudiante;
    private JTextArea Cedula;
    private JTextArea notaB1;
    private JTextArea notaB2;
    private JLabel salidaNombre;
    private JLabel salidaCedula;
    private JLabel salidaB1;
    private JLabel salidaB2;
    public JPanel PanelBusqueda;

    public Busqueda() {
        botonBusqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
                String usuario = "root";
                String contraseña = "";
                try(Connection connection = DriverManager.getConnection(url,usuario,contraseña)){
                    System.out.println("Conexión exitosa");
                    String query = "SELECT * FROM estudiantes WHERE cedula='" + entradaCedula.getText()+"'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()){
                        salidaNombre.setText(resultSet.getString("nombre"));
                        salidaCedula.setText(resultSet.getString("cedula"));
                        salidaB1.setText(resultSet.getString("b1"));
                        salidaB2.setText(resultSet.getString("b2"));
                    }
                } catch (SQLException E){
                    System.out.println(E.getMessage());
                }
            }
        });
    }
}
