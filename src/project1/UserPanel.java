package project1;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by noah-pena on 3/10/16.
 */
public class UserPanel extends JFrame
{
    private JPanel contentPane;
    private JTable table;


    public UserPanel() {
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
            public void actionPerformed(ActionEvent e)
            {
                String selection = CategoryBox.getSelectedItem().toString();

                final ArrayList<Book> books = Main.store.getBookListByGenre(Book.convertStringToGenre(selection));

                DefaultTableModel model = new DefaultTableModel()
                {
                    String[] columns = {"Book Name"};

                    @Override
                    public int getColumnCount()
                    {
                        return 1;
                    }

                    @Override
                    public boolean isCellEditable(int row, int col)
                    {
                        return false;
                    }

                    @Override
                    public String getColumnName(int index)
                    {
                        return columns[index];
                    }
                };

                for(int i = 0; i < books.size(); i++)
                {
                    Object[] data = {books.get(i).getName()};

                    model.addRow(data);
                }

                table.setModel(model);

//                Connection conn = null;
//                PreparedStatement ps;
//                try
//                {
//                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
//                    conn = DriverManager.getConnection("jdbc:sqlserver://teamthree.cejfxkzyperf.us-west-2.rds.amazonaws.com:1433;" +
//                            "databaseName=Project1", "admin", "Project1");
//
//                    String selection = CategoryBox.getSelectedItem().toString();
//
//                    ps = conn.prepareStatement("SELECT * FROM ["+selection+"]");
//                    ResultSet results = ps.executeQuery();
//                    table.setModel(DbUtils.resultSetToTableModel(results));
//
//                    results.close();
//                    conn.close();
//                }
//                catch(Exception e4) {
//                    JOptionPane.showMessageDialog(null, "Could not connect to database.");
//                }
            }
        });
        btn_data.setFont(new Font("Calibri", Font.PLAIN, 18));
        btn_data.setBounds(10, 220, 150, 30);
        contentPane.add(btn_data);

        JButton btn_rent = new JButton("Rent Book");
        btn_rent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0)
            {
                String name = table.getModel().getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();


            }
        });
        btn_rent.setFont(new Font("Calibri", Font.PLAIN, 18));
        btn_rent.setBounds(10, 274, 150, 30);
        contentPane.add(btn_rent);
    }
}
