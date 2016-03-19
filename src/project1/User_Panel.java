package project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class User_Panel extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Panel frame = new User_Panel();
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
	public User_Panel() {
		setTitle("User Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * Create User profile banner label 
		 */
		contentPane.setLayout(null);
		JLabel lbl_User_Banner = new JLabel("User Account");
		lbl_User_Banner.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_User_Banner.setFont(new Font("Calibri", Font.PLAIN, 30));
		lbl_User_Banner.setBounds(418, 50, 200, 40);
		contentPane.add(lbl_User_Banner);
		
		/*
		 * Create book category drop down list button 
		 */
		final JComboBox CategoryBox = new JComboBox();
		CategoryBox.setBackground(Color.WHITE);
		CategoryBox.setFont(new Font("Calibri", Font.PLAIN, 18));
		CategoryBox.setBounds(10, 139, 200, 30);
		contentPane.add(CategoryBox);
		
		Connection conn = null;
		PreparedStatement ps;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://teamthree.cejfxkzyperf.us-west-2.rds.amazonaws.com:1433;" + 
					"databaseName=Project1", "admin", "Project1");		
				
			ps = conn.prepareStatement("SELECT * FROM [Book Category]");
			ResultSet results = ps.executeQuery();
				
			while(results.next()) {
				String name = results.getString("Book Category");
				CategoryBox.addItem(name);
			}
			results.close();
			conn.close();
		}
		catch(Exception e4) {
			JOptionPane.showMessageDialog(null, "Could not connect to database.");
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 220, 804, 380);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btn_data = new JButton("Load Books");
		btn_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement ps;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
					conn = DriverManager.getConnection("jdbc:sqlserver://teamthree.cejfxkzyperf.us-west-2.rds.amazonaws.com:1433;" + 
							"databaseName=Project1", "admin", "Project1");
					
					String selection = CategoryBox.getSelectedItem().toString();
					
					ps = conn.prepareStatement("SELECT * FROM ["+selection+"]");
					ResultSet results = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(results));
					results.close();
					conn.close();
				}
				catch(Exception e4) {
					JOptionPane.showMessageDialog(null, "Could not connect to database.");
				}
			}
		});
		btn_data.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_data.setBounds(10, 220, 150, 30);
		contentPane.add(btn_data);
		
		JButton btn_rent = new JButton("Rent Book");
		btn_rent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_rent.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_rent.setBounds(10, 274, 150, 30);
		contentPane.add(btn_rent);
	}
}
