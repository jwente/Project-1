package project1;

import com.sun.org.apache.xml.internal.security.Init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialPanel
{
    private JFrame frame;

    public InitialPanel()
    {
        initialize();
        this.frame.setVisible(true);
    }

    private void initialize()
    {
        /*
		 * Comment here
		 */
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 385);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

		/*
		 * Comment here
		 */
        JLabel lbl_Welcome_Banner = new JLabel("Welcome To BookMart!!");
        lbl_Welcome_Banner.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Welcome_Banner.setFont(new Font("Calibri", Font.PLAIN, 30));
        lbl_Welcome_Banner.setBounds(80, 80, 305, 40);
        frame.getContentPane().add(lbl_Welcome_Banner);

		/*
		 * Comment here
		 */
        JButton btn_Registration = new JButton("Register");
        btn_Registration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                RegistrationPanel registration_panel = new RegistrationPanel();
                frame.dispose();
                registration_panel.setVisible(true);
            }
        });
        btn_Registration.setFont(new Font("Calibri", Font.PLAIN, 20));
        btn_Registration.setBounds(60, 205, 150, 50);
        frame.getContentPane().add(btn_Registration);

		/*
		 * Comment here
		 */
        JButton btn_Login = new JButton("Login");
        btn_Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LoginPanel login_panel = new LoginPanel();
                frame.dispose();
                login_panel.setVisible(true);
            }
        });
        btn_Login.setFont(new Font("Calibri", Font.PLAIN, 20));
        btn_Login.setBounds(250, 205, 150, 50);
        frame.getContentPane().add(btn_Login);
    }
}
