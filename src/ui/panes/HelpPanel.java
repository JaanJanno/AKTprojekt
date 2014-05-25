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
	public HelpPanel(String path) {
		// Load help
		String text = "nothing here. could not find " + path;
		try {
			if (path=="about.html") {
				text = aboutHelper(path);
			}
			else 
				text = TextReader.helpTextLoader(path);
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
	
	private String aboutHelper(String path) throws IOException {
		String text = TextReader.helpTextLoader(path);
		String filename=this.getClass().getClassLoader().getResource("logo.png").toString();
		String imageTag="<img src=\""+filename+"\"/>";
		text += imageTag;
//		text += "        </div></body></html>";
		return text;
	}

}
