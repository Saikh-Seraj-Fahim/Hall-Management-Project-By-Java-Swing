//Class-4.
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

public class Delete extends JFrame {
	private Container c;
	private JLabel l;
	private JTextField t;
	private JButton b;
	private Font f1, f2;

	Delete() {
		// Front End.
		c = this.getContentPane();
		c.setLayout(null);

		f1 = new Font("Arial", Font.BOLD, 20);// for label and text field.
		f2 = new Font("Arial", Font.BOLD, 30);// for button.

		l = new JLabel("Enter Id for delete :");
		l.setBounds(20, 80, 200, 40);
		l.setFont(f1);
		c.add(l);

		t = new JTextField();
		t.setBounds(220, 80, 200, 40);
		t.setFont(f1);
		c.add(t);

		b = new JButton("Delete");
		b.setBounds(150, 300, 200, 60);
		b.setFont(f2);
		c.add(b);

		// Back End.
		// Delete Button.
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/My_Student_Information",
							"root", "");
					PreparedStatement ps = con.prepareStatement("delete from StudentInformation where Id=?");
					ps.setString(1, id);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Information Deleted Successfully.");
					t.setText("");
					t.requestFocus();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		Delete f = new Delete();
		f.setBounds(50, 50, 500, 500);
		f.setVisible(true);
		f.setTitle("Delete Student Information");
		f.getContentPane().setBackground(Color.ORANGE);
	}
}