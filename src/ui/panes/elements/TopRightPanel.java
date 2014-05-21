package ui.panes.elements;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import ui.App;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TopRightPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnNextStep;
	private JLabel messageLabel;

	/**
	 * Create the panel.
	 */
	public TopRightPanel(final App master) {
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_panel_4);
		
		JButton btnNextStep = new JButton("Next step");
		btnNextStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				master.getSimpleModePanel().nextStep();
			}
		});
		GridBagConstraints gbc_btnNextStep = new GridBagConstraints();
		gbc_btnNextStep.insets = new Insets(0, 0, 5, 5);
		gbc_btnNextStep.gridx = 0;
		gbc_btnNextStep.gridy = 0;
		add(btnNextStep, gbc_btnNextStep);

		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.insets = new Insets(0, 0, 0, 5);
		gbc_separator_2.gridx = 1;
		gbc_separator_2.gridy = 0;
		add(separator_2, gbc_separator_2);

		messageLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		add(messageLabel, gbc_lblNewLabel);
	}

	public JButton getBtnNextStep() {
		return btnNextStep;
	}

	public JLabel getMessageLabel() {
		return messageLabel;
	}

	public void setMessageLabelText(String text) {
		messageLabel.setText(text);
	}

	public void reset() {
		messageLabel.setText("");
	}

}
