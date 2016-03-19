package project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Admin_Panel extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Panel frame = new Admin_Panel();
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
	public Admin_Panel() {
		setTitle("Admin Account");
		/*
		 * Create absolute layout panel 
		 */
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1020, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Admin_Banner = new JLabel("Admin Account");
		lbl_Admin_Banner.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Admin_Banner.setFont(new Font("Calibri", Font.PLAIN, 30));
		lbl_Admin_Banner.setBounds(421, 50, 200, 40);
		contentPane.add(lbl_Admin_Banner);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 18));
		comboBox.setBounds(10, 120, 200, 30);
		contentPane.add(comboBox);
		
		Connection conn = null;
		PreparedStatement ps;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://teamthree.cejfxkzyperf.us-west-2.rds.amazonaws.com:1433;" + 
					"databaseName=Project1", "admin", "Project1");		
				
			
			ResultSet results = conn.getMetaData().getTables("Project1", "dbo", null, null);
			ResultSetMetaData meta = (ResultSetMetaData) results.getMetaData();
			
			int columns = meta.getColumnCount();
				
			while(results.next()) {
				String name = results.getString("TABLE_NAME");
				comboBox.addItem(name);
			}
			results.close();
		}
		catch(Exception e4) {
			JOptionPane.showMessageDialog(null, "Could not connect to database.");
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 209, 824, 391);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btn_load = new JButton("Load Table");
		btn_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null;
				PreparedStatement ps;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
					conn = DriverManager.getConnection("jdbc:sqlserver://teamthree.cejfxkzyperf.us-west-2.rds.amazonaws.com:1433;" + 
							"databaseName=Project1", "admin", "Project1");
					
					String selection = comboBox.getSelectedItem().toString();
					
					ps = conn.prepareStatement("SELECT * FROM ["+selection+"]");
					ResultSet results = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(results));
					results.close();
					conn.close();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Could not connect to the Database.");
				}
			}
		});
		btn_load.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_load.setBounds(10, 209, 150, 30);
		contentPane.add(btn_load);
		
		JButton btn_update = new JButton("update Table ");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_update.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_update.setBounds(10, 273, 150, 30);
		contentPane.add(btn_update);
		
		JButton btn_insert = new JButton("Insert Row");
		btn_insert.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_insert.setBounds(10, 335, 150, 30);
		contentPane.add(btn_insert);
		
		JButton btn_delete = new JButton("Delete Row");
		btn_delete.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_delete.setBounds(10, 395, 150, 30);
		contentPane.add(btn_delete);
	}
}
