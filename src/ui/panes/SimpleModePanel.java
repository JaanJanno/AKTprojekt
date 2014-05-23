package ui.panes;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import main.ASMController;
import ui.App;
import ui.panes.elements.FrequencyPanel;
import ui.panes.elements.LeftScrollPanel;
import ui.panes.elements.PointerPanel;
import ui.panes.elements.RegisterPanel;
import ui.panes.elements.TopPanel;
import ui.panes.elements.TopRightPanel;

public class SimpleModePanel extends JPanel {

	private static final long serialVersionUID = -7283001820944734768L;

	private final App master;
	private final ASMController asmController;

	private FrequencyPanel freqPanel;
	private RegisterPanel regPanel;
	private PointerPanel pointerPanel;
	private TopPanel topPanel;
	private TopRightPanel rightPanel;
	private LeftScrollPanel leftScrollPanel;

	private DefaultListModel<String> memoryListModel;

	/**
	 * Create the panel.
	 */
	public SimpleModePanel(final App master, ASMController asmController) {
		this.master = master;
		this.asmController = asmController;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 220, 0, 250, 0, 250, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0,
				1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 7;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 0;
		add(separator, gbc_separator);

		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridheight = 3;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		add(createSidePanel(), gbc_panel_3);

		topPanel = new TopPanel(master);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.gridx = 3;
		gbc_panel_4.gridy = 1;
		add(topPanel, gbc_panel_4);

		rightPanel = new TopRightPanel(master);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.gridx = 5;
		gbc_panel_5.gridy = 1;
		add(rightPanel, gbc_panel_5);

		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.insets = new Insets(0, 0, 5, 5);
		gbc_separator_3.gridx = 2;
		gbc_separator_3.gridy = 2;
		add(separator_3, gbc_separator_3);

		leftScrollPanel = new LeftScrollPanel(asmController);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 2;
		add(leftScrollPanel, gbc_scrollPane);

		memoryListModel = new DefaultListModel<>();

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 4;
		gbc_separator_1.gridy = 2;
		add(separator_1, gbc_separator_1);
		JScrollPane scrollPane_1 = new JScrollPane(
				createScrollList(memoryListModel));
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 5;
		gbc_scrollPane_1.gridy = 2;
		add(scrollPane_1, gbc_scrollPane_1);

	}

	public void updateRegisters() {
		regPanel.updateRegisters(asmController.currentRegisterStatus());
	}

	public void updatePointers() {
		pointerPanel.updatePointers(asmController.currentPointerStatus());

	}

	public void reset() {
		regPanel.reset();
		pointerPanel.reset();
		freqPanel.reset();
		rightPanel.reset();
		leftScrollPanel.reset();

		memoryListModel.clear();

		topPanel.getBtnStart().setEnabled(false);
		topPanel.getBtnRunToEnd().setEnabled(false);
	}

	public void start() {
		asmController.start();

		topPanel.getBtnStart().setEnabled(false);
		topPanel.getBtnRunToEnd().setEnabled(true);
		rightPanel.getBtnNextStep().setEnabled(true);
	}

	public void runToEnd() {
		asmController.runToEnd();
		topPanel.getBtnStart().setEnabled(false);
		rightPanel.getBtnNextStep().setEnabled(false);
		topPanel.getBtnRunToEnd().setEnabled(false);
	}

	public void assemblyLoaded() {
		topPanel.getBtnStart().setEnabled(true);
		freqPanel.getMemField().setEnabled(false);
		freqPanel.getFreqField().setEnabled(false);

		freqPanel.setMemFieldText(Integer.toString(freqPanel
				.getMemFieldInteger()));
		freqPanel.setFreqFieldText(Integer.toString(freqPanel
				.getFreqFieldInteger()));
		topPanel.getBtnRunToEnd().setEnabled(false);
		rightPanel.getBtnNextStep().setEnabled(false);		
		

	}

	public void nextStep() {
		asmController.nextStep();

	}

	public void updateLists() {
		leftScrollPanel.updateLists();

		memoryListModel.clear();
		List<String> memList = asmController.getCpuMemory();
		for (int i = 0; i < memList.size(); i++) {
			memoryListModel.addElement(memList.get(i));
		}
	}
	
	public void setMessage(String string) {
		rightPanel.setMessageLabelText(string);		
	}

	private JList<String> createScrollList(DefaultListModel<String> model) {
		JList<String> list = new JList<String>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		return list;
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

		regPanel = new RegisterPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel_3.add(regPanel, gbc_panel_1);

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 1;
		panel_3.add(separator_1, gbc_separator_1);

		pointerPanel = new PointerPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		panel_3.add(pointerPanel, gbc_panel);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 3;
		panel_3.add(separator, gbc_separator);

		freqPanel = new FrequencyPanel(master, asmController);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		panel_3.add(freqPanel, gbc_panel_2);

		return panel_3;
	}

	public FrequencyPanel getFreqPanel() {
		return freqPanel;
	}

}
