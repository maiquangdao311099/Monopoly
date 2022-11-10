package monopolyguiv2.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.LineBorder;

public class Dice extends JPanel {
	
	Random rnd = new Random();
	int diceValue = 6;
	
	public Dice(int xCoord, int yCoord, int width, int height) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(xCoord, yCoord, width, height);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(diceValue == 1) {
                    g.fillOval(getWidth()/2 - 5/2, getHeight()/2 - 5/2, 5, 5);
                          
		} else if(diceValue == 2) {
			g.fillOval(getWidth()/2 - 15, getHeight()/2 + 10, 5, 5);
			g.fillOval(getWidth()/2 + 10, getHeight()/2 - 15, 5, 5);
		} else if(diceValue == 3) {
			g.fillOval(getWidth()/2 - 15, getHeight()/2 + 10, 5, 5);
			g.fillOval(getWidth()/2 + 10, getHeight()/2 - 15, 5, 5);
			g.fillOval(getWidth()/2 - 5/2, getHeight()/2 - 5/2, 5, 5);
		} else if(diceValue == 4) {
			g.fillOval(getWidth()/2 - 15, getHeight()/2 + 10, 5, 5);
			g.fillOval(getWidth()/2 + 10, getHeight()/2 - 15, 5, 5);
			g.fillOval(getWidth()/2 - 15, getHeight()/2 - 15, 5, 5);
			g.fillOval(getWidth()/2 + 10, getHeight()/2 + 10, 5, 5);
		} else if(diceValue == 5) {
			g.fillOval(getWidth()/2 - 15, getHeight()/2 + 10, 5, 5);
			g.fillOval(getWidth()/2 + 10, getHeight()/2 - 15, 5, 5);
			g.fillOval(getWidth()/2 - 15, getHeight()/2 - 15, 5, 5);
			g.fillOval(getWidth()/2 + 10, getHeight()/2 + 10, 5, 5);
			g.fillOval(getWidth()/2 - 5/2, getHeight()/2 - 5/2, 5, 5);
		} else {
			g.fillOval(getWidth()/2 - 15, getHeight()/2 + 10, 5, 5);
			g.fillOval(getWidth()/2 + 10, getHeight()/2 - 15, 5, 5);
			g.fillOval(getWidth()/2 - 15, getHeight()/2 - 15, 5, 5);
			g.fillOval(getWidth()/2 + 10, getHeight()/2 + 10, 5, 5);
			g.fillOval(getWidth()/2 - 15, getHeight()/2 - 5/2, 5, 5);
			g.fillOval(getWidth()/2 + 10, getHeight()/2 - 5/2, 5, 5);
		}
		
	}
	
	public void rollDice(){
		diceValue = rnd.nextInt(6) + 1;
		repaint();
	}
	
	public int getDiceValue(){
		return diceValue;
	}
	

}
