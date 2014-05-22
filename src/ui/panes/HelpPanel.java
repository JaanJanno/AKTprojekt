package ui.panes;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

import ui.util.TextReader;

public class HelpPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public HelpPanel() {
		// Load help
		String text = "nothing here. could not find help.html";
		try {
			text = TextReader.helpTextLoader("help.html");
		} catch (IOException e) {
		}

		setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		JTextPane txtpnlesannelesanne = new JTextPane();
		txtpnlesannelesanne.setEditable(false);
		txtpnlesannelesanne.setContentType("text/html");
		txtpnlesannelesanne.setText(text);
		scrollPane.setViewportView(txtpnlesannelesanne);

	}

}
