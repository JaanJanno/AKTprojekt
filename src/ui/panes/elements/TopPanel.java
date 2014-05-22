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
	private JButton btnRunToEnd;
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
				master.getSimpleModePanel().start();

			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 0;
		add(btnStart, gbc_btnStart);

		btnRunToEnd = new JButton("Run to end");
		btnRunToEnd.setEnabled(false);
		btnRunToEnd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				master.getSimpleModePanel().runToEnd();

			}
		});
		GridBagConstraints gbc_btnRunToEnd = new GridBagConstraints();
		gbc_btnRunToEnd.insets = new Insets(0, 0, 5, 0);
		gbc_btnRunToEnd.gridx = 1;
		gbc_btnRunToEnd.gridy = 0;
		add(btnRunToEnd, gbc_btnRunToEnd);

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

	public JButton getBtnRunToEnd() {
		return btnRunToEnd;
	}

}
