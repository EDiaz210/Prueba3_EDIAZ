import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame jp = new JFrame();
        jp.setContentPane(new Login().login);
        jp.setSize(200,200);
        jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp.setVisible(true);
    }
}