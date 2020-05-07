import javax.swing.*;
import java.awt.*;

public class CalcView {
    private JFrame frame;
    private JTextArea area;
    private JTextField field;

    public CalcView() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("CALCULATOR");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLayout(new GridLayout());
        area = new JTextArea();
        area.setRows(5);
        area.setColumns(20);
        area.setLineWrap(true);
        area.setFocusable(false);
        area.setFont(new Font("Calibri", Font.ITALIC, 22));
        field = new JTextField();
        field.setFocusable(false);
        field.setFont(new Font("Calibri", Font.ITALIC, 34));
        prepareGUI();
    }

    private void prepareGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setFocusable(true);
        mainPanel.setBackground(Color.ORANGE);
        mainPanel.setLayout(new GridLayout(2, 1, 0, 7));
        mainPanel.setSize(500, 500);
        mainPanel.add(new PanelUp(field, area));
        mainPanel.add(new PanelDown(field, area));
        frame.add(mainPanel);
    }

    public void show() {
        frame.setVisible(true);
    }
}
