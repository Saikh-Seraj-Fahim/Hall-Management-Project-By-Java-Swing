//Class-8.
package hallManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddStipend extends JFrame {
	private Container c;
	private JLabel l1, l2, l3, l4;
	private JTextField t1, t2, t3, t4;
	private JButton b;
	private Font f1, f2;

	AddStipend() {
		// Front End.
		c = this.getContentPane();
		c.setLayout(null);

		f1 = new Font("Arial", Font.BOLD, 25);// for label and text field.
		f2 = new Font("Arial", Font.BOLD, 50);// for button.

		l1 = new JLabel("1. Enter Id : ");
		l1.setBounds(10, 20, 250, 50);
		l1.setFont(f1);
		c.add(l1);
		t1 = new JTextField();
		t1.setBounds(250, 20, 350, 40);
		t1.setFont(f1);
		c.add(t1);

		l2 = new JLabel("2. Enter Name : ");
		l2.setBounds(10, 100, 250, 50);
		l2.setFont(f1);
		c.add(l2);
		t2 = new JTextField();
		t2.setBounds(250, 100, 350, 40);
		t2.setFont(f1);
		c.add(t2);

		l3 = new JLabel("3. Department : ");
		l3.setBounds(10, 180, 250, 50);
		l3.setFont(f1);
		c.add(l3);
		t3 = new JTextField();
		t3.setBounds(250, 180, 350, 40);
		t3.setFont(f1);
		c.add(t3);

		l4 = new JLabel("4. Total Semester : ");
		l4.setBounds(10, 260, 250, 50);
		l4.setFont(f1);
		c.add(l4);
		t4 = new JTextField();
		t4.setBounds(250, 260, 350, 40);
		t4.setFont(f1);
		c.add(t4);

		b = new JButton("Add");
		b.setBounds(600, 400, 200, 80);
		b.setFont(f2);
		c.add(b);

		// Back End.
		// Add Stipend Button.
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String name = t2.getText();
				String department = t3.getText();
				String total_semester = t4.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/StipendInformation", "root",
							"");
					PreparedStatement ps = con.prepareStatement(
							"insert into Stipend_Information(Id,Name,Department,Total_Semester)values(?,?,?,?)");
					ps.setString(1, id);
					ps.setString(2, name);
					ps.setString(3, department);
					ps.setString(4, total_semester);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Stipend Information Added Successfully.");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		AddStipend f = new AddStipend();
		f.setBounds(50, 50, 900, 600);
		f.setVisible(true);
		f.setTitle("Add Stipend Information");
		f.getContentPane().setBackground(Color.ORANGE);
	}
}