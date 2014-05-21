package ui.panes.elements;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterPanel extends JPanel {

	private static final long serialVersionUID = -2929134699941165297L;
	private JTextField register1;
	private JTextField register2;
	private JTextField register3;
	private JTextField register4;
	private JTextField register5;
	private JTextField register6;

	public RegisterPanel() {
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;

		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 125, 118, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		setLayout(gbl_panel_1);

		JLabel lblRegistors = new JLabel("Registers");
		GridBagConstraints gbc_lblRegistors = new GridBagConstraints();
		gbc_lblRegistors.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistors.gridx = 0;
		gbc_lblRegistors.gridy = 0;
		add(lblRegistors, gbc_lblRegistors);

		JLabel lblRegister = new JLabel("Register 1");
		GridBagConstraints gbc_lblRegister = new GridBagConstraints();
		gbc_lblRegister.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister.gridx = 0;
		gbc_lblRegister.gridy = 1;
		add(lblRegister, gbc_lblRegister);

		register1 = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(register1, gbc_textField);
		register1.setEnabled(false);
		register1.setColumns(10);

		JLabel lblRegister_1 = new JLabel("Register 2");
		GridBagConstraints gbc_lblRegister_1 = new GridBagConstraints();
		gbc_lblRegister_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister_1.gridx = 0;
		gbc_lblRegister_1.gridy = 2;
		add(lblRegister_1, gbc_lblRegister_1);

		register2 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		add(register2, gbc_textField_1);
		register2.setEnabled(false);
		register2.setEditable(false);
		register2.setColumns(10);

		JLabel lblRegister_2 = new JLabel("Register 3");
		GridBagConstraints gbc_lblRegister_2 = new GridBagConstraints();
		gbc_lblRegister_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister_2.gridx = 0;
		gbc_lblRegister_2.gridy = 3;
		add(lblRegister_2, gbc_lblRegister_2);

		register3 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		add(register3, gbc_textField_2);
		register3.setEnabled(false);
		register3.setEditable(false);
		register3.setColumns(10);

		JLabel lblRegister_3 = new JLabel("Register 4");
		GridBagConstraints gbc_lblRegister_3 = new GridBagConstraints();
		gbc_lblRegister_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister_3.gridx = 0;
		gbc_lblRegister_3.gridy = 4;
		add(lblRegister_3, gbc_lblRegister_3);

		register4 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 4;
		add(register4, gbc_textField_3);
		register4.setEnabled(false);
		register4.setEditable(false);
		register4.setColumns(10);

		JLabel lblRegister_4 = new JLabel("Register 5");
		GridBagConstraints gbc_lblRegister_4 = new GridBagConstraints();
		gbc_lblRegister_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister_4.gridx = 0;
		gbc_lblRegister_4.gridy = 5;
		add(lblRegister_4, gbc_lblRegister_4);

		register5 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 5;
		add(register5, gbc_textField_4);
		register5.setEnabled(false);
		register5.setEditable(false);
		register5.setColumns(10);

		JLabel lblRegister_5 = new JLabel("Register 6");
		GridBagConstraints gbc_lblRegister_5 = new GridBagConstraints();
		gbc_lblRegister_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblRegister_5.gridx = 0;
		gbc_lblRegister_5.gridy = 6;
		add(lblRegister_5, gbc_lblRegister_5);

		register6 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 6;
		add(register6, gbc_textField_5);
		register6.setEnabled(false);
		register6.setEditable(false);
		register6.setColumns(10);
	}

	public void reset() {
		register1.setText("");
		register2.setText("");
		register3.setText("");
		register4.setText("");
		register5.setText("");
		register6.setText("");
	}

	public void updateRegisters(List<Integer> reg) {
		register1.setText(Integer.toString(reg.get(0)));
		register2.setText(Integer.toString(reg.get(1)));
		register3.setText(Integer.toString(reg.get(2)));
		register4.setText(Integer.toString(reg.get(3)));
		register5.setText(Integer.toString(reg.get(4)));
		register6.setText(Integer.toString(reg.get(5)));
	}
}
