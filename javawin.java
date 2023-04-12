package code;

import javax.swing.*;
import java.awt.*;

class ComponentInWindow extends JFrame {
     JTextField textField;
     JButton button;
     JCheckBox checkBox1, checkBox2, checkBox3;
     JRadioButton radio1, radio2;
     ButtonGroup group;
     JComboBox<String> comboBox;
     JTextArea area;

     ComponentInWindow() {
         init();
         setVisible(true);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     }

     void init () {
         setLayout(new FlowLayout());
         JLabel biaoqian = new JLabel("文本框");
         add(biaoqian);
         textField = new JTextField(20);
         add(textField);
         button = new JButton("确定");
         add(button);
         checkBox1 = new JCheckBox("喜欢世界");
         checkBox2 = new JCheckBox("喜欢崛起");
         checkBox3 = new JCheckBox("喜欢怪猎");
         add(checkBox1);
         add(checkBox2);
         add(checkBox3);

         group = new ButtonGroup();
         radio1 = new JRadioButton("你");
         radio2 = new JRadioButton("我");

         group.add(radio1);
         group.add(radio2);

         add(radio1);
         add(radio2);

         comboBox = new JComboBox<String>();
         comboBox.addItem("1");
         comboBox.addItem("2");
         comboBox.addItem("3");

         add(comboBox);

         area = new JTextArea(6, 12);
         add(new JScrollPane(area));
     }
}


public class javawin {
    public static void main(String[] args) {
//        JFrame win1 = new JFrame("a");
//        Container con = win1.getContentPane();
//        con.setBackground(Color.white);
//        win1.setBounds(60, 100, 400, 500);
//        win1.setVisible(true);
//        win1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ComponentInWindow win = new ComponentInWindow();
        win.setBounds(100, 100, 400 ,300);
        win.setTitle("a");
    }
}
