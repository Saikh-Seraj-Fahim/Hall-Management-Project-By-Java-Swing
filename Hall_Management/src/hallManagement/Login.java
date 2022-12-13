//Class-1.
package hallManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	private Container c;
	private JLabel l1, l2, l3;
	private JTextField t;
	private JPasswordField p;
	private JButton b;
	private Font f1, f2, f3;

	Login() {
		// Front End.
		c = this.getContentPane();
		c.setLayout(null);

		f1 = new Font("Arial", Font.BOLD, 40);// for label1.
		f2 = new Font("Arial", Font.BOLD, 20);// for label2,label3,text field and password field.
		f3 = new Font("Arial", Font.BOLD, 30);// for button.

		l1 = new JLabel("Welcome To Hall Management System");
		l1.setBounds(70, 50, 900, 60);
		l1.setFont(f1);
		c.add(l1);

		l2 = new JLabel("Username : ");
		l2.setBounds(40, 150, 200, 60);
		l2.setFont(f2);
		c.add(l2);
		t = new JTextField();
		t.setBounds(200, 150, 300, 50);
		t.setFont(f2);
		c.add(t);

		l3 = new JLabel("Password : ");
		l3.setBounds(40, 240, 200, 60);
		l3.setFont(f2);
		c.add(l3);
		p = new JPasswordField();
		p.setEchoChar('*');
		p.setBounds(200, 240, 300, 50);
		p.setFont(f2);
		c.add(p);

		b = new JButton("Login");
		b.setBounds(500, 400, 200, 60);
		b.setFont(f3);
		c.add(b);

		// Back End.
		// Login Button.
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = t.getText();
				String pw = p.getText();
				if (un.equals("HallManagementSystem") && pw.equals("*Hall#")) {
					HomePage a = new HomePage();
					a.setBounds(50, 50, 900, 600);
					a.setVisible(true);
					a.setTitle("Hall  Management  System");
					a.getContentPane().setBackground(Color.ORANGE);
				} else {
					JOptionPane.showMessageDialog(null, "Please Enter Correct Username and Password.");
					t.setText("");
					p.setText("");
					t.requestFocus();
				}
			}
		});
	}

	public static void main(String[] args) {
		Login f = new Login();
		f.setBounds(50, 50, 900, 600);
		f.setVisible(true);
		f.setTitle("Login  Page");
		f.getContentPane().setBackground(Color.ORANGE);
	}
}


//This gives label3,text field , password field and button hidden. 
/*
package hallManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

	private static Container c;
	private static JLabel l1, l2, l3;
	private static JTextField t;
	private static JPasswordField p;
	private static JButton b;
	private static Font f1, f2, f3;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(50, 50, 900, 600);
		frame.setVisible(true);
		frame.setTitle("Login  Page");
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Front End.
		c = frame.getContentPane();
		c.setLayout(null);

		f1 = new Font("Arial", Font.BOLD, 40);// for label1.
		f2 = new Font("Arial", Font.BOLD, 20);// for label2,label3,text field and password field..
		f3 = new Font("Arial", Font.BOLD, 30);// for button.

		l1 = new JLabel("Welcome To Hall Management System");
		l1.setBounds(70, 50, 900, 60);
		l1.setFont(f1);
		c.add(l1);

		l2 = new JLabel("Username : ");
		l2.setBounds(40, 150, 200, 60);
		l2.setFont(f2);
		c.add(l2);
		t = new JTextField();
		t.setBounds(200, 150, 300, 50);
		t.setFont(f2);
		c.add(t);

		l3 = new JLabel("Password : ");
		l3.setBounds(40, 240, 200, 60);
		l3.setFont(f2);
		c.add(l3);
		p = new JPasswordField();
		p.setEchoChar('*');
		p.setBounds(200, 240, 300, 50);
		p.setFont(f2);
		c.add(p);

		b = new JButton("Login");
		b.setBounds(500, 400, 200, 60);
		b.setFont(f3);
		c.add(b);

		// Back End.
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = t.getText();
				String pw = p.getText();
				if (un.equals("HallManagementSystem") && pw.equals("*Hall#")) {
					HomePage a = new HomePage();
					a.setBounds(50, 50, 900, 600);
					a.setVisible(true);
					a.setTitle("Hall  Management  System");
					a.getContentPane().setBackground(Color.ORANGE);
				} else {
					JOptionPane.showMessageDialog(null, "Please Enter Correct Username and Password.");
				}
			}
		});

	}
}
 */