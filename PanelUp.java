import javax.swing.*;
import java.awt.*;

public class PanelUp extends JPanel {
    private JTextArea area;
    private JTextField field;

    public PanelUp(JTextField field, JTextArea area) {
        this.area = area;
        this.field = field;
        setLayout(new GridLayout(2, 1));
        setBackground(Color.MAGENTA);
        prepareGUI();
    }

    private void prepareGUI() {
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBar(new JScrollBar());
        add(scrollPane);
        add(field);
    }
}
