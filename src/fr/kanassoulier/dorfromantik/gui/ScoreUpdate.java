package fr.kanassoulier.dorfromantik.gui;

import java.awt.Color;

import javax.swing.Timer;
import javax.swing.JLabel;

import fr.kanassoulier.dorfromantik.game.Game;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

public class ScoreUpdate extends JLabel {
  private static final int GAP = 10;
  private static final int HEIGHT = 50;

  private Gui gui;
  private Timer timer;
  private int opacity = 0;

  public ScoreUpdate(Gui gui) {
    super("", JLabel.LEFT);

    this.gui = gui;

    super.setText("");
    this.setFont(FontLoader.LEXEND_BOLD);
    this.setForeground(new Color(190, 190, 190, this.opacity));
  }

  public void setOpacity(int opacity) {
    this.opacity = opacity;
    this.setForeground(new Color(190, 190, 190, this.opacity));
  }

  public Timer getTimer() {
    return this.timer;
  }

  public void setVerticalAxis(int deltaY) {
    Scoreboard scoreboard = this.gui.getScoreboard();
    int scoreTextWidth = this.getFontMetrics(scoreboard.getFont()).stringWidth(scoreboard.getText());

    this.setBounds(Game.WINDOW_WIDTH / 2 + scoreTextWidth / 2 + ScoreUpdate.GAP,
        -deltaY + 25,
        Game.WINDOW_WIDTH / 2 - scoreTextWidth / 2 - ScoreUpdate.GAP,
        ScoreUpdate.HEIGHT);
  }

  @Override
  public void setText(String text) {
    super.setText(text);

    this.timer = new Timer(1, new ScoreUpdateTimerListener(this));
    timer.start();
  }
}
