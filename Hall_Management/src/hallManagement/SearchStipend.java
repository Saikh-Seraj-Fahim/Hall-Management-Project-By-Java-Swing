//Class-11.
package hallManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchStipend extends JFrame {
	private JLabel l1, l2;
	private JTextField t1, t2;
	private JButton b1, b2;
	private Container c;
	private Font f1, f2;

	SearchStipend() {
		// Front End.
		c = this.getContentPane();
		c.setLayout(null);

		f1 = new Font("Arial", Font.BOLD, 20);// for label and text field.
		f2 = new Font("Arial", Font.BOLD, 30);// for button.

		l1 = new JLabel("Enter Id : ");
		l1.setBounds(20, 80, 150, 40);
		l1.setFont(f1);
		c.add(l1);
		t1 = new JTextField();
		t1.setBounds(170, 80, 200, 40);
		t1.setFont(f1);
		c.add(t1);

		b1 = new JButton("Search");
		b1.setBounds(500, 80, 200, 60);
		b1.setFont(f2);
		c.add(b1);

		b2 = new JButton("Clear");
		b2.setBounds(500, 200, 200, 60);
		b2.setFont(f2);
		c.add(b2);

		l2 = new JLabel("Total Semester has been issued : ");
		l2.setBounds(20, 350, 350, 40);
		l2.setFont(f1);
		c.add(l2);
		t2 = new JTextField();
		t2.setBounds(370, 350, 200, 40);
		t2.setFont(f1);
		c.add(t2);

		// Back End.
		// Search Stipend Button.
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/StipendInformation", "root",
							"");
					PreparedStatement ps = con
							.prepareStatement("select Total_Semester from Stipend_Information where id=?");
					ps.setString(1, id);
					ResultSet rs = ps.executeQuery();
					if (rs.next() == false) {
						JOptionPane.showMessageDialog(null, "Sorry !! Not Our Student.");
						t1.setText("");
						t2.setText("");
						t1.requestFocus();
					} else {
						t2.setText(rs.getString("Total_Semester"));
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// Clear Stipend Button.
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t1.requestFocus();
			}
		});
	}

	public static void main(String[] args) {
		SearchStipend f = new SearchStipend();
		f.setBounds(50, 50, 900, 600);
		f.setVisible(true);
		f.setTitle("Search Stipend Information");
		f.getContentPane().setBackground(Color.ORANGE);
	}
}