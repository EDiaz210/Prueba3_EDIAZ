import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Mostrar {
    public JPanel mostrar;
    private JTextField textField1;
    private JButton mostrarInformacionButton;
    private JLabel estudiante;
    private JLabel encabezado;
    private JButton volverButton;

    public Mostrar() {
        mostrarInformacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://uff5n84xa5xvvuvl:mSz7kMRF9HW1Mje7FxZU@bwtxhles9m2zi9tlresl-mysql.services.clever-cloud.com:3306/bwtxhles9m2zi9tlresl";
                String usuario = "uff5n84xa5xvvuvl";
                String password = "mSz7kMRF9HW1Mje7FxZU";

                try (Connection connection = DriverManager.getConnection(url, usuario, password)) {


                    String query = "SELECT * FROM estudiantes WHERE nombre = '" + textField1.getText() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);


                    while (resultSet.next()) {

                        encabezado.setText(" ID | Nombre | Posicion | Equipo | Edad ");
                        estudiante.setText(resultSet.getString("id") + " | " + resultSet.getString("nombre") + " | " + resultSet.getString("cedula") + " | " + resultSet.getString("estudiante1") + " | " + resultSet.getString("estudiante2") + resultSet.getString("estudiante3") + resultSet.getString("estudiante4") + resultSet.getString("estudiante5") + resultSet.getString("promedio"));
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No se pudo encontrar al estudiante");
                }

            }

        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jp = new JFrame();
                jp.setContentPane(new Opciones().op);
                jp.setSize(200,200);
                jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jp.setVisible(true);
            }
        });
    }
}