package admin_login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import adminno.admin;
import Mmenu.menu;

public class log_in extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailtext;
	private JPasswordField passwordField;


	public log_in() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 329);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(216, 10, 2, 2);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(86, 135, 91, 14);
		contentPane.add(lblNewLabel);
		
		emailtext = new JTextField();
		emailtext.setBackground(new Color(245, 245, 245));
		emailtext.setBounds(86, 94, 214, 34);
		contentPane.add(emailtext);
		emailtext.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(87, 69, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(133, 10, 116, 29);
		contentPane.add(lblNewLabel_2);
		
		JButton login = new JButton("LOGIN");
		login.setBackground(new Color(25, 25, 112));
		login.setForeground(new Color(255, 255, 255));
		login.addActionListener(new ActionListener() {
		       
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> new menu("User"));
				admin ad = new admin();
				if(e.getSource()==login) {
					ad.setEmail(emailtext.getText());
					char[] passwordChars = passwordField.getPassword();
					String passwordString = new String(passwordChars);
					ad.setPassword(passwordString);
					ad.login();
					dispose();
				}
			}
		});
		login.setBounds(88, 225, 212, 39);
		contentPane.add(login);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(245, 245, 245));
		passwordField.setBounds(88, 160, 212, 34);
		contentPane.add(passwordField);
	
	 JButton forgotPassword = new JButton("Forgot Password?");
     forgotPassword.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Display a dialog to input email for password reset
             String email = JOptionPane.showInputDialog(null, "Enter your email for password reset:", "Forgot Password", JOptionPane.QUESTION_MESSAGE);
             if (email != null && !email.isEmpty()) {
                 // Implement logic to send password reset email
                 // You may call a method here to handle email sending
                 // Example: sendPasswordResetEmail(email);
                 // Replace sendPasswordResetEmail with your actual method to send emails
                 JOptionPane.showMessageDialog(null, "Password reset link sent to: " + email, "Password Reset", JOptionPane.INFORMATION_MESSAGE);
             } else {
                 JOptionPane.showMessageDialog(null, "Email field cannot be empty.", "Forgot Password", JOptionPane.ERROR_MESSAGE);
             }
         }
     });
     forgotPassword.setBounds(88, 270, 212, 30);
     contentPane.add(forgotPassword);
 }
	 

}
