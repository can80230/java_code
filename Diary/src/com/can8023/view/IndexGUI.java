package com.can8023.view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IndexGUI extends JFrame {

    private final JPanel contentPane;

    private static IndexGUI frame;

    public IndexGUI() {
        setTitle("Diary");  // 设置窗体标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭方式
        setBounds(100, 100, 650, 400);
        contentPane = new JPanel(); // 实例化面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // 设置面板大小，位置
        setContentPane(contentPane);    // frame 添加面板
        contentPane.setLayout(null);    // 面板设置布局为 null，不可省略。否则页面布局将会杂乱。

        JLabel lblNewLabel = new JLabel("Welcome to use Diray");
        lblNewLabel.setBounds(132, 74, 386, 35);
        lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
        contentPane.add(lblNewLabel);

        JButton login = new JButton("Login");
        // 登录按钮鼠标事件，当鼠标被点击时调用
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                event_Login();
            }
        });

        login.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
                    event_Login();
                }
            }
        });
        login.setBounds(65, 263, 124, 45);
        contentPane.add(login);

        JButton register = new JButton("Sign up");

        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                event_register();
            }
        });

        register.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    event_register();
                }
            }
        });
        register.setBounds(489, 263, 109, 45);
        contentPane.add(register);
    }

    private void event_Login() {
        setVisible(false);
        new LoginGUI().loginGUI();
    }

    private void event_register() {
        setVisible(false);
        new RegisterGUI().registerGUI();
    }

    public static void init() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame = new IndexGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        init();
    }
}
