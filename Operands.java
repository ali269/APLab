import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Operands extends JTabbedPane {
    private JPanel commons;
    private JPanel engine;
    private JTextField field;
    private JTextArea area;
    private JButton[] engines1 = new JButton[3];
    private JButton[] engines2 = new JButton[3];
    String[] a = {"a", "b", "c"};

    public Operands(JTextArea area, JTextField field) {
        this.area = area;
        this.field = field;
        commons = new JPanel();
        commons.setBackground(Color.GRAY);
        commons.setLayout(new GridLayout(3, 2, 5, 5));
        engine = new JPanel();
        engine.setBackground(Color.GRAY);
        engine.setLayout(new GridLayout(2, 2, 5, 5));
        int i = 0;
        for (String s: Operand.eng[0]) {
            JButton b = new JButton();
            b.setText(s);
            b.setFocusable(false);
            b.addMouseListener(new MouseEngineHandler(s));
            b.setToolTipText(a[i]);
            engines1[i] = b;
            i++;
        }
        i = 0;
        for (String s: Operand.eng[1]) {
            JButton b = new JButton();
            b.setText(s);
            b.setFocusable(false);
            b.addMouseListener(new MouseEngineHandler(s));
            b.setToolTipText("Shift" + "+" +  a[i]);
            engines2[i] = b;
            i++;
        }

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
                Calculator.setSecond(Double.parseDouble(field.getText()));
                area.setText(area.getText() + field.getText() + b.getText() + Calculator.getResult() + "|\n");
                field.setText("");
            }
        });
        commons.add(b);
        addTab("Commons", commons);

        for (int i = 0; i < 3; i++) {
            engine.add(engines1[i]);
        }
        addShiftButton();
        addTab("eng", engine);
    }

    private void addShiftButton() {
        JButton button = new JButton();
        button.setText("SHIFT");
        button.setFocusable(false);
        button.addMouseListener(new ShiftHandler());
        engine.add(button);
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
            JButton b = (JButton) engine.getComponent(0);
            int i = 0;
            if (b.getText().equals(Operand.eng[0][0]))
                i = 1;
            engine.removeAll();
            updateUI();
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    engine.add(engines1[j]);
                }
            }
            else {
                for (int j = 0; j < 3; j++) {
                    engine.add(engines2[j]);
                }
            }
            addShiftButton();
        }
    }

    private class MouseEngineHandler extends MouseAdapter{
        private String s;
        public MouseEngineHandler(String s) {
            this.s = s;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            Calculator.setOperand(s);
            String s1 = area.getText();
            area.setText(s1 + s);
        }
    }
}
