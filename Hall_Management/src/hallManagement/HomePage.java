//Class-2.
package hallManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
	private Container c;
	private JLabel l;
	private JButton b1, b2, b3, b4, b5;
	private Font f1, f2;

	HomePage() {
		// Front End.
		c = this.getContentPane();
		c.setLayout(null);

		f1 = new Font("Arial", Font.BOLD, 55);// for label.
		f2 = new Font("Arial", Font.BOLD, 30);// for button.

		l = new JLabel("Hall  Management  System");
		l.setBounds(100, 20, 700, 100);
		l.setFont(f1);
		c.add(l);

		b1 = new JButton("Add");
		b1.setBounds(150, 200, 200, 60);
		b1.setFont(f2);
		c.add(b1);

		b2 = new JButton("Delete");
		b2.setBounds(500, 200, 200, 60);
		b2.setFont(f2);
		c.add(b2);

		b3 = new JButton("Update");
		b3.setBounds(150, 320, 200, 60);
		b3.setFont(f2);
		c.add(b3);

		b4 = new JButton("Search");
		b4.setBounds(500, 320, 200, 60);
		b4.setFont(f2);
		c.add(b4);

		b5 = new JButton("Stipend");
		b5.setBounds(320, 450, 200, 60);
		b5.setFont(f2);
		c.add(b5);

		// Back End.
		// Add Button.
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add a = new Add();
				a.setBounds(50, 50, 900, 600);
				a.setVisible(true);
				a.setTitle("Add Student Information");
				a.getContentPane().setBackground(Color.ORANGE);
			}
		});

		// Delete Button.
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete b = new Delete();
				b.setBounds(50, 50, 500, 500);
				b.setVisible(true);
				b.setTitle("Delete Student Information");
				b.getContentPane().setBackground(Color.ORANGE);
			}
		});

		// Update Button.
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update c = new Update();
				c.setBounds(50, 50, 900, 600);
				c.setVisible(true);
				c.setTitle("Update Student Information");
				c.getContentPane().setBackground(Color.ORANGE);
			}
		});

		// Search Button.
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search d = new Search();
				d.setBounds(50, 50, 1100, 650);
				d.setVisible(true);
				d.setTitle("Search Student Information");
				d.getContentPane().setBackground(Color.ORANGE);
			}
		});

		// Stipend Button.
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stipend f = new Stipend();
				f.setBounds(50, 50, 900, 600);
				f.setVisible(true);
				f.setTitle("Stipend Information");
				f.getContentPane().setBackground(Color.ORANGE);
			}
		});
	}

	public static void main(String[] args) {
		HomePage f = new HomePage();
		f.setBounds(50, 50, 900, 600);
		f.setVisible(true);
		f.setTitle("Hall  Management  System");
		f.getContentPane().setBackground(Color.ORANGE);
	}
}