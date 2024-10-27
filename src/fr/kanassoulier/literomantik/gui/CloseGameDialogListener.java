package fr.kanassoulier.literomantik.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import fr.kanassoulier.literomantik.game.Game;

public class CloseGameDialogListener implements WindowListener {
	private Game game;

	public CloseGameDialogListener(Game game) {
		this.game = game;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		new CloseGameDialog(this.game).setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent e) {
	} // premier plan

	@Override
	public void windowClosed(WindowEvent e) {
		this.game.getDatabase().close();
	} // après fermeture

	@Override
	public void windowDeactivated(WindowEvent e) {
	} // arrière-plan

	@Override
	public void windowDeiconified(WindowEvent e) {
	} // restauration

	@Override
	public void windowIconified(WindowEvent e) {
	} // minimisation

	@Override
	public void windowOpened(WindowEvent e) {
	} // après ouverture
}
