package project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login_Panel extends JFrame {

	private JPanel contentPane;
	private JTextField txt_UN;
	private JButton btn_Login;
	private JPasswordField txt_UP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Panel frame = new Login_Panel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_Panel() {
		/*
		 * Create absolute layout panel
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * Create the welcome banner label 
		 */
		JLabel lbl_Login_Banner = new JLabel("User Login");
		lbl_Login_Banner.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Login_Banner.setFont(new Font("Calibri", Font.PLAIN, 30));
		lbl_Login_Banner.setBounds(85, 60, 305, 40);
		contentPane.add(lbl_Login_Banner);
		
		/*
		 * Create User name text box
		 */
		txt_UN = new JTextField();
		txt_UN.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_UN.setBounds(60, 130, 200, 30);
		contentPane.add(txt_UN);
		txt_UN.setColumns(10);
		
		/*
		 * Create User name label
		 */
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel.setBounds(270, 129, 200, 30);
		contentPane.add(lblNewLabel);
		
		/*
		 * Create User Password label
		 */
		JLabel lbl_UP = new JLabel("Password");
		lbl_UP.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_UP.setBounds(270, 170, 200, 30);
		contentPane.add(lbl_UP);
		
		/*
		 * Create Login button 
		 */
		btn_Login = new JButton("Login");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Query the Database and check if user name is a valid user name 
				 */
				try {
					/*
					 * Database query goes here 
					 */
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Username not Valid.");
				}
				
				/*
				 * Query Database to see if the password entered is valid
				 */
				try {
					/*
					 * Database query goes here
					 */
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null, "Password not valid.");
				}
				
				
			}
		});
		btn_Login.setFont(new Font("Calibri", Font.PLAIN, 20));
		btn_Login.setBounds(60, 230, 150, 50);
		contentPane.add(btn_Login);
		
		/*
		 * Create Password text box 
		 */
		txt_UP = new JPasswordField();
		txt_UP.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_UP.setBounds(60, 171, 200, 30);
		contentPane.add(txt_UP);
	}

}
