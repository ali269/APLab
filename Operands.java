import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Operands extends JTabbedPane {
    private JPanel commons;
    private JPanel engine;
    private JTextField field;
    private JTextArea area;


    public Operands(JTextArea area, JTextField field) {
        this.area = area;
        this.field = field;
        commons = new JPanel();
        commons.setBackground(Color.GRAY);
        commons.setLayout(new GridLayout(3, 2, 5, 5));
        engine = new JPanel();
        engine.setBackground(Color.GRAY);
        engine.setLayout(new GridLayout(2, 2, 5, 5));
        prepareGUI();
    }

    private void prepareGUI() {
        for (String s: Operand.commons) {
            JButton b = new JButton();
            b.setFocusable(false);
            b.setText(s);
            b.addMouseListener(new MouseHandler(s));
            commons.add(b);
        }
        JButton b = new JButton();
        b.setText(Operand.EQUALS);
        b.setFocusable(false);
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Calculator.setSecond(Float.parseFloat(field.getText()));
                area.setText(area.getText() + field.getText() + b.getText() + Calculator.getResult() + "|\n");
                field.setText("");
            }
        });
        commons.add(b);
        addTab("Commons", commons);

        for (String s: Operand.eng[0]) {
            JButton button = new JButton();
            button.setFocusable(false);
            button.setText(s);
            button.addMouseListener(new MouseHandler(s));
            engine.add(button);
        }
        JButton button = new JButton();
        button.setText("SHIFT");
        button.setFocusable(false);
        button.addMouseListener(new ShiftHandler());
        engine.add(button);
        addTab("eng", engine);
    }





    private class MouseHandler extends MouseAdapter {
        private String o;
        public MouseHandler(String o) {
            this.o = o;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            Calculator.setFirst(Double.parseDouble(field.getText()));
            Calculator.setOperand(o);
            area.setText(area.getText() + field.getText() + o);
            field.setText("");
        }
    }

    private class ShiftHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            for (int i = 0; i < 3; i++) {
                JButton b;
                if (engine.getComponent(i) instanceof JButton) {
                    b = (JButton) engine.getComponent(i);
                    if (!b.getText().equals(Operand.eng[0][i]))
                        b.setText(Operand.eng[0][i]);
                    else
                        b.setText(Operand.eng[1][i]);
                }
            }
        }
    }
}
