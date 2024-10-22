package fr.kanassoulier.dorfromantik.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.dorfromantik.enums.KButtonType;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

public class KButton extends JButton {
  private KButtonType type;
  private KButtonListener listener;
  private Color hoverBackground;

  public KButton(String text, KButtonType type) {
    super(text);

    this.type = type;

    this.setBorderPainted(false);
    this.setFocusPainted(false);
    this.setContentAreaFilled(false);

    this.setBorder(new EmptyBorder(10, 0, 10, 0));
    this.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));

    this.listener = new KButtonListener(this);
    this.addMouseListener(this.listener);
  }

  public KButton(KButtonType type) {
    this("", type);
  }

  public KButtonType getType() {
    return this.type;
  }

  public void setHoverBackground(Color hoverBackground) {
    this.hoverBackground = hoverBackground;
  }

  public Color getHoverBackground() {
    return this.hoverBackground;
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2d.setColor(this.listener.isMouseOver() ? this.getHoverBackground() : this.getBackground());
    g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 10, 10);

    g2d.dispose();
    super.paintComponent(g);
  }
}
