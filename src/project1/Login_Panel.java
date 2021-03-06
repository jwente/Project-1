package project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

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
	
	/*
	 * Code block for closing content panel is from ProgrammingKnowledge
	 */
	public void close() {
		
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * Create the frame.
	 */
	public Login_Panel() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * Create User name text box
		 */
		txt_UN = new JTextField();
		txt_UN.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_UN.setBounds(156, 129, 200, 30);
		contentPane.add(txt_UN);
		txt_UN.setColumns(10);
		
		/*
		 * Create Password text box 
		 */
		txt_UP = new JPasswordField();
		txt_UP.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_UP.setBounds(156, 170, 200, 30);
		contentPane.add(txt_UP);
		
		/*
		 * Create the welcome banner label 
		 */
		JLabel lbl_Login_Banner = new JLabel("Login");
		lbl_Login_Banner.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Login_Banner.setFont(new Font("Calibri", Font.PLAIN, 30));
		lbl_Login_Banner.setBounds(85, 60, 305, 40);
		contentPane.add(lbl_Login_Banner);
		
		/*
		 * Create User name label
		 */
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel.setBounds(60, 128, 200, 30);
		contentPane.add(lblNewLabel);
		
		/*
		 * Create User Password label
		 */
		JLabel lbl_UP = new JLabel("Password:");
		lbl_UP.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_UP.setBounds(60, 170, 200, 30);
		contentPane.add(lbl_UP);
		
		/*
		 * Create Login button 
		 */
		btn_Login = new JButton("User Login");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null;
				PreparedStatement ps;
				/*
				 * Make connection to database and execute query
				 */
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
					conn = DriverManager.getConnection("jdbc:sqlserver://teamthree.cejfxkzyperf.us-west-2.rds.amazonaws.com:1433;" + 
							"databaseName=Project1", "admin", "Project1");
					
					/*
					 * Query database for user login credentials 
					 */
					ps = conn.prepareStatement("SELECT [Users UN], [Users Pass] FROM [Users] WHERE [Users UN] = ? AND [Users Pass] = ?");
					ps.setString(1, txt_UN.getText());
					ps.setString(2, String.valueOf(txt_UP.getText()));
					ResultSet result = ps.executeQuery();
					if(result.next()) {			
						JOptionPane.showMessageDialog(null, result.getString(1));									
						if(result.getString(1).compareTo("admin") == 0) {
							close();
							Admin_Panel admin = new Admin_Panel();
							admin.setVisible(true);
							result.close();
						}
						else {
							close();
							User_Panel user = new User_Panel();
							user.setVisible(true);
							result.close();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
					}
					conn.close();
				}
				catch(Exception e4) {
					JOptionPane.showMessageDialog(null, "Could not connect to database.");
				}	
			}
		});
		btn_Login.setFont(new Font("Calibri", Font.PLAIN, 20));
		btn_Login.setBounds(165, 235, 150, 50);
		contentPane.add(btn_Login);
	}
}
