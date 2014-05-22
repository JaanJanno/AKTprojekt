package ui.panes.elements;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;

public class PointerPanel extends JPanel {

	private static final long serialVersionUID = 8509953212339222114L;
	private JTextField stackPointer;
	private JTextField programCounter;

	public PointerPanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 125, 118, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_panel);

		JLabel label_1 = new JLabel("Stack pointer");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		add(label_1, gbc_label_1);

		stackPointer = new JTextField();
		stackPointer.setMinimumSize(new Dimension(50, 20));
		stackPointer.setEnabled(false);
		stackPointer.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 0;
		add(stackPointer, gbc_textField_6);

		JLabel label_2 = new JLabel("Program counter");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		add(label_2, gbc_label_2);

		programCounter = new JTextField();
		programCounter.setMinimumSize(new Dimension(50, 20));
		programCounter.setEnabled(false);
		programCounter.setEditable(false);
		programCounter.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 1;
		add(programCounter, gbc_textField_7);
	}

	public void reset() {
		stackPointer.setText("");
		programCounter.setText("");
	}

	public void updatePointers(List<Integer> pointers) {
		stackPointer.setText(Integer.toString(pointers.get(0)));
		programCounter.setText(Integer.toString(pointers.get(1)));
	}

}
