package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
public class lianxi8_1 {
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1("转换器");
    }
}

class Demo1 extends JFrame implements ActionListener {
    String str1, str2;
    JLabel anser, tishi, zhuanhuan;
    JButton button;
    JTextField txt1, txt2;
    int num1, num2;

    Demo1(String s) {
        Container con = getContentPane();
        con.setLayout(new FlowLayout());
        button = new JButton("确定");
        txt1 = new JTextField("0", 100);
        txt2 = new JTextField("0", 100);
        tishi = new JLabel("你想转换的数", JLabel.CENTER);
        zhuanhuan = new JLabel("/", JLabel.CENTER);
        con.add(tishi);
        con.add(txt1);
        con.add(zhuanhuan);
        con.add(txt2);
        con.add(button);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1200, 400);
        this.setVisible(true);
        validate();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
//            num1 = Integer.parseInt(txt1.getText());
            str1 = txt1.getText();
            txt2.setText(parseChineseToDecimal(str1));
        }
    }
    private String parseChineseToDecimal(String string) {
        char[]numChar = string.toCharArray();
        String[] chinese = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
        String[] unit = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };
        StringBuffer sb = new StringBuffer();
        int size = numChar.length;

        for (int i = 0; i < numChar.length; i++) {
            int num = Integer.parseInt(String.valueOf(numChar[i]));
            if(i!=0){
                sb.append(unit[size-i-1]+chinese[num]);
            }else{
                sb.append(chinese[num]);
            }
        }

        String str = new String(sb);
        return str;
    }
}
