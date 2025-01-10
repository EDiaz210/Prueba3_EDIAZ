import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Ingresar {
    public JPanel ingresar;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton ingresarButton;
    private JButton volverButton;

    public Ingresar() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://uff5n84xa5xvvuvl:mSz7kMRF9HW1Mje7FxZU@bwtxhles9m2zi9tlresl-mysql.services.clever-cloud.com:3306/bwtxhles9m2zi9tlresl";
                String usuario = "uff5n84xa5xvvuvl";
                String password = "mSz7kMRF9HW1Mje7FxZU";


                String query = "INSERT INTO estudiantes (id, cedula, nombre, estudiante1, estudiante2, estudiante3, estudiante4, estudiante5  ) VALUES (?, ?, ?, ?, ?,?,?,?)";


                String id = textField1.getText().trim();
                String nombre = textField2.getText().trim();
                String cedula = textField3.getText().trim();
                double estudiante1 = Double.parseDouble(textField4.getText().trim());
                double estudiante2 = Double.parseDouble(textField5.getText().trim());
                double estudiante3 = Double.parseDouble(textField6.getText().trim());
                double estudiante4 = Double.parseDouble(textField7.getText().trim());
                double estudiante5 = Double.parseDouble(textField8.getText().trim());




                try (Connection connection = DriverManager.getConnection(url, usuario, password)) {

                    PreparedStatement cadenaPreparada = connection.prepareStatement(query);
                    cadenaPreparada.setString(1, id);
                    cadenaPreparada.setString(2, cedula);
                    cadenaPreparada.setString(3, nombre);
                    cadenaPreparada.setDouble(4, estudiante1);
                    cadenaPreparada.setDouble(5, estudiante2);
                    cadenaPreparada.setDouble(6, estudiante3);
                    cadenaPreparada.setDouble(7, estudiante4);
                    cadenaPreparada.setDouble(8, estudiante5);
                    double pro = (estudiante1 + estudiante3 + estudiante2 + estudiante4 + estudiante5)/5;
                    cadenaPreparada.setDouble(9,pro);
                    cadenaPreparada.executeUpdate();


                    JOptionPane.showMessageDialog(null, "Datos insertados con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);


                } catch (SQLException e3) {
                    e3.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al insertar los datos... \nIngrese correctamente el ID", "Error", JOptionPane.ERROR_MESSAGE);
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

