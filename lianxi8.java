package code;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Demo extends JFrame {
    public Demo() {
        setTitle("¼ÆËãÆ÷");
        setBounds(100, 100, 700, 700);
        add(new panel());
        pack();
    }
}

class panel extends JPanel {
    JTextField display;
    JPanel p1;
    JPanel p2;
    String now;

    public panel() {
        setLayout(new BorderLayout());
        display = new JTextField("");
        display.setEnabled(true);
        add(display, BorderLayout.NORTH);

        ActionListener command = new command();

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 4));
        addButton1("7", command);
        addButton1("8", command);
        addButton1("9", command);
        addButton1("+", command);
        addButton1("6", command);
        addButton1("5", command);
        addButton1("4", command);
        addButton1("-", command);
        addButton1("3", command);
        addButton1("2", command);
        addButton1("1", command);
        addButton1("*", command);
        addButton1("0", command);
        addButton1("*", command);
        addButton1("=", command);
        addButton1("/", command);

        add(p1, BorderLayout.CENTER);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 2));

        addButton2("BackSpace", command);
        addButton2("C", command);

        add(p2, BorderLayout.SOUTH);
    }

    public void addButton1(String bon, ActionListener listener) {
        JButton button = new JButton(bon);
        button.addActionListener(listener);
        p1.add(button);
    }

    public void addButton2(String bon, ActionListener listener) {
        JButton button = new JButton(bon);
        button.addActionListener(listener);
        p2.add(button);
    }

    class command implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            now =  event.getActionCommand();
            if (now != "BackSpace" && now != "=") {
                display.setText(display.getText() + now);
            }
            if (now.equals("=")) {
                display.setText(jisuan1(display.getText()));
            }
            if (now.equals("BackSpace")) {
                StringBuffer sb = new StringBuffer(display.getText());
                display.setText(sb.substring(0, sb.length() - 1));
            }
            if (now.equals("C")) {
                display.setText("");
            }
        }
    }

    public String jisuan1(String str) {
        StringBuffer sb = new StringBuffer(str);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (sb.charAt(i) <= '9' && sb.charAt(i) >= '0' || sb.charAt(i) == '.') {
                continue;
            }else {
                count++;
            }
        }

        char[] command = new char[count];
        String[] num = new String[count + 1];
        for (int j = 0; j < num.length; j++) {
            num[j] = "";
        }

        int k = 0;
        for (int p = 0; p < sb.length(); p++) {
            if (sb.charAt(p) <= '9' && sb.charAt(p) >= '0' || sb.charAt(p) == '.') {
                num[k] += sb.charAt(p);
                continue;
            }else {
                command[k] = sb.charAt(p);
                k++;
            }
        }

        double res = 0;
        for (int i = 0; i < count; i++) {
            double num1 = Double.parseDouble(num[i]);
            double num2 = Double.parseDouble(num[i + 1]);
            char c = command[i];

            switch (c) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-' :
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;
                default:
                    break;
            }
            num[i + 1] = String.valueOf(res);
        }

        return String.valueOf(res);

    }
}

public class lianxi8{
    public static void main(String[] args){
        Demo demo = new Demo();
        demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        demo.setVisible(true);
    }
}



