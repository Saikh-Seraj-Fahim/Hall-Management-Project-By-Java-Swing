//Class-6.
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
import java.sql.ResultSet;
import java.sql.DriverManager;

public class Search extends JFrame {
	private Container c;
	private JLabel l1, l2, l3, l4, l5, l6;
	private JTextField t1, t2, t3, t4, t5, t6;
	private JButton b1, b2;
	private Font f1, f2;

	Search() {
		// Front End.
		c = this.getContentPane();
		c.setLayout(null);

		f1 = new Font("Arial", Font.BOLD, 20);// for label and text field.
		f2 = new Font("Arial", Font.BOLD, 30);// for button.

		l1 = new JLabel("Enter Id for search");
		l1.setBounds(20, 80, 200, 40);
		l1.setFont(f1);
		c.add(l1);
		t1 = new JTextField();
		t1.setBounds(220, 80, 200, 40);
		t1.setFont(f1);
		c.add(t1);

		b1 = new JButton("Search");
		b1.setBounds(500, 80, 200, 60);
		b1.setFont(f2);
		c.add(b1);

		b2 = new JButton("Clear");
		b2.setBounds(800, 80, 200, 60);
		b2.setFont(f2);
		c.add(b2);

		l2 = new JLabel("Name : ");
		l2.setBounds(20, 230, 150, 40);
		l2.setFont(f1);
		c.add(l2);
		t2 = new JTextField();
		t2.setBounds(170, 230, 300, 40);
		t2.setFont(f1);
		c.add(t2);

		l3 = new JLabel("Department : ");
		l3.setBounds(20, 300, 150, 40);
		l3.setFont(f1);
		c.add(l3);
		t3 = new JTextField();
		t3.setBounds(170, 300, 300, 40);
		t3.setFont(f1);
		c.add(t3);

		l4 = new JLabel("Hall Clearance Till : ");
		l4.setBounds(20, 370, 190, 40);
		l4.setFont(f1);
		c.add(l4);
		t4 = new JTextField();
		t4.setBounds(210, 370, 260, 40);
		t4.setFont(f1);
		c.add(t4);

		l5 = new JLabel("Room No : ");
		l5.setBounds(20, 440, 150, 40);
		l5.setFont(f1);
		c.add(l5);
		t5 = new JTextField();
		t5.setBounds(170, 440, 300, 40);
		t5.setFont(f1);
		c.add(t5);

		l6 = new JLabel("Home District : ");
		l6.setBounds(20, 510, 150, 40);
		l6.setFont(f1);
		c.add(l6);
		t6 = new JTextField();
		t6.setBounds(170, 510, 300, 40);
		t6.setFont(f1);
		c.add(t6);

		// Back End.
		// Search Button.
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/My_Student_Information",
							"root", "");
					PreparedStatement ps = con.prepareStatement(
							"select Name,Department,Hall_Clearance,Room_No,Home_District from StudentInformation where Id=?");
					ps.setString(1, id);
					ResultSet rs = ps.executeQuery();
					if (rs.next() == false) {
						JOptionPane.showMessageDialog(null, "Sorry !! Not Our Student.");
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
						t6.setText("");
						t1.requestFocus();
					} else {
						t2.setText(rs.getString("name"));
						t3.setText(rs.getString("department"));
						t4.setText(rs.getString("hall_clearance"));
						t5.setText(rs.getString("room_no"));
						t6.setText(rs.getString("home_district"));
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// Clear Button.
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t1.requestFocus();
			}
		});
	}

	public static void main(String[] args) {
		Search f = new Search();
		f.setBounds(50, 50, 1100, 650);
		f.setVisible(true);
		f.setTitle("Search Student Information");
		f.getContentPane().setBackground(Color.ORANGE);
	}
}