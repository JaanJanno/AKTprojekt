package ui.panes.elements;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import ui.App;

public class TopPanel extends JPanel {

	private static final long serialVersionUID = -1380137801426399721L;
	private JButton btnStart;
	private final App master;

	public TopPanel(final App master) {
		this.master = master;
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_panel_4);

		btnStart = new JButton("Start");
		btnStart.setEnabled(false);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				master.getSimpleModePanel().startStop();

			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 0;
		add(btnStart, gbc_btnStart);

		JButton btnLoadAssembly = new JButton("Load Assembly");
		btnLoadAssembly.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				master.getSimpleModePanel().loadAssembly();

			}
		});
		GridBagConstraints gbc_btnLoadAssembly = new GridBagConstraints();
		gbc_btnLoadAssembly.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoadAssembly.gridx = 1;
		gbc_btnLoadAssembly.gridy = 0;
		add(btnLoadAssembly, gbc_btnLoadAssembly);

		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.insets = new Insets(0, 0, 0, 5);
		gbc_separator_2.gridx = 0;
		gbc_separator_2.gridy = 1;
		add(separator_2, gbc_separator_2);
	}

	public JButton getBtnStart() {
		return btnStart;
	}

}
