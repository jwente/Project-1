package project1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by noah-pena on 3/10/16.
 */
public class AdminPanel extends JFrame
{
    private JPanel contentPane;


    public AdminPanel()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbl_Admin_Banner = new JLabel("Admin Profile");
        lbl_Admin_Banner.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Admin_Banner.setFont(new Font("Calibri", Font.PLAIN, 30));
        lbl_Admin_Banner.setBounds(280, 50, 200, 40);
        contentPane.add(lbl_Admin_Banner);
    }
}
