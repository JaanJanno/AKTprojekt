package ui.panes;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import main.ASMController;
import ui.App;
import ui.constants.DefaultValues;
import ui.panes.elements.IntegerField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SimpleModePanel extends JPanel {

	private static final long serialVersionUID = -7283001820944734768L;

	private final App master;
	private final ASMController asmController;

	private JFileChooser chooser;

	private JLabel lblNewLabel;
	private JTextField register1;
	private JTextField register2;
	private JTextField register3;
	private JTextField register4;
	private JTextField register5;
	private JTextField register6;
	private JTextField stackPointer;
	private JTextField programCounter;
	private JTextField memField;
	private JTextField freqField;

	/**
	 * Create the panel.
	 */
	public SimpleModePanel(final App master, ASMController asmController) {
		this.master = master;
		this.asmController = asmController;

		chooser = new JFileChooser();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 220, 0, 250, 250, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0,
				0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 6;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 0;
		add(separator, gbc_separator);

		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridheight = 2;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		add(createSidePanel(), gbc_panel_3);

		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.gridx = 3;
		gbc_panel_4.gridy = 1;
		add(createTopPanel(), gbc_panel_4);

		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.insets = new Insets(0, 0, 5, 5);
		gbc_separator_3.gridx = 2;
		gbc_separator_3.gridy = 2;
		add(separator_3, gbc_separator_3);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 4;
		gbc_scrollPane_1.gridy = 2;
		add(scrollPane_1, gbc_scrollPane_1);

	}

	public void updateRegisters() {
		List<Integer> reg = asmController.currentRegisterStatus();
		register1.setText(Integer.toString(reg.get(0)));
		register2.setText(Integer.toString(reg.get(1)));
		register3.setText(Integer.toString(reg.get(2)));
		register4.setText(Integer.toString(reg.get(3)));
		register5.setText(Integer.toString(reg.get(4)));
		register6.setText(Integer.toString(reg.get(5)));
	}

	public void updatePointers() {
		List<Integer> pointers = asmController.currentPointerStatus();
		stackPointer.setText(Integer.toString(pointers.get(0)));
		programCounter.setText(Integer.toString(pointers.get(1)));
	}

	public void reset() {
		register1.setText("");
		register2.setText("");
		register3.setText("");
		register4.setText("");
		register5.setText("");
		register6.setText("");

		stackPointer.setText("");
		programCounter.setText("");

		freqField.setText(Integer.toString(DefaultValues.FREQUENCY));
		memField.setText(Integer.toString(DefaultValues.MEMORY));
		lblNewLabel.setText("");
	}

	private void startStop() {

		int freq = freqField.getText().length() != 0 ? Integer
				.parseInt(freqField.getText()) : DefaultValues.FREQUENCY;
		int mem = memField.getText().length() != 0 ? Integer.parseInt(memField
				.getText()) : DefaultValues.MEMORY;
		asmController.start(freq, mem);
		memField.setText(Integer.toString(mem));
		freqField.setText(Integer.toString(freq));
	}

	private void loadAssembly() {
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			asmController.loadFile(chooser.getSelectedFile().getAbsolutePath());
			lblNewLabel.setText("File loaded");
		}

	}

	private JPanel createTopPanel() {
		JPanel panel_4 = new JPanel();
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				startStop();
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 0;
		panel_4.add(btnStart, gbc_btnStart);

		JButton btnLoadAssembly = new JButton("Load Assembly");
		btnLoadAssembly.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loadAssembly();
			}
		});
		GridBagConstraints gbc_btnLoadAssembly = new GridBagConstraints();
		gbc_btnLoadAssembly.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoadAssembly.gridx = 1;
		gbc_btnLoadAssembly.gridy = 0;
		panel_4.add(btnLoadAssembly, gbc_btnLoadAssembly);

		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.insets = new Insets(0, 0, 0, 5);
		gbc_separator_2.gridx = 0;
		gbc_separator_2.gridy = 1;
		panel_4.add(separator_2, gbc_separator_2);
		return panel_4;
	}

	private JPanel createSidePanel() {
		JPanel panel_3 = new JPanel();
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel_3.add(createRegisterPanel(), gbc_panel_1);

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 1;
		panel_3.add(separator_1, gbc_separator_1);

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		panel_3.add(createPointerPanel(), gbc_panel);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 3;
		panel_3.add(separator, gbc_separator);

		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		panel_3.add(createFrequencyPanel(), gbc_panel_2);

		return panel_3;
	}

	private JPanel createRegisterPanel() {
		JPanel panel_1 = new JPanel();
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
		panel_1.setLayout(gbl_panel_1);

		JLabel lblRegistors = new JLabel("Registers");
		GridBagConstraints gbc_lblRegistors = new GridBagConstraints();
		gbc_lblRegistors.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistors.gridx = 0;
		gbc_lblRegistors.gridy = 0;
		panel_1.add(lblRegistors, gbc_lblRegistors);

		JLabel lblRegister = new JLabel("Register 1");
		GridBagConstraints gbc_lblRegister = new GridBagConstraints();
		gbc_lblRegister.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister.gridx = 0;
		gbc_lblRegister.gridy = 1;
		panel_1.add(lblRegister, gbc_lblRegister);

		register1 = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel_1.add(register1, gbc_textField);
		register1.setEnabled(false);
		register1.setColumns(10);

		JLabel lblRegister_1 = new JLabel("Register 2");
		GridBagConstraints gbc_lblRegister_1 = new GridBagConstraints();
		gbc_lblRegister_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister_1.gridx = 0;
		gbc_lblRegister_1.gridy = 2;
		panel_1.add(lblRegister_1, gbc_lblRegister_1);

		register2 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel_1.add(register2, gbc_textField_1);
		register2.setEnabled(false);
		register2.setEditable(false);
		register2.setColumns(10);

		JLabel lblRegister_2 = new JLabel("Register 3");
		GridBagConstraints gbc_lblRegister_2 = new GridBagConstraints();
		gbc_lblRegister_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister_2.gridx = 0;
		gbc_lblRegister_2.gridy = 3;
		panel_1.add(lblRegister_2, gbc_lblRegister_2);

		register3 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		panel_1.add(register3, gbc_textField_2);
		register3.setEnabled(false);
		register3.setEditable(false);
		register3.setColumns(10);

		JLabel lblRegister_3 = new JLabel("Register 4");
		GridBagConstraints gbc_lblRegister_3 = new GridBagConstraints();
		gbc_lblRegister_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister_3.gridx = 0;
		gbc_lblRegister_3.gridy = 4;
		panel_1.add(lblRegister_3, gbc_lblRegister_3);

		register4 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 4;
		panel_1.add(register4, gbc_textField_3);
		register4.setEnabled(false);
		register4.setEditable(false);
		register4.setColumns(10);

		JLabel lblRegister_4 = new JLabel("Register 5");
		GridBagConstraints gbc_lblRegister_4 = new GridBagConstraints();
		gbc_lblRegister_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister_4.gridx = 0;
		gbc_lblRegister_4.gridy = 5;
		panel_1.add(lblRegister_4, gbc_lblRegister_4);

		register5 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 5;
		panel_1.add(register5, gbc_textField_4);
		register5.setEnabled(false);
		register5.setEditable(false);
		register5.setColumns(10);

		JLabel lblRegister_5 = new JLabel("Register 6");
		GridBagConstraints gbc_lblRegister_5 = new GridBagConstraints();
		gbc_lblRegister_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblRegister_5.gridx = 0;
		gbc_lblRegister_5.gridy = 6;
		panel_1.add(lblRegister_5, gbc_lblRegister_5);

		register6 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 6;
		panel_1.add(register6, gbc_textField_5);
		register6.setEnabled(false);
		register6.setEditable(false);
		register6.setColumns(10);

		return panel_1;
	}

	private JPanel createPointerPanel() {
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 125, 118, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel label_1 = new JLabel("Stack pointer");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);

		stackPointer = new JTextField();
		stackPointer.setEnabled(false);
		stackPointer.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 0;
		panel.add(stackPointer, gbc_textField_6);

		JLabel label_2 = new JLabel("Program counter");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel.add(label_2, gbc_label_2);

		programCounter = new JTextField();
		programCounter.setEnabled(false);
		programCounter.setEditable(false);
		programCounter.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 1;
		panel.add(programCounter, gbc_textField_7);
		return panel;
	}

	private JPanel createFrequencyPanel() {
		JPanel panel_2 = new JPanel();
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 125, 118, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel label_8 = new JLabel("Frequency");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 0;
		panel_2.add(label_8, gbc_label_8);

		freqField = new IntegerField();
		freqField.setText("1000");
		freqField.setColumns(10);
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.insets = new Insets(0, 0, 5, 0);
		gbc_textField_12.gridx = 1;
		gbc_textField_12.gridy = 0;
		panel_2.add(freqField, gbc_textField_12);

		JLabel label_9 = new JLabel("Memory size");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 1;
		panel_2.add(label_9, gbc_label_9);

		memField = new IntegerField();
		memField.setText("1000");
		memField.setColumns(10);
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.gridx = 1;
		gbc_textField_13.gridy = 1;
		panel_2.add(memField, gbc_textField_13);

		return panel_2;
	}

}
