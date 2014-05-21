package ui.panes.elements;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.App;
import ui.constants.DefaultValues;
import main.ASMController;

public class FrequencyPanel extends JPanel {

	private static final long serialVersionUID = 4404740586210906991L;
	private JTextField memField;
	private JTextField freqField;

	public FrequencyPanel(App master, ASMController asm) {
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 125, 118, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_panel_2);

		JLabel label_8 = new JLabel("Frequency");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 0;
		add(label_8, gbc_label_8);

		freqField = new IntegerField();
		freqField.setText("1000");
		freqField.setColumns(10);
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.insets = new Insets(0, 0, 5, 0);
		gbc_textField_12.gridx = 1;
		gbc_textField_12.gridy = 0;
		add(freqField, gbc_textField_12);

		JLabel label_9 = new JLabel("Memory size");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 1;
		add(label_9, gbc_label_9);

		memField = new IntegerField();
		memField.setText("1000");
		memField.setColumns(10);
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.gridx = 1;
		gbc_textField_13.gridy = 1;
		add(memField, gbc_textField_13);
	}

	public void reset() {
		freqField.setText(Integer.toString(DefaultValues.FREQUENCY));
		memField.setText(Integer.toString(DefaultValues.MEMORY));
	}

	public JTextField getMemField() {
		return memField;
	}

	public void setMemField(JTextField memField) {
		this.memField = memField;
	}

	public void setMemFieldText(String text) {
		memField.setText(text);
	}

	public String getMemFieldText() {
		return memField.getText();
	}

	public JTextField getFreqField() {
		return freqField;
	}

	public void setFreqField(JTextField freqField) {
		this.freqField = freqField;
	}

	public void setFreqFieldText(String text) {
		freqField.setText(text);
	}

	public String getFreqFieldText() {
		return freqField.getText();
	}

}