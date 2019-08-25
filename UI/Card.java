package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Card extends JButton{
	public Card(int i) {
		setIcon(new ImageIcon("./taro/cover.jpg"));
		this.setContentAreaFilled(false);
		setBorder(new LineBorder(Color.white,3));
	}
}
