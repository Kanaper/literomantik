package fr.kanassoulier.dorfromantik.end;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.landing.LandingMenu;

public class EndMenuButtonListener implements ActionListener, MouseListener {
  private boolean mouseOver = false;
  private EndMenuButton button;
  private Game game;

  public EndMenuButtonListener(EndMenuButton button, Game game) {
    this.button = button;
    this.game = game;
  }

  public boolean isMouseOver() {
    return this.mouseOver;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.mouseOver = true;
    this.button.repaint();
  }

  @Override
  public void mouseExited(MouseEvent e) {
    this.button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    this.mouseOver = false;
    this.button.repaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    EndMenuButton button = (EndMenuButton) e.getSource();
    SwingUtilities.getWindowAncestor(button).dispose();

    switch (button.getType()) {
      case PLAY:
        this.game.dispose();
        new Game(this.game.getSeed()).setVisible(true);
        break;

      case QUIT:
        this.game.dispose();
        break;

      case MENU:
        this.game.dispose();
        new LandingMenu().setVisible(true);
        break;

      default:
        break;
    }
  }
}
