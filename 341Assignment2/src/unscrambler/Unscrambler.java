package unscrambler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Unscrambler {

	private JFrame frame;
	private JTextField textField;
	private JButton btnSolve;
	private JTextArea textArea;
	private static ArrayList<String> tests;
	private static ArrayList<String> comTests;
	private static ArrayList<String> wordTests;
	private String test;

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Unscrambler window = new Unscrambler();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	public String solve(String word) throws FileNotFoundException, IOException {
		Checker checker = new Checker();
		tests = new ArrayList<String>();
		for(int i = 1;i<word.length();i++) {
			//System.out.println(i);
			combination(word.toCharArray(),word.length(),i);
		}
		tests.add(word);
		//System.out.println("comTests:"+tests);
		comTests = tests;

		wordTests = new ArrayList<String>();
		tests = new ArrayList<String>();
		for(int i =  0;i<comTests.size();i++) {
			//System.out.println(comTests.get(i)+" "+distinctPermutn(comTests.get(i),""));
			distinctPermutn(comTests.get(i),"");			
		}
		//System.out.println(tests);
		wordTests = tests;
		tests = new ArrayList<String>();
		for (int i = 0;i<wordTests.size();i++) {
			test = wordTests.get(i);
			if(checker.check(test)){
				tests.add(test);
			}
		}
		String ans = "";
		for(String s : tests) {
			ans += s+" ";
		}
		return (ans);



	}




	static ArrayList<String> distinctPermutn(String str, String ans){
		if (str.length() == 0) {
			tests.add(ans);
			return tests;
		}
		boolean alpha[] = new boolean[26];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + 
					str.substring(i + 1);

			if (alpha[ch - 'a'] == false)
				distinctPermutn(ros, ans + ch);
			alpha[ch - 'a'] = true;
		}
		return tests;
	}

	static ArrayList<String> combinationUtil(char arr[], char data[], int start,
			int end, int index, int r)
	{
		if (index == r){	
			String test = "";
			for (int j=0; j<r; j++) {
				test+=(data[j]);
				//System.out.println("test case: "+test);
			}
			//System.out.println("Added");
			tests.add(test);
			//System.out.println("Returning tests: "+tests);
			return tests;
		}

		for (int i=start; i<=end && end-i+1 >= r-index; i++){
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r);
		}
		return tests;
	}

	static ArrayList<String> combination(char arr[], int n, int r)
	{
		char data[]=new char[r];
		return combinationUtil(arr, data, 0, n-1, 0, r);
	}














/**
 * Create the application.
 */
public Unscrambler() {
	initialize();
	btnSolve.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				textArea.setText(solve(textField.getText()));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
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
	textField.setBounds(154, 40, 86, 20);
	frame.getContentPane().add(textField);
	textField.setColumns(10);

	btnSolve = new JButton("New button");
	btnSolve.setBounds(151, 106, 89, 23);
	frame.getContentPane().add(btnSolve);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(46, 140, 339, 121);
	frame.getContentPane().add(scrollPane);
	
	 textArea = new JTextArea();
	scrollPane.setViewportView(textArea);
}
}
