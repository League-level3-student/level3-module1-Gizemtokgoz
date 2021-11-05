package _05_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	HashMap<Integer, String> search;

	public static void main(String[] args) {
		new _02_LogSearch().run();
	}

	void run() {
		search = new HashMap<Integer, String>();
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		frame.setVisible(true);
		frame.pack();
		button1.setText("Add");
		button2.setText("Search");
		button3.setText("View");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	}
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonClicked = (JButton) e.getSource();
		String idnum = "";
		String name = "";
		if (buttonClicked == button1) {
			idnum = JOptionPane.showInputDialog("Enter an ID number: ");
			name = JOptionPane.showInputDialog("Enter your name: ");
		}
		int idNum = Integer.parseInt(idnum);
		search.put(idNum, name);

		if (buttonClicked == button2) {
			idnum = JOptionPane.showInputDialog("Enter an ID number: ");
			if (search.containsKey(idnum)) {
				JOptionPane.showMessageDialog(null, search.get(name));
			} else {
				JOptionPane.showMessageDialog(null, "This entry does not exist.");
			}
		}

		if (buttonClicked == button3) {
			String s = "";
			for(Integer i : search.keySet()) {
				s = "ID: " + i + " Name: " + search.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, s);
		}
	}

}
