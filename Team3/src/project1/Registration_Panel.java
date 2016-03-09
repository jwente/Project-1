package project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Registration_Panel extends JFrame {

	private JPanel contentPane;
	private JTextField txt_UN;
	private JTextField txt_FN;
	private JTextField txt_MI;
	private JTextField txt_LN;
	private JTextField txt_Email;
	private JTextField txt_PayPal;
	private JPasswordField txt_UP;
	private JPasswordField txt_CUP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration_Panel frame = new Registration_Panel();
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
	public Registration_Panel() {
		
		/*
		 * Create absolute layout panel 
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * Create User Registration banner label  
		 */
		JLabel lbl_Registration_Banner = new JLabel("User Registration");
		lbl_Registration_Banner.setFont(new Font("Calibri", Font.PLAIN, 30));
		lbl_Registration_Banner.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Registration_Banner.setBounds(235, 70, 305, 40);
		contentPane.add(lbl_Registration_Banner);
		
		/*
		 * Create User name text box 
		 */
		txt_UN = new JTextField();
		txt_UN.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_UN.setBounds(60, 130, 200, 30);
		contentPane.add(txt_UN);
		txt_UN.setColumns(10);
		
		/*
		 * Create First name text box 
		 */
		txt_FN = new JTextField();
		txt_FN.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_FN.setBounds(60, 253, 200, 30);
		contentPane.add(txt_FN);
		txt_FN.setColumns(10);
		
		/*
		 * Create Middle initial text box 
		 */
		txt_MI = new JTextField();
		txt_MI.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_MI.setBounds(60, 294, 50, 30);
		contentPane.add(txt_MI);
		txt_MI.setColumns(10);
		
		/*
		 * Create Last name text box 
		 */
		txt_LN = new JTextField();
		txt_LN.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_LN.setBounds(60, 335, 200, 30);
		contentPane.add(txt_LN);
		txt_LN.setColumns(10);
		
		/*
		 * Create Email text box
		 */
		txt_Email = new JTextField();
		txt_Email.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_Email.setBounds(60, 376, 200, 30);
		contentPane.add(txt_Email);
		txt_Email.setColumns(10);
		
		/*
		 * Create PayPal text box 
		 */
		txt_PayPal = new JTextField();
		txt_PayPal.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_PayPal.setBounds(60, 417, 200, 30);
		contentPane.add(txt_PayPal);
		txt_PayPal.setColumns(10);
		
		/*
		 * Create User name label 
		 */
		JLabel lbl_UN = new JLabel("Username");
		lbl_UN.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_UN.setBounds(270, 129, 200, 30);
		contentPane.add(lbl_UN);
		
		/*
		 * Create password label 
		 */
		JLabel lbl_UP = new JLabel("Password");
		lbl_UP.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_UP.setBounds(270, 170, 200, 30);
		contentPane.add(lbl_UP);
		
		/*
		 * Create Confirm password label 
		 */
		JLabel lbl_CUP = new JLabel("Confirm Passwrod");
		lbl_CUP.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_CUP.setBounds(270, 211, 200, 30);
		contentPane.add(lbl_CUP);
		
		/*
		 * Create First name label 
		 */
		JLabel lbl_FN = new JLabel("First Name");
		lbl_FN.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_FN.setBounds(270, 252, 200, 30);
		contentPane.add(lbl_FN);
		
		/*
		 * Create Middle initial label 
		 */
		JLabel lbl_MI = new JLabel("Middle Initial");
		lbl_MI.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_MI.setBounds(270, 293, 200, 30);
		contentPane.add(lbl_MI);
		
		/*
		 * Create Last name label 
		 */
		JLabel lbl_LN = new JLabel("Last Name");
		lbl_LN.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_LN.setBounds(270, 334, 200, 30);
		contentPane.add(lbl_LN);
		
		/*
		 * Create Email label 
		 */
		JLabel lbl_Email = new JLabel("Email");
		lbl_Email.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_Email.setBounds(270, 376, 200, 30);
		contentPane.add(lbl_Email);
		
		/*
		 * Create PayPal label 
		 */
		JLabel lbl_PayPal = new JLabel("PayPal");
		lbl_PayPal.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_PayPal.setBounds(270, 417, 200, 30);
		contentPane.add(lbl_PayPal);
		
		/*
		 * Create register button 
		 */
		JButton btn_Register = new JButton("Register");
		btn_Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Connect to the database and push the new users to the database 
				 */
				Connection conn = null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
					conn = DriverManager.getConnection("jdbc:sqlserver://teamthree.cejfxkzyperf.us-west-2.rds.amazonaws.com:1433;" + 
							"databaseName=Project1", "admin", "Project1");
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Could not connect to the Database.");
				}
				
				/*
				 * Try and write user information to database
				 */
				try {
					Statement stmt = conn.createStatement(); 
					/*
					stmt.execute("INSERT INTO USERS (USER_UN, USER_PASS, USER_FN, USER_MI, USER_LN, USER_EMAIL, USER_PAYPAL, USER_STATUS) VALUES ('"+username+
							"','"+password+"','"+firstname+"','"+mi+"','"+lastname+"','"+email+"','"+paypal+"','"+status+"');
					*/
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Could not write to Database.");
				}
			}
		});
		btn_Register.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_Register.setBounds(550, 270, 150, 50);
		contentPane.add(btn_Register);
		
		/*
		 * Create Faculty radio button 
		 */
		JRadioButton rdbtn_Faculty = new JRadioButton("Faculty");
		rdbtn_Faculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * IF checked push Faculty string to class object
				 */
			}
		});
		rdbtn_Faculty.setFont(new Font("Calibri", Font.PLAIN, 18));
		rdbtn_Faculty.setBounds(550, 134, 200, 30);
		contentPane.add(rdbtn_Faculty);
		
		/*
		 * Create Student radio button 
		 */
		JRadioButton rdbtn_Student = new JRadioButton("Student");
		rdbtn_Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * IF checked push Student string to class object
				 */
			}
		});
		rdbtn_Student.setFont(new Font("Calibri", Font.PLAIN, 18));
		rdbtn_Student.setBounds(550, 171, 200, 30);
		contentPane.add(rdbtn_Student);
		
		/*
		 * Create password text box
		 */
		txt_UP = new JPasswordField();
		txt_UP.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_UP.setBounds(60, 171, 200, 30);
		contentPane.add(txt_UP);
		
		/*
		 * Create confirm password text box
		 */
		txt_CUP = new JPasswordField();
		txt_CUP.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_CUP.setBounds(60, 212, 200, 30);
		contentPane.add(txt_CUP);
	}
}
