package project1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;

public class RegistrationPanel extends JFrame
{
    private JPanel contentPane;
    private JTextField txt_UN;
    private JTextField txt_FN;
    private JTextField txt_MI;
    private JTextField txt_LN;
    private JTextField txt_Email;
    private JTextField txt_PayPal;
    private JPasswordField txt_UP;
    private JPasswordField txt_CUP;

    ButtonGroup group;
    String firstname;
    String middleinitial;
    String lastname;
    String email;
    String paypal;
    String username;
    String password;
    String status;


    public void close() {

        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    /**
     * Create the frame.
     */
    public RegistrationPanel()
    {
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1020, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

		/*
		 * Create User Registration banner label
		 */
        contentPane.setLayout(null);
        contentPane.setLayout(null);
        JLabel lbl_Registration_Banner = new JLabel("User Registration");
        lbl_Registration_Banner.setFont(new Font("Calibri", Font.PLAIN, 30));
        lbl_Registration_Banner.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Registration_Banner.setBounds(379, 56, 305, 40);
        contentPane.add(lbl_Registration_Banner);

		/*
		 * Create User name text box
		 */
        txt_UN = new JTextField();
        txt_UN.setFont(new Font("Calibri", Font.PLAIN, 18));
        txt_UN.setBounds(207, 130, 200, 30);
        contentPane.add(txt_UN);
        txt_UN.setColumns(10);

		/*
		 * Create password text box
		 */
        txt_UP = new JPasswordField();
        txt_UP.setFont(new Font("Calibri", Font.PLAIN, 18));
        txt_UP.setBounds(207, 171, 200, 30);
        contentPane.add(txt_UP);

		/*
		 * Create confirm password text box
		 */
        txt_CUP = new JPasswordField();
        txt_CUP.setFont(new Font("Calibri", Font.PLAIN, 18));
        txt_CUP.setBounds(207, 212, 200, 30);
        contentPane.add(txt_CUP);

		/*
		 * Create First name text box
		 */
        txt_FN = new JTextField();
        txt_FN.setFont(new Font("Calibri", Font.PLAIN, 18));
        txt_FN.setBounds(207, 254, 200, 30);
        contentPane.add(txt_FN);
        txt_FN.setColumns(10);

		/*
		 * Create Middle initial text box
		 */
        txt_MI = new JTextField();
        txt_MI.setFont(new Font("Calibri", Font.PLAIN, 18));
        txt_MI.setBounds(207, 295, 50, 30);
        contentPane.add(txt_MI);
        txt_MI.setColumns(10);

		/*
		 * Create Last name text box
		 */
        txt_LN = new JTextField();
        txt_LN.setFont(new Font("Calibri", Font.PLAIN, 18));
        txt_LN.setBounds(207, 335, 200, 30);
        contentPane.add(txt_LN);
        txt_LN.setColumns(10);

		/*
		 * Create Email text box
		 */
        txt_Email = new JTextField();
        txt_Email.setFont(new Font("Calibri", Font.PLAIN, 18));
        txt_Email.setBounds(207, 376, 200, 30);
        contentPane.add(txt_Email);
        txt_Email.setColumns(10);

		/*
		 * Create PayPal text box
		 */
        txt_PayPal = new JTextField();
        txt_PayPal.setFont(new Font("Calibri", Font.PLAIN, 18));
        txt_PayPal.setBounds(207, 417, 200, 30);
        contentPane.add(txt_PayPal);
        txt_PayPal.setColumns(10);

		/*
		 * Create User name label
		 */
        JLabel lbl_UN = new JLabel("Username:");
        lbl_UN.setFont(new Font("Calibri", Font.PLAIN, 18));
        lbl_UN.setBounds(60, 130, 200, 30);
        contentPane.add(lbl_UN);

		/*
		 * Create password label
		 */
        JLabel lbl_UP = new JLabel("Password:");
        lbl_UP.setFont(new Font("Calibri", Font.PLAIN, 18));
        lbl_UP.setBounds(60, 171, 200, 30);
        contentPane.add(lbl_UP);

		/*
		 * Create Confirm password label
		 */
        JLabel lbl_CUP = new JLabel("Confirm Password:");
        lbl_CUP.setFont(new Font("Calibri", Font.PLAIN, 18));
        lbl_CUP.setBounds(60, 212, 200, 30);
        contentPane.add(lbl_CUP);

		/*
		 * Create First name label
		 */
        JLabel lbl_FN = new JLabel("First Name:");
        lbl_FN.setFont(new Font("Calibri", Font.PLAIN, 18));
        lbl_FN.setBounds(60, 253, 200, 30);
        contentPane.add(lbl_FN);

		/*
		 * Create Middle initial label
		 */
        JLabel lbl_MI = new JLabel("Middle Initial:");
        lbl_MI.setFont(new Font("Calibri", Font.PLAIN, 18));
        lbl_MI.setBounds(60, 294, 200, 30);
        contentPane.add(lbl_MI);

		/*
		 * Create Last name label
		 */
        JLabel lbl_LN = new JLabel("Last Name:");
        lbl_LN.setFont(new Font("Calibri", Font.PLAIN, 18));
        lbl_LN.setBounds(60, 336, 200, 30);
        contentPane.add(lbl_LN);

		/*
		 * Create Email label
		 */
        JLabel lbl_Email = new JLabel("Email:");
        lbl_Email.setFont(new Font("Calibri", Font.PLAIN, 18));
        lbl_Email.setBounds(60, 376, 200, 30);
        contentPane.add(lbl_Email);

		/*
		 * Create PayPal label
		 */
        JLabel lbl_PayPal = new JLabel("PayPal:");
        lbl_PayPal.setFont(new Font("Calibri", Font.PLAIN, 18));
        lbl_PayPal.setBounds(60, 416, 200, 30);
        contentPane.add(lbl_PayPal);

		/*
		 * Create Faculty radio button
		 */
        final JRadioButton rdbtn_Faculty = new JRadioButton("Faculty");
        rdbtn_Faculty.setFont(new Font("Calibri", Font.PLAIN, 18));
        rdbtn_Faculty.setBounds(60, 471, 200, 30);
        contentPane.add(rdbtn_Faculty);

		/*
		 * Create Student radio button
		 */
        final JRadioButton rdbtn_Student = new JRadioButton("Student");
        rdbtn_Student.setFont(new Font("Calibri", Font.PLAIN, 18));
        rdbtn_Student.setBounds(278, 471, 200, 30);
        contentPane.add(rdbtn_Student);

        group = new ButtonGroup();
        group.add(rdbtn_Faculty);
        group.add(rdbtn_Student);

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
                try
                {
                    if(String.valueOf(txt_CUP.getPassword()).compareTo(String.valueOf(txt_UP.getPassword())) == 0)
                    {
                        if (rdbtn_Faculty.isSelected())
                        {

                            firstname = txt_FN.getText();
                            middleinitial = txt_MI.getText();
                            lastname = txt_LN.getText();
                            email = txt_Email.getText();
                            paypal = txt_PayPal.getText();
                            username = txt_UN.getText();
                            password = txt_UP.getPassword().toString();
                            status = "Faculty";

                        }
                        else if (rdbtn_Student.isSelected())
                        {
                            firstname = txt_FN.getText();
                            middleinitial = txt_MI.getText();
                            lastname = txt_LN.getText();
                            email = txt_Email.getText();
                            paypal = txt_PayPal.getText();
                            username = txt_UN.getText();
                            password = txt_UP.getPassword().toString();
                            status = "Student";
                        }

                        if (username == null || password == null || firstname == null || middleinitial == null || lastname == null) {
                            JOptionPane.showMessageDialog(null, "Please provide listed information.");

                            RegistrationPanel registration = new RegistrationPanel();
                            registration.repaint();
                        } else {
                            Statement stmt = conn.createStatement();
                            stmt.execute("INSERT INTO Users ([Users UN], [Users Pass], [Users FN], [Users MI], [Users LN], [Users Email], [Users Paypal], [Users Status]) VALUES ('"
                                    + username + "','" + password + "','" + firstname + "','" + middleinitial + "','" + lastname + "','" + email + "','" + paypal + "','" + status + "')");

                            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM [Users]");
                            ResultSet resultSet = ps.executeQuery();

                            if(resultSet.next())
                            {
                                if(status.equalsIgnoreCase("Student"))
                                {
                                    Main.user = new Student(resultSet.getInt(1), firstname, middleinitial, lastname, email, username, password, paypal);
                                }
                                else
                                {
                                    Main.user = new Faculty(resultSet.getInt(1), firstname, middleinitial, lastname, email, username, password, paypal);
                                }
                            }

                            conn.close();
                            close();
                            LoginPanel login = new LoginPanel();
                            login.setVisible(true);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Passwords do not match.");

                        RegistrationPanel registrationPanel = new RegistrationPanel();
                        registrationPanel.repaint();
                    }
                }
                catch(Exception e2) {
                    JOptionPane.showMessageDialog(null, "Could not write to Database.");
                }
            }
        });
        btn_Register.setFont(new Font("Calibri", Font.PLAIN, 18));
        btn_Register.setBounds(477, 514, 150, 50);
        contentPane.add(btn_Register);
    }

}
