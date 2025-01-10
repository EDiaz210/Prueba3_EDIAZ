import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Opciones {
    private JButton mostrarEstudianteButton;
    private JButton ingresarEstudianteButton;
    private JButton cerrarButton;
    public JPanel op;

    public Opciones() {
        ingresarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jp = new JFrame();
                jp.setContentPane(new Ingresar().ingresar);
                jp.setSize(200,200);
                jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jp.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(ingresarEstudianteButton)).dispose();

            }
        });
        mostrarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jp = new JFrame();
                jp.setContentPane(new Mostrar().mostrar);
                jp.setSize(200,200);
                jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jp.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(mostrarEstudianteButton)).dispose();

            }
        });

        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jp = new JFrame();
                jp.setContentPane(new Login().login);
                jp.setSize(200,200);
                jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jp.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(cerrarButton)).dispose();
            }
        });
    }
}
