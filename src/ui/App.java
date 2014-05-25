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
	private HelpPanel aboutPanel;
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
		ExecutorService executorService = Executors.newFixedThreadPool(3);
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
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				getHelpPanel();
			}
		});
		executorService.shutdown();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjekt = new JFrame();
		frmProjekt.setTitle("SimplASM simulator");
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
		
		JMenuItem mntmLoadTestFile = new JMenuItem("Load test file");
		mntmLoadTestFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTest();
			}
		});
		mnNewMenu.add(mntmLoadTestFile);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mnNewMenu.add(mntmExit);

		JMenu mnStuff = new JMenu("Actions");
		menuBar.add(mnStuff);

		JMenuItem mntmA = new JMenuItem("Reset everything");
		mntmA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mem = getSimpleModePanel().getFreqPanel().getMemFieldInteger();
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
				goToHelp();
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
		
		JSeparator separator_2 = new JSeparator();
		mnHelp.add(separator_2);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToAbout();
			}
		});
		mnHelp.add(mntmAbout);

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

	private HelpPanel getHelpPanel() {
		if (helpPanel == null)
			helpPanel = new HelpPanel("help.html");
		return helpPanel;
	}

	private HelpPanel getInstructionPanel() {
		if (instructionPanel == null)
			instructionPanel = new HelpPanel("instruction.html");
		return instructionPanel;
	}
	
	private HelpPanel getAboutPanel() {
		if (aboutPanel == null)
			aboutPanel = new HelpPanel("about.html");
		return aboutPanel;
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
	
	public void setMessage(String message) {
		getSimpleModePanel().setMessage(message);
	}

	public void loadAssembly() {
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			int mem = getSimpleModePanel().getFreqPanel().getMemFieldInteger();
			int freq = getSimpleModePanel().getFreqPanel().getFreqFieldInteger();
			asmController.loadFile(chooser.getSelectedFile().getAbsolutePath(),
					mem, freq);
			getSimpleModePanel().assemblyLoaded();

		}

	}
	
	private void loadTest() {
		int mem = getSimpleModePanel().getFreqPanel().getMemFieldInteger();
		int freq = getSimpleModePanel().getFreqPanel().getFreqFieldInteger();
		asmController.loadFile("/test.asm",
				mem, freq);
		getSimpleModePanel().assemblyLoaded();		
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
	
	public void goToAbout() {
		frmProjekt.setContentPane(getAboutPanel());
		frmProjekt.revalidate();		
	}

}
