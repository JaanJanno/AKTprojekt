package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import main.ASMController;
import ui.constants.DefaultValues;
import ui.panes.HelpPanel;
import ui.panes.MenuPanel;
import ui.panes.SimpleModePanel;

import javax.swing.JSeparator;

public class App {
	private JFrame frmProjekt;
	private MenuPanel menuPanel;
	private SimpleModePanel simpleModePanel;
	private HelpPanel helpPanel;
	private HelpPanel instructionPanel;
	private ASMController asmController;
	private JFileChooser chooser;

	/**
	 * Create the application.
	 */
	public App(ASMController a) {
		this.asmController = a;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();

		// When in doubt, add moar threads
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				getSimpleModePanel();
			}
		});
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				getHelpPanel();
			}
		});
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				getInstructionPanel();
			}
		});
		executorService.shutdown();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjekt = new JFrame();
		frmProjekt.setTitle("Projekt");
		frmProjekt.setBounds(150, 150, 768, 480);
		frmProjekt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjekt.setContentPane(getMenuPanel());

		JMenuBar menuBar = new JMenuBar();
		frmProjekt.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mntmBackToMenu = new JMenuItem("Back to menu");
		mntmBackToMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goToMenu();
			}
		});
		mnNewMenu.add(mntmBackToMenu);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

		JMenuItem mntmLoadAsmFile = new JMenuItem("Load ASM file");
		mntmLoadAsmFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadAssembly();
			}
		});
		mnNewMenu.add(mntmLoadAsmFile);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mnNewMenu.add(mntmExit);

		JMenu mnStuff = new JMenu("Actions");
		menuBar.add(mnStuff);

		JMenuItem mntmA = new JMenuItem("Reset everything");
		mntmA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mem = getSimpleModePanel().getFreqPanel().getMemFieldText()
						.length() != 0 ? Integer.parseInt(getSimpleModePanel()
						.getFreqPanel().getMemFieldText())
						: DefaultValues.MEMORY;

				asmController.reset(mem);
				resetApp();
			}
		});

		JMenuItem mntmCpuView = new JMenuItem("CPU view");
		mntmCpuView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToSimpleMode();
			}
		});
		mnStuff.add(mntmCpuView);

		JSeparator separator_1 = new JSeparator();
		mnStuff.add(separator_1);
		mnStuff.add(mntmA);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmProjekt.setContentPane(getHelpPanel());
				frmProjekt.revalidate();
			}
		});

		JMenuItem mntmInstructions = new JMenuItem("Instructions");
		mntmInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToInstructions();
			}
		});
		mnHelp.add(mntmInstructions);
		mnHelp.add(mntmHelp);

		chooser = new JFileChooser();
	}

	public MenuPanel getMenuPanel() {
		if (menuPanel == null)
			menuPanel = new MenuPanel(this);
		return menuPanel;
	}

	public SimpleModePanel getSimpleModePanel() {
		if (simpleModePanel == null)
			simpleModePanel = new SimpleModePanel(this, asmController);
		return simpleModePanel;
	}

	public HelpPanel getHelpPanel() {
		if (helpPanel == null)
			helpPanel = new HelpPanel("help.html");
		return helpPanel;
	}

	public HelpPanel getInstructionPanel() {
		if (instructionPanel == null)
			instructionPanel = new HelpPanel("instruction.html");
		return instructionPanel;
	}

	public JFrame getFrmProjekt() {
		return frmProjekt;
	}

	public void resetApp() {
		getSimpleModePanel().reset();
	}

	public void update() {
		getSimpleModePanel().updatePointers();
		getSimpleModePanel().updateRegisters();
		getSimpleModePanel().updateLists();

	}

	public void loadAssembly() {
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			int mem = getSimpleModePanel().getFreqPanel().getMemFieldText()
					.length() != 0 ? Integer.parseInt(getSimpleModePanel()
					.getFreqPanel().getMemFieldText()) : DefaultValues.MEMORY;
			int freq = getSimpleModePanel().getFreqPanel().getFreqFieldText()
					.length() != 0 ? Integer.parseInt(getSimpleModePanel()
					.getFreqPanel().getFreqFieldText())
					: DefaultValues.FREQUENCY;
			asmController.loadFile(chooser.getSelectedFile().getAbsolutePath(),
					mem, freq);
			getSimpleModePanel().assemblyLoaded();

		}

	}

	public void goToInstructions() {
		frmProjekt.setContentPane(getInstructionPanel());
		frmProjekt.revalidate();
	}

	public void goToSimpleMode() {
		frmProjekt.setContentPane(getSimpleModePanel());
		frmProjekt.revalidate();
	}

	public void goToHelp() {
		frmProjekt.setContentPane(getHelpPanel());
		frmProjekt.revalidate();
	}

	public void goToMenu() {
		frmProjekt.setContentPane(getMenuPanel());
		frmProjekt.revalidate();
	}

}
