package org.example.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Vector;

public class Calculator {

    // 操作数1，为了程序的安全，初值一定设置，这里我们设置为0。
    String str1 = "0";

    // 操作数2
    String str2 = "0";

    // 运算符
    String signal = "+";

    // 运算结果
    String result = "";

    // 以下k1至k2为状态开关

    // 开关1用于选择输入方向，将要写入str1或str2
    int k1 = 1;
    // 开关2用于记录符号键的次数，如果 k2>1 说明进行的是 2+3-9+8 这样的多符号运算
    int k2 = 1;
    // 开关3用于标识 str1 是否可以被清0 ，等于1时可以，不等于1时不能被清0
    int k3 = 1;
    // 开关4用于标识 str2 是否可以被清0
    int k4 = 1;
    // 开关5用于控制小数点可否被录入，等于1时可以，不为1时，输入的小数点被丢掉
    int k5 = 1;
    // store的作用类似于寄存器，用于记录是否连续按下符号键
    JButton store;

    @SuppressWarnings("rawtypes")
    Vector vt = new Vector(20, 10);


    // 创建一个 JFrame 对象并初始化。
    JFrame frame = new JFrame("Calculator");

    JTextField result_TextField = new JTextField(result, 20);
    JButton Button_clear = new JButton("Clear");
    // 数字键0到9
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    // 计算命令按钮，加减乘除以及小数点等
    JButton button_Dian = new JButton(".");
    JButton button_jia = new JButton("+");
    JButton button_jian = new JButton("-");
    JButton button_cheng = new JButton("*");
    JButton button_chu = new JButton("/");
    // 计算按钮
    JButton button_dy = new JButton("=");

    public Calculator() {

        button0.setMnemonic(KeyEvent.VK_0);
        button1.setMnemonic(KeyEvent.VK_1);
        button2.setMnemonic(KeyEvent.VK_2);
        button3.setMnemonic(KeyEvent.VK_3);
        button4.setMnemonic(KeyEvent.VK_4);
        button5.setMnemonic(KeyEvent.VK_5);
        button6.setMnemonic(KeyEvent.VK_6);
        button7.setMnemonic(KeyEvent.VK_7);
        button8.setMnemonic(KeyEvent.VK_8);
        button9.setMnemonic(KeyEvent.VK_9);

        result_TextField.setHorizontalAlignment(JTextField.RIGHT);

        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(4, 4, 5, 5));
        // 将用于计算的按钮添加到容器内
        pan.add(button7);
        pan.add(button8);
        pan.add(button9);
        pan.add(button_chu);
        pan.add(button4);
        pan.add(button5);
        pan.add(button6);
        pan.add(button_cheng);
        pan.add(button1);
        pan.add(button2);
        pan.add(button3);
        pan.add(button_jian);
        pan.add(button0);
        pan.add(button_Dian);
        pan.add(button_dy);
        pan.add(button_jia);
        pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel pan2 = new JPanel();
        pan2.setLayout(new BorderLayout());
        pan2.add(result_TextField, BorderLayout.WEST);
        pan2.add(Button_clear, BorderLayout.EAST);

        frame.setLocation(300, 200);
        frame.setResizable(false);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(pan2, BorderLayout.NORTH);
        frame.getContentPane().add(pan, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

        // 事件处理程序

        // 数字键
        class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ss = ((JButton) e.getSource()).getText();
                store = (JButton) e.getSource();
                vt.add(store);
                if (k1 == 1) {
                    // 写入 str1
                    if (k3 == 1) {
                        str1 = "";

                        k5 = 1;
                    }
                    str1 = str1 + ss;
                    k3 = k3 + 1;
                    result_TextField.setText(str1);
                } else if (k1 == 2) {
                    // 写入 str2
                    if (k4 == 1) {
                        str2 = "";

                        k5 = 1;
                    }
                    str2 = str2 + ss;
                    k4 = k4 + 1;
                    result_TextField.setText(str2);
                }
            }
        }

        // 输入的运算符号的处理
        class Listener_signal implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ss2 = ((JButton) e.getSource()).getText();
                store = (JButton) e.getSource();
                vt.add(store);

                if(k2 == 1) {
                    k1 = 2;
                    k5 = 1;
                    signal = ss2;
                    k2 = k2 + 1;
                } else {
                    int a = vt.size();
                    JButton c = (JButton) vt.get(a - 2);

                    if(!(c.getText().equals("+"))
                        && !(c.getText().equals("-"))
                        && !(c.getText().equals("*"))
                        && !(c.getText().equals("/")))
                    {
                        cal();
                        str1 = result;
                        k1 = 2;
                        k5 = 1;
                        k4 = 1;
                        signal = ss2;
                    }
                    k2 = k2 + 1;
                }
            }
        }

        // 清除键的逻辑
        class Listener_clear implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                k1 = 1;
                k2 = 1;
                k3 = 1;
                k4 = 1;
                k5 = 1;
                str1 = "0";
                str2 = "0";
                result = "";
                result_TextField.setText(result);
                vt.clear();
            }
        }

        // 等于键的逻辑
        class Listener_dy implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                cal();

                k1 = 1;
                k2 = 1;
                k3 = 1;
                k4 = 1;

                str1 =result;
            }
        }

        // 小数点的处理
        class Listener_xiaos implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                if (k5 == 1) {
                    String ss3 = ((JButton) e.getSource()).getText();
                    if (k1 == 1) {
                        if(k3 == 1) {
                            str1 = "";

                            k5 = 1;
                        }
                        str1 = str1 + ss3;

                        k3 = k3 + 1;

                        result_TextField.setText(str1);
                    } else if (k1 == 2) {
                        if (k4 == 1) {
                            str2 = "";

                            k5 = 1;
                        }
                        str2 = str2 + ss3;

                        k4 = k4 + 1;

                        result_TextField.setText(str2);
                    }
                }

                k5 = k5 + 1;
            }
        }

        Listener_dy jt_dy = new Listener_dy();
        Listener jt = new Listener();
        Listener_signal jt_signal = new Listener_signal();
        Listener_clear jt_c = new Listener_clear();
        Listener_xiaos jt_xs = new Listener_xiaos();

        button7.addActionListener(jt);
        button8.addActionListener(jt);
        button9.addActionListener(jt);
        button_chu.addActionListener(jt_signal);
        button4.addActionListener(jt);
        button5.addActionListener(jt);
        button6.addActionListener(jt);
        button_cheng.addActionListener(jt_signal);
        button1.addActionListener(jt);
        button2.addActionListener(jt);
        button3.addActionListener(jt);
        button_jian.addActionListener(jt_signal);
        button0.addActionListener(jt);
        button_Dian.addActionListener(jt_xs);
        button_dy.addActionListener(jt_dy);
        button_jia.addActionListener(jt_signal);
        Button_clear.addActionListener(jt_c);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 计算逻辑
    public void cal() {
        double a2;
        double b2;
        String c = signal;
        double result2 = 0;
        if(c.equals("")) {
            result_TextField.setText("Please input operator");
        } else {
            if(str1.equals(".")) {
                str1 = "0.0";
            }
            if(str2.equals(".")) {
                str2 = "0.0";
            }
            a2 = Double.valueOf(str1).doubleValue();
            b2 = Double.valueOf(str2).doubleValue();

            if(c.equals("+")) {
                result2 = a2 + b2;
            }
            if(c.equals("-")) {
                result2 = a2 - b2;
            }
            if(c.equals("*")) {
                BigDecimal m1 = new BigDecimal(Double.toString(a2));
                BigDecimal m2 = new BigDecimal(Double.toString(b2));
                result2 = m1.multiply(m2).doubleValue();
            }
            if(c.equals("/")) {
                if(b2 == 0) {
                    result2 = 0;
                } else {
                    result2 = a2 / b2;
                }
            }

            result = String.valueOf(result2);

            result_TextField.setText(result);
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // 设置程序界面风格，可以去除
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calculator cal = new Calculator();
    }

}
// 尝试实现一个较为复杂的计算器，考虑运算的优先级，并增加括号，这些需要数据结构方面的一些知识。