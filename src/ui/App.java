package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
	private ASMController asmController;

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
				frmProjekt.setContentPane(getMenuPanel());
				frmProjekt.revalidate();
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
		mnNewMenu.add(mntmLoadAsmFile);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mnNewMenu.add(mntmExit);

		JMenu mnStuff = new JMenu("Actions");
		menuBar.add(mnStuff);

		JMenuItem mntmA = new JMenuItem("Reset everything");
		mntmA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asmController.reset();
				resetApp();
			}
		});
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
		mnHelp.add(mntmHelp);
	}

	public MenuPanel getMenuPanel() {
		if (menuPanel == null)
			menuPanel = new MenuPanel(this, asmController);
		return menuPanel;
	}

	public SimpleModePanel getSimpleModePanel() {
		if (simpleModePanel == null)
			simpleModePanel = new SimpleModePanel(this, asmController);
		return simpleModePanel;
	}
	
	public HelpPanel getHelpPanel() {
		if (helpPanel == null)
			helpPanel = new HelpPanel();
		return helpPanel;
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

}
