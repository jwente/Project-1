package project1;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by noah-pena on 3/10/16.
 */
public class AdminPanel extends JFrame
{
    private JPanel contentPane;
    private JTable table;

    public AdminPanel() {
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

        final JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Calibri", Font.PLAIN, 18));
        comboBox.setBounds(10, 120, 200, 30);
        contentPane.add(comboBox);

        Connection conn = null;
        PreparedStatement ps;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://teamthree.cejfxkzyperf.us-west-2.rds.amazonaws.com:1433;" +
                    "databaseName=Project1", "admin", "Project1");

            ps = conn.prepareStatement("SELECT [Users UN] FROM [Users]");
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                String name = resultSet.getString(1);
                comboBox.addItem(name);
            }
            resultSet.close();
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

                    ps = conn.prepareStatement("SELECT [Oders ID], [Book Category], [Book Name], [Quantity], [Price], [Date Due] FROM [Orders] WHERE [Users ID] = ?");
                    ps.setString(1, Integer.toString(comboBox.getSelectedIndex() + 1));
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

//        JButton btn_update = new JButton("update Table ");
//        btn_update.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//        btn_update.setFont(new Font("Calibri", Font.PLAIN, 18));
//        btn_update.setBounds(10, 273, 150, 30);
//        contentPane.add(btn_update);

//        JButton btn_insert = new JButton("Insert Row");
//        btn_insert.setFont(new Font("Calibri", Font.PLAIN, 18));
//        btn_insert.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//            }
//        });
//        btn_insert.setBounds(10, 335, 150, 30);
//        contentPane.add(btn_insert);
//
//        JButton btn_delete = new JButton("Delete Row");
//        btn_delete.setFont(new Font("Calibri", Font.PLAIN, 18));
//        btn_delete.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//        btn_delete.setBounds(10, 395, 150, 30);
//        contentPane.add(btn_delete);
    }
}
