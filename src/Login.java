import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

public class Login {
    private JTextField textField1;
    private JPasswordField passwordField2;
    private JButton logInButton;
    public JPanel login;

    public Login() {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://uff5n84xa5xvvuvl:mSz7kMRF9HW1Mje7FxZU@bwtxhles9m2zi9tlresl-mysql.services.clever-cloud.com:3306/bwtxhles9m2zi9tlresl";
                String usuario = "uff5n84xa5xvvuvl";
                String password = "mSz7kMRF9HW1Mje7FxZU";


                try (Connection connection = DriverManager.getConnection(url, usuario, password)) {
                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM usuarios WHERE username = '" + textField1.getText() + "' AND password = '" + new String(passwordField2.getPassword()) + "'";
                    ResultSet resultSet = statement.executeQuery(query);
                    if(resultSet.next()){
                        if(resultSet.getObject("username").equals(textField1.getText()) && new String(passwordField2.getPassword()).equals(resultSet.getObject("password"))){
                            JFrame jp = new JFrame();
                            jp.setContentPane(new Opciones().op);
                            jp.setSize(350,200);
                            jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            jp.setVisible(true);
                            ((JFrame)SwingUtilities.getWindowAncestor(logInButton)).dispose();

                        }
                    }
                    JOptionPane.showMessageDialog(null, "Ingreso exitoso");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Digite bien las credenciales");
                    ex.printStackTrace();
                }
            }
        });
    }
}
