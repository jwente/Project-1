package project1;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Initial_Panel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initial_Panel window = new Initial_Panel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Initial_Panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
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
				Registration_Panel registration_panel = new Registration_Panel();
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
				Login_Panel login_panel = new Login_Panel();
				frame.dispose();
				login_panel.setVisible(true);
			}
		});
		btn_Login.setFont(new Font("Calibri", Font.PLAIN, 20));
		btn_Login.setBounds(250, 205, 150, 50);
		frame.getContentPane().add(btn_Login);
	}
}
