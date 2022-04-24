/*README.txt

A calculator program using Eclipse/Spring/Swing/AWT

This is a calculator for simple calculations

I wanted my calculator to be different than others seen, so I added a KeyListener so my calculator can read keyboard input.
 
In the code you will notice that I comment on every major section to maintain clean and understandable code.

Implemented: array, switch, if, if-else, for, try-catch
  
Thank you for viewing! 
  
*/

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;


public class calcGUI implements ActionListener, KeyListener{

		private JFrame frame;
		private JTextField textField;
		JButton[] numButtons = new JButton[10];
		JButton[] funcButtons = new JButton[10];
		JButton addBttn, subBttn, multBttn, divBttn, percBttn, decBttn, enterBttn, delBttn, clearBttn, negBttn; 
		double num1 = 0, num2 = 0, result = 0;
		char operator;
		Color PowderBlue = new Color(194,239,235), HoneyDew = new Color(236,254,232), DarkSlateBlue = new Color(141,126,201), AirBlue = new Color(110,164,191);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calcGUI window = new calcGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});
	}
	
	public calcGUI() {
		initialize(); }
	
	private void initialize() {
		//initializing and settings for frame
			frame = new JFrame("Calculator");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(393,432);
			frame.setResizable(false);
			frame.getContentPane().setLayout(null);
			frame.addKeyListener(this);
		
		
		//initializing and settings for text field
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.TRAILING);
			textField.setBackground(HoneyDew);
			textField.setFont(new Font("Kohinoor Devanagari", Font.PLAIN, 29));
			textField.setBorder(BorderFactory.createRaisedBevelBorder());
			textField.setEditable(false);
			textField.addKeyListener(this);
			textField.setBounds(6, 0, 380, 79);
			textField.setColumns(15);
			frame.getContentPane().add(textField);
		
		//Configuring Number Buttons
				JButton bttn0 = new JButton("0"), bttn1 = new JButton("1"), bttn2 = new JButton("2"), bttn3 = new JButton("3"), bttn4 = new JButton("4");
				JButton bttn5 = new JButton("5"), bttn6 = new JButton("6"), bttn7 = new JButton("7"), bttn8 = new JButton("8"), bttn9 = new JButton("9");
			//adding number buttons to array
				numButtons[0] = bttn0;
				numButtons[1] = bttn1;
				numButtons[2] = bttn2;
				numButtons[3] = bttn3;
				numButtons[4] = bttn4;
				numButtons[5] = bttn5;
				numButtons[6] = bttn6;
				numButtons[7] = bttn7;
				numButtons[8] = bttn8;
				numButtons[9] = bttn9;
			
			//0 Button bounds and adding to frame
				bttn0.setBounds(101, 336, 95, 65);
						
			//1 Button bounds and adding to frame
				bttn1.setBounds(6, 141, 95, 65);
				
			//2 Button bounds and adding to frame
				bttn2.setBounds(101, 141, 95, 65);
				
			//3 Button bounds and adding to frame
				bttn3.setBounds(196, 141, 95, 65);
				
			//4 Button bounds and adding to frame
				bttn4.setBounds(6, 206, 95, 65);
				
			//5 Button bounds and adding to frame
				bttn5.setBounds(101, 206, 95, 65);
				
			//6 Button bounds and adding to frame
				bttn6.setBounds(196, 206, 95, 65);
				
			//7 Button bounds and adding to frame
				bttn7.setBounds(6, 271, 95, 65);
				
			//8 Button bounds and adding to frame
				bttn8.setBounds(101, 271, 95, 65);
				
			//9 Button bounds and adding to frame
				bttn9.setBounds(196, 271, 95, 65);
				
			//adding duplicate features to number buttons
				for(int i = 0; i < 10; i ++) {
					numButtons[i].setOpaque(true);
					numButtons[i].setFont(new Font("Ayuthaya", Font.PLAIN, 20));
					numButtons[i].setBorder(BorderFactory.createRaisedBevelBorder());
					numButtons[i].setBackground(PowderBlue);
					numButtons[i].setFocusable(false);
					numButtons[i].addActionListener(this);
					numButtons[i].addKeyListener(this);
					frame.getContentPane().add(numButtons[i]);
				}
		
		//Configuring function buttons
				negBttn = new JButton("(+/-)"); clearBttn = new JButton("Clear"); delBttn = new JButton("Delete"); multBttn = new JButton("*"); divBttn = new JButton("÷");
				subBttn = new JButton("-"); addBttn = new JButton("+"); decBttn = new JButton("."); enterBttn = new JButton("Enter"); percBttn = new JButton("%");
			//adding function buttons to array
				funcButtons[0] = negBttn;
				funcButtons[1] = clearBttn;
				funcButtons[2] = delBttn;
				funcButtons[3] = multBttn;
				funcButtons[4] = divBttn;
				funcButtons[5] = subBttn;
				funcButtons[6] = addBttn;
				funcButtons[7] = decBttn;
				funcButtons[8] = enterBttn;
				funcButtons[9] = percBttn;
			
			//Negative Button bounds and adding to frame
				negBttn.setBounds(6, 76, 95, 65);
				negBttn.setBackground(AirBlue);	
			
			//Clear Button bounds and adding to frame
				clearBttn.setBounds(101, 76, 95, 65);
				clearBttn.setBackground(AirBlue);
			
			//Delete Button bounds and adding to frame
				delBttn.setBounds(196, 76, 95, 65);
				delBttn.setBackground(AirBlue);
			
			//Multiplication Button bounds and adding to frame
				multBttn.setBounds(291, 141, 95, 65);
				multBttn.setBackground(DarkSlateBlue);			
			
			//Division Button bounds and adding to frame
				divBttn.setBounds(291, 76, 95, 65);
				divBttn.setBackground(DarkSlateBlue);	
			
			//Subtraction Button bounds and adding to frame
				subBttn.setBounds(291, 206, 95, 65);
				subBttn.setBackground(DarkSlateBlue);	
			
			//Addition Button bounds and adding to frame
				addBttn.setBounds(291, 271, 95, 65);
				addBttn.setBackground(DarkSlateBlue);	
			
			//Decimal Button bounds and adding to frame
				decBttn.setBounds(6, 336, 95, 65);
				decBttn.setBackground(PowderBlue);
			
			//Enter Button bounds and adding to frame
				enterBttn.setBounds(291, 336, 95, 65);
				enterBttn.setBackground(DarkSlateBlue);
			
			//Percentage button bounds and adding to frame
				percBttn.setBounds(196, 336, 95, 65);
				percBttn.setBackground(PowderBlue);
			
			//adding duplicate features to function buttons
				for(int i = 0; i < 10; i++) {
					funcButtons[i].setOpaque(true);
					funcButtons[i].setFont(new Font("Ayuthaya", Font.PLAIN, 20));
					funcButtons[i].setBorder(BorderFactory.createRaisedBevelBorder());
					funcButtons[i].setFocusable(false);
					funcButtons[i].addActionListener(this);
					funcButtons[i].addKeyListener(this);
					frame.getContentPane().add(funcButtons[i]);
				}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//add numbers clicked to text field
				for(int i = 0; i < 10; i ++) {
					if(e.getSource() == numButtons[i]) {
						textField.setText(textField.getText().concat(String.valueOf(i)));
					}
				}
				
				//adding decimal to text field
				if(e.getSource() == decBttn) {
					if(textField.getText().isEmpty()) {
					} else {
						textField.setText(textField.getText().concat("."));
					}
				}
				//adding addition to text field
				if(e.getSource() == addBttn) {
					if(textField.getText().isEmpty()) {
					} else {
						num1 = Double.parseDouble(textField.getText());
						operator = '+';
						textField.setText("");
					}
				}
				//adding subtraction to text field
				if(e.getSource() == subBttn) {
					if(textField.getText().isEmpty()) {
					} else {
						num1 = Double.parseDouble(textField.getText());
						operator = '-';
						textField.setText("");
					}
				}
				//adding multiplication to text field
				if(e.getSource() == multBttn) {
					if(textField.getText().isEmpty()) {
					} else {
						num1 = Double.parseDouble(textField.getText());
						operator = 'x';
						textField.setText("");
					}
				}
				//adding division to text field
				if(e.getSource() == divBttn) {
					if(textField.getText().isEmpty()) {
					} else {
					num1 = Double.parseDouble(textField.getText());
					operator = '/';
					textField.setText("");
					}
				}
				
				//adding and calculation percentage to text field
				if(e.getSource() == percBttn) {
					if(textField.getText().isEmpty()) {
					} else {
					num1 = Double.parseDouble(textField.getText());
					operator = '%';
					textField.setText(String.valueOf(num1/100));
					}
				}
				//operations when enter button is clicked
				if(e.getSource() == enterBttn) {
					if(textField.getText().isEmpty()) {
					} else if (operator == '\0'){
						textField.setText(textField.getText());
					}else {
						num2 = Double.parseDouble(textField.getText());
						switch(operator) {
						case '+': //addition
							result = num1 + num2;
							break;
						case '-': //subtraction
							result = num1 - num2;
							break;
							
						case 'x': //multiply
							result = num1 * num2;
							break;
							
						case '/': //divide
							result = num1 / num2;
							break;
					}
					textField.setText(String.valueOf(result));
					num1=result;
					}
				}
				
				//adding function to clear button
				if(e.getSource() == clearBttn) {
					if(textField.getText().isEmpty()) {
					} else {
					textField.setText("");
					}
				}
				
				//adding function to delete button
				if(e.getSource() == delBttn) {
					if(textField.getText().isEmpty()) {
					} else {
					String string = textField.getText();
					textField.setText("");
					for(int i = 0; i < string.length()-1; i++) {
						textField.setText(textField.getText()+string.charAt(i));
					}
					}
				}
				
				//adding function to negative/positive button
				if(e.getSource() == negBttn) {
					if(textField.getText().isEmpty()) {
					} else {
					Double temp = Double.parseDouble(textField.getText());
					temp= temp * -1;
					textField.setText(String.valueOf(temp));
					}
				}	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//add numbers clicked to text field
				if((e.getKeyCode() == KeyEvent.VK_0) || (e.getKeyCode() == KeyEvent.VK_NUMPAD0)){
					textField.setText(textField.getText().concat(String.valueOf(0)));
				} else if((e.getKeyCode() == KeyEvent.VK_1) || (e.getKeyCode() == KeyEvent.VK_NUMPAD1)) {
					textField.setText(textField.getText().concat(String.valueOf(1)));
				}else if ((e.getKeyCode() == KeyEvent.VK_2) || (e.getKeyCode() == KeyEvent.VK_NUMPAD2)) {
					textField.setText(textField.getText().concat(String.valueOf(2)));
				}else if ((e.getKeyCode() == KeyEvent.VK_3) || (e.getKeyCode() == KeyEvent.VK_NUMPAD3)) {
					textField.setText(textField.getText().concat(String.valueOf(3)));
				}else if ((e.getKeyCode() == KeyEvent.VK_4) || (e.getKeyCode() == KeyEvent.VK_NUMPAD4)) {
					textField.setText(textField.getText().concat(String.valueOf(4)));
				}else if ((e.getKeyCode() == KeyEvent.VK_5) || (e.getKeyCode() == KeyEvent.VK_NUMPAD5)) {
					textField.setText(textField.getText().concat(String.valueOf(5)));
				}else if ((e.getKeyCode() == KeyEvent.VK_6) || (e.getKeyCode() == KeyEvent.VK_NUMPAD6)) {
					textField.setText(textField.getText().concat(String.valueOf(6)));
				}else if ((e.getKeyCode() == KeyEvent.VK_7) || (e.getKeyCode() == KeyEvent.VK_NUMPAD7)) {
					textField.setText(textField.getText().concat(String.valueOf(7)));
				}else if ((e.getKeyCode() == KeyEvent.VK_8) || (e.getKeyCode() == KeyEvent.VK_NUMPAD8)) {
					textField.setText(textField.getText().concat(String.valueOf(8)));
				}else if ((e.getKeyCode() == KeyEvent.VK_9) || (e.getKeyCode() == KeyEvent.VK_NUMPAD9)) {
					textField.setText(textField.getText().concat(String.valueOf(9)));
				}
				//add decimal to text field
				if((e.getKeyCode() == KeyEvent.VK_DECIMAL) || (e.getKeyCode() == KeyEvent.VK_PERIOD)){
					textField.setText(textField.getText().concat("."));
				}
				//adding addition to text field
				if((e.getKeyCode() == KeyEvent.VK_PLUS) || (e.getKeyCode() == KeyEvent.VK_ADD)){
					num1 = Double.parseDouble(textField.getText());
					operator = '+';
					textField.setText("");
				}
				//adding subtraction to text field
				if(e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
					num1 = Double.parseDouble(textField.getText());
					operator = '-';
					textField.setText("");
				}
				//adding multiplication to text field
				if(e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
					num1 = Double.parseDouble(textField.getText());
					operator = 'x';
					textField.setText("");
				}
				//adding division to text field
				if((e.getKeyCode() == KeyEvent.VK_DIVIDE) || (e.getKeyCode() == KeyEvent.VK_SLASH)){
					num1 = Double.parseDouble(textField.getText());
					operator = '/';
					textField.setText("");
				}
				//operations when enter button is clicked
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					num2 = Double.parseDouble(textField.getText());
					switch(operator) {
					case '+': //addition
						result = num1 + num2;
						break;
					case '-': //subtraction
						result = num1 - num2;
						break;
						
					case 'x': //multiply
						result = num1 * num2;
						break;
						
					case '/': //divide
						result = num1 / num2;
						break;
					}
					textField.setText(String.valueOf(result));
					num1=result;
				}
				//adding function to delete button
				if((e.getKeyCode() == KeyEvent.VK_BACK_SPACE) || (e.getKeyCode() == KeyEvent.VK_DELETE)){
					String string = textField.getText();
					textField.setText("");
					for(int i = 0; i < string.length()-1; i++) {
						textField.setText(textField.getText()+string.charAt(i));
					}
				}
				
				//adding function to negative/positive button
				if(e.getSource() == negBttn) {
					Double temp = Double.parseDouble(textField.getText());
					temp*=-1;
					textField.setText(String.valueOf(temp));
				}
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
}