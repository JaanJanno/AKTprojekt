package ui.panes.elements;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JScrollPane;

import java.awt.Insets;
import java.util.List;

import javax.swing.JSeparator;

import main.ASMController;

public class LeftScrollPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> asmListModel;
	private DefaultListModel<String> processedListModel;
	private ASMController asmController;

	/**
	 * Create the panel.
	 */
	public LeftScrollPanel(ASMController asmController) {
		this.asmController = asmController;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblPureAsm = new JLabel("Pure ASM");
		GridBagConstraints gbc_lblPureAsm = new GridBagConstraints();
		gbc_lblPureAsm.anchor = GridBagConstraints.WEST;
		gbc_lblPureAsm.insets = new Insets(0, 0, 5, 0);
		gbc_lblPureAsm.gridx = 0;
		gbc_lblPureAsm.gridy = 0;
		add(lblPureAsm, gbc_lblPureAsm);

		asmListModel = new DefaultListModel<>();
		JScrollPane scrollPane = new JScrollPane(createScrollList(asmListModel));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		add(separator, gbc_separator);

		JLabel lblProcessedCommands = new JLabel("Processed commands");
		GridBagConstraints gbc_lblProcessedCommands = new GridBagConstraints();
		gbc_lblProcessedCommands.anchor = GridBagConstraints.WEST;
		gbc_lblProcessedCommands.insets = new Insets(0, 0, 5, 0);
		gbc_lblProcessedCommands.gridx = 0;
		gbc_lblProcessedCommands.gridy = 3;
		add(lblProcessedCommands, gbc_lblProcessedCommands);

		processedListModel = new DefaultListModel<>();
		JScrollPane scrollPane_1 = new JScrollPane(
				createScrollList(processedListModel));
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 4;
		add(scrollPane_1, gbc_scrollPane_1);

	}

	public void reset() {
		asmListModel.clear();
		processedListModel.clear();
	}

	public void updateLists() {
		reset();
		List<String> asmList = asmController.getAsm();
		for (int i = 0; i < asmList.size(); i++) {
			asmListModel.addElement(asmList.get(i));
		}
		List<String> commandList = asmController.getProcessedCommands();
		for (int i = 0; i < commandList.size(); i++) {
			processedListModel.addElement(commandList.get(i));
		}
	}

	private JList<String> createScrollList(DefaultListModel<String> model) {
		JList<String> list = new JList<String>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		return list;
	}

}
