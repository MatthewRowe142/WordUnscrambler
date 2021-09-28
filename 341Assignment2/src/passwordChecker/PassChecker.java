package passwordChecker;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PassChecker {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnCheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassChecker window = new PassChecker();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public String check(String pass) throws Exception{
		Checker checker = new Checker();
		int val = checker.check(pass);
		if (val<3) {
			return "The largest block is only "+val+"....pretty decent.";
		}else {
			return "The largest block is "+val+"....you should probably change it.";
		}
		
	}

	/**
	 * Create the application.
	 */
	public PassChecker() {
		initialize();
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField_1.setText(check(textField.getText()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(151, 39, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(40, 202, 331, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnCheck = new JButton("New button");
		btnCheck.setBounds(151, 119, 89, 23);
		frame.getContentPane().add(btnCheck);
	}

}
