//Class-3.
package hallManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

public class Add extends JFrame {
	private Container c;
	private JLabel l1, l2, l3, l4, l5, l6;
	private JTextField t1, t2, t3, t4, t5, t6;
	private JButton b;
	private Font f1, f2;

	Add() {
		// Front End.
		c = this.getContentPane();
		c.setLayout(null);

		f1 = new Font("Arial", Font.BOLD, 20);// for label and text field.
		f2 = new Font("Arial", Font.BOLD, 40);// for button.

		l1 = new JLabel("1. Enter ID :");
		l1.setBounds(10, 20, 200, 50);
		l1.setFont(f1);
		c.add(l1);
		t1 = new JTextField();
		t1.setBounds(200, 20, 400, 40);
		t1.setFont(f1);
		c.add(t1);

		l2 = new JLabel("2. Enter Name :");
		l2.setBounds(10, 80, 200, 50);
		l2.setFont(f1);
		c.add(l2);
		t2 = new JTextField();
		t2.setBounds(200, 80, 400, 40);
		t2.setFont(f1);
		c.add(t2);

		l3 = new JLabel("3. Department :");
		l3.setBounds(10, 140, 200, 50);
		l3.setFont(f1);
		c.add(l3);
		t3 = new JTextField();
		t3.setBounds(200, 140, 400, 40);
		t3.setFont(f1);
		c.add(t3);

		l4 = new JLabel("4. Hall Clearance Till :");
		l4.setBounds(10, 200, 250, 50);
		l4.setFont(f1);
		c.add(l4);
		t4 = new JTextField();
		t4.setBounds(230, 200, 370, 40);
		t4.setFont(f1);
		c.add(t4);

		l5 = new JLabel("5. Room No :");
		l5.setBounds(10, 260, 200, 50);
		l5.setFont(f1);
		c.add(l5);
		t5 = new JTextField();
		t5.setBounds(200, 260, 400, 40);
		t5.setFont(f1);
		c.add(t5);

		l6 = new JLabel("6.Home District :");
		l6.setBounds(10, 320, 200, 50);
		l6.setFont(f1);
		c.add(l6);
		t6 = new JTextField();
		t6.setBounds(200, 320, 400, 40);
		t6.setFont(f1);
		c.add(t6);

		b = new JButton("Add");
		b.setBounds(600, 420, 200, 60);
		b.setFont(f2);
		c.add(b);

		// Back End.
		// Add Button.
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String name = t2.getText();
				String department = t3.getText();
				String hall_clearance = t4.getText();
				String room_no = t5.getText();
				String home_district = t6.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/My_Student_Information",
							"root", "");
					PreparedStatement ps = con.prepareStatement(
							"insert into StudentInformation(Id,Name,Department,Hall_Clearance,Room_No,Home_District)values(?,?,?,?,?,?)");
					ps.setString(1, id);
					ps.setString(2, name);
					ps.setString(3, department);
					ps.setString(4, hall_clearance);
					ps.setString(5, room_no);
					ps.setString(6, home_district);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Information Added Successfully.");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t1.requestFocus();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		Add f = new Add();
		f.setBounds(50, 50, 900, 600);
		f.setVisible(true);
		f.setTitle("Add Student Information");
		f.getContentPane().setBackground(Color.ORANGE);
	}
}