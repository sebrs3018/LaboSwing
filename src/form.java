import javax.swing.*;

public class form {
    private JButton nextButton;
    private JPanel panel1;
    private JTextField questoSaràIlTextFieldTextField;

    public static void main(String[] args) {
        JFrame frame = new JFrame("form");
        frame.setContentPane(new form().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
