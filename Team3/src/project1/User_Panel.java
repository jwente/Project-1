package project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class User_Panel extends JFrame {

	private JPanel contentPane;

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
		 * Create User profile banner label 
		 */
		JLabel lbl_User_Banner = new JLabel("User Profile ");
		lbl_User_Banner.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_User_Banner.setFont(new Font("Calibri", Font.PLAIN, 30));
		lbl_User_Banner.setBounds(280, 50, 200, 40);
		contentPane.add(lbl_User_Banner);
		
		/*
		 * Create book category drop down list button 
		 */
		JComboBox CategoryBox = new JComboBox();
		CategoryBox.setFont(new Font("Calibri", Font.PLAIN, 18));
		CategoryBox.setBounds(60, 125, 200, 30);
		contentPane.add(CategoryBox);
		
		/*
		 * Create book category label 
		 */
		JLabel lbl_Book_Cat = new JLabel("Book Categories");
		lbl_Book_Cat.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_Book_Cat.setBounds(280, 125, 200, 30);
		contentPane.add(lbl_Book_Cat);
	}
}
