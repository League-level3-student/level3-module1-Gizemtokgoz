package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Add Name");
	JButton button2 = new JButton("View Names");
	ArrayList<String> names = new ArrayList<String>();
	public static void main(String[] args) {
		_02_GuestBook gb = new _02_GuestBook();
		gb.setup();
		/*
		 * Create a GUI with two buttons. One button reads "Add Name" and the other
		 * button reads "View Names". When the add name button is clicked, display an
		 * input dialog that asks the user to enter a name. Add that name to an
		 * ArrayList. When the "View Names" button is clicked, display a message dialog
		 * that displays all the names added to the list. Format the list as follows:
		 * Guest #1: Bob Banders 
		 * Guest #2: Sandy Summers 
		 * Guest #3: Greg Ganders 
		 * Guest #4: Donny Doners
		 */

	}

	public void setup() {
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		frame.setVisible(true);
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		String name;

		if (button1 == buttonPressed) {
			name = JOptionPane.showInputDialog("Enter your name:");
			names.add(name);
		}

		if (button2 == buttonPressed) {
			String guests = "";
			for (int j = 0; j < names.size(); j++) {
				guests = "Guest # " + (j+1) + ": " + names.get(j) + "";
			}
			JOptionPane.showMessageDialog(null, guests);
		}
	}
}
