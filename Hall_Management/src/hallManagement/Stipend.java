//Class-7.
package hallManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Stipend extends JFrame {
	private Container c;
	private JLabel l;
	private JButton b1, b2, b3, b4;
	private Font f1, f2;

	Stipend() {
		// Front End.
		c = this.getContentPane();
		c.setLayout(null);

		f1 = new Font("Arial", Font.BOLD, 50);// for label.
		f2 = new Font("Arial", Font.BOLD, 30);// for button.

		l = new JLabel("Stipend  Information");
		l.setBounds(200, 30, 500, 60);
		l.setFont(f1);
		c.add(l);

		b1 = new JButton("Add");
		b1.setBounds(150, 200, 200, 60);
		b1.setFont(f2);
		c.add(b1);

		b2 = new JButton("Delete");
		b2.setBounds(550, 200, 200, 60);
		b2.setFont(f2);
		c.add(b2);

		b3 = new JButton("Update");
		b3.setBounds(150, 350, 200, 60);
		b3.setFont(f2);
		c.add(b3);

		b4 = new JButton("Search");
		b4.setBounds(550, 350, 200, 60);
		b4.setFont(f2);
		c.add(b4);

		// Back End.
		// Add Button.
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStipend a = new AddStipend();
				a.setBounds(50, 50, 900, 600);
				a.setVisible(true);
				a.setTitle("Add Stipend Information");
				a.getContentPane().setBackground(Color.ORANGE);
			}
		});

		// Delete Button.
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStipend b = new DeleteStipend();
				b.setBounds(50, 50, 500, 500);
				b.setVisible(true);
				b.setTitle("Delete Stipend Information");
				b.getContentPane().setBackground(Color.ORANGE);
			}
		});

		// Update Button.
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStipend c = new UpdateStipend();
				c.setBounds(50, 50, 900, 600);
				c.setVisible(true);
				c.setTitle("Update  Stipend  Information");
				c.getContentPane().setBackground(Color.ORANGE);
			}
		});

		// Search button.
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchStipend d = new SearchStipend();
				d.setBounds(50, 50, 900, 600);
				d.setVisible(true);
				d.setTitle("Search Stipend Information");
				d.getContentPane().setBackground(Color.ORANGE);
			}
		});
	}

	public static void main(String[] args) {
		Stipend f = new Stipend();
		f.setBounds(50, 50, 900, 600);
		f.setVisible(true);
		f.setTitle("Stipend Information");
		f.getContentPane().setBackground(Color.ORANGE);
	}
}