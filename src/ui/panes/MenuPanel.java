package ui.panes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import ui.App;

import javax.swing.JSeparator;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = -7244016038731281136L;

	@SuppressWarnings("unused")
	private final App master;

	/**
	 * Create the panel.
	 */
	public MenuPanel(final App master) {
		this.master = master;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 434, 0 };
		gridBagLayout.rowHeights = new int[] { 16, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton btnSimpleMode = new JButton("CPU view");
		btnSimpleMode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				master.goToSimpleMode();
			}
		});
		GridBagConstraints gbc_btnSimpleMode = new GridBagConstraints();
		gbc_btnSimpleMode.insets = new Insets(0, 0, 5, 0);
		gbc_btnSimpleMode.gridx = 0;
		gbc_btnSimpleMode.gridy = 2;
		this.add(btnSimpleMode, gbc_btnSimpleMode);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 3;
		add(separator, gbc_separator);

		JButton btnAdvancedMode = new JButton("Instructions");
		btnAdvancedMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master.goToInstructions();
			}
		});
		GridBagConstraints gbc_btnAdvancedMode = new GridBagConstraints();
		gbc_btnAdvancedMode.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdvancedMode.gridx = 0;
		gbc_btnAdvancedMode.gridy = 4;
		this.add(btnAdvancedMode, gbc_btnAdvancedMode);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 5;
		add(separator_1, gbc_separator_1);
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.gridx = 0;
		gbc_btnExit.gridy = 6;
		this.add(btnExit, gbc_btnExit);
	}

}
