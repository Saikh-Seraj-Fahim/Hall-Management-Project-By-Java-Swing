//Class-10.
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

public class UpdateStipend extends JFrame {
	private Container c;
	private JLabel l1, l2;
	private JTextField t1, t2;
	private JButton b;
	private Font f1, f2;

	UpdateStipend() {
		// Front End.
		c = this.getContentPane();
		c.setLayout(null);

		f1 = new Font("Arial", Font.BOLD, 20);// for label and text field.
		f2 = new Font("Arial", Font.BOLD, 30);// for button.

		l1 = new JLabel("Enter Id : ");
		l1.setBounds(10, 100, 200, 50);
		l1.setFont(f1);
		c.add(l1);
		t1 = new JTextField();
		t1.setBounds(200, 100, 400, 40);
		t1.setFont(f1);
		c.add(t1);

		l2 = new JLabel("Total Semester to be updated to : ");
		l2.setBounds(10, 250, 350, 50);
		l2.setFont(f1);
		c.add(l2);
		t2 = new JTextField();
		t2.setBounds(350, 250, 250, 40);
		t2.setFont(f1);
		c.add(t2);

		b = new JButton("Update");
		b.setBounds(600, 400, 200, 60);
		b.setFont(f2);
		c.add(b);

		// Back End.
		// Update Stipend Button.
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String total_semester = t2.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/StipendInformation", "root",
							"");
					PreparedStatement ps = con
							.prepareStatement("update Stipend_Information set Total_Semester=? where Id=?");
					ps.setString(1, total_semester);
					ps.setString(2, id);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Stipend  Information  Updated  Successfully.");
					t1.setText("");
					t2.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		UpdateStipend f = new UpdateStipend();
		f.setBounds(50, 50, 900, 600);
		f.setVisible(true);
		f.setTitle("Update  Stipend  Information");
		f.getContentPane().setBackground(Color.ORANGE);
	}
}