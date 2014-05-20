package main;

import java.awt.EventQueue;

import ui.App;

public class Intro {
	static App window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final ASMController asmController = new ASMControllerImpl();
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				window = new App(asmController);
				window.getFrmProjekt().setVisible(true);
				
			}
		});


	}
}
