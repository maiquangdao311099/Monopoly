package monopolyguiv2.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Square extends JPanel {

	int number;
	private String squareName;
	JLabel squareTitle;
	static int totalSquares = 0;
	private int buyPrice;
	private int rentPrice;
        private int owner = 4;
	
        public void setOwner(int ownerNumber){
            owner = ownerNumber;
        }
        
        public int getOwner(){
            return owner;
        }
        
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	public int getRentPrice() {
		return rentPrice;
	}
	
	public void setBuyPrice(int price) {
		this.buyPrice = price;
	}
	
	public int getBuyPrice() {
		return buyPrice;
	}
	
	public String getSquareName() {
		return squareName;
	}
	
	
	public Square(int xCoord, int yCoord, int width, int height, String labelString, int rotationDegrees) {
		number = totalSquares;
		totalSquares++;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(xCoord, yCoord, width, height);
		squareName = labelString;
		this.setLayout(null);

		squareTitle = new JLabel(labelString);
		squareTitle.setFont(new Font("NewellsHand", Font.PLAIN, 12));
		squareTitle.setHorizontalAlignment(SwingConstants.CENTER);
		squareTitle.setBounds(0,20,this.getWidth(),20);
		this.add(squareTitle);

		squareTitle.setFont(new Font("NewellsHand", Font.PLAIN, 12));
		squareTitle.setHorizontalAlignment(SwingConstants.CENTER);
			
		this.add(squareTitle);
		

	}
        
        
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(this.number == 1 || this.number == 2 || this.number == 3 || this.number == 5 || this.number == 6 || this.number == 7) {
			if(this.owner == 0){
                            g.drawRect(0, 0, this.getWidth(), 20);
                            g.setColor(Color.RED);
                            g.fillRect(0, 0, this.getWidth(), 20);
                        }else if(this.owner == 1){
                            g.drawRect(0, 0, this.getWidth(), 20);
                            g.setColor(Color.BLUE);
                            g.fillRect(0, 0, this.getWidth(), 20);
                        }else if(this.owner == 2){
                            g.drawRect(0, 0, this.getWidth(), 20);
                            g.setColor(Color.GREEN);
                            g.fillRect(0, 0, this.getWidth(), 20);
                        }else if(this.owner == 3){
                            g.drawRect(0, 0, this.getWidth(), 20);
                            g.setColor(Color.ORANGE);
                            g.fillRect(0, 0, this.getWidth(), 20);
                        }
		}
		if(this.number == 9 || this.number == 10 || this.number == 11 || this.number == 13 || this.number == 14 || this.number == 15) {
			if(this.owner == 0){
                            g.drawRect(this.getWidth()-20, 0, 20, this.getHeight());
                            g.setColor(Color.RED);
                            g.fillRect(this.getWidth()-20, 0, 20, this.getHeight());
                        }else if(this.owner == 1){
                            g.drawRect(this.getWidth()-20, 0, 20, this.getHeight());
                            g.setColor(Color.BLUE);
                            g.fillRect(this.getWidth()-20, 0, 20, this.getHeight());
                        }else if(this.owner == 2){
                            g.drawRect(this.getWidth()-20, 0, 20, this.getHeight());
                            g.setColor(Color.GREEN);
                            g.fillRect(this.getWidth()-20, 0, 20, this.getHeight());
                        }else if(this.owner == 3){
                            g.drawRect(this.getWidth()-20, 0, 20, this.getHeight());
                            g.setColor(Color.ORANGE);
                            g.fillRect(this.getWidth()-20, 0, 20, this.getHeight());
                        }

		}
		if(this.number == 17 || this.number == 18 || this.number == 19 || this.number == 21 || this.number == 22 || this.number == 23) {
			if(this.owner == 0){
                            g.drawRect(0, this.getHeight()-20, this.getWidth(), 20);
                            g.setColor(Color.RED);
                            g.fillRect(0, this.getHeight()-20, this.getWidth(), 20);
                        }else if(this.owner == 1){
                            g.drawRect(0, this.getHeight()-20, this.getWidth(), 20);
                            g.setColor(Color.BLUE);
                            g.fillRect(0, this.getHeight()-20, this.getWidth(), 20);
                        }else if(this.owner == 2){
                            g.drawRect(0, this.getHeight()-20, this.getWidth(), 20);
                            g.setColor(Color.GREEN);
                            g.fillRect(0, this.getHeight()-20, this.getWidth(), 20);
                        }else if(this.owner == 3){
                            g.drawRect(0, this.getHeight()-20, this.getWidth(), 20);
                            g.setColor(Color.ORANGE);
                            g.fillRect(0, this.getHeight()-20, this.getWidth(), 20);
                        }
                        
		}
		if(this.number == 25 || this.number == 26 || this.number == 27 || this.number == 29 || this.number == 30 || this.number == 31) {
			if(this.owner == 0){
                            g.drawRect(0, 0, 20, this.getHeight());
                            g.setColor(Color.RED);
                            g.fillRect(0, 0, 20, this.getHeight());
                        }else if(this.owner == 1){
                            g.drawRect(0, 0, 20, this.getHeight());
                            g.setColor(Color.BLUE);
                            g.fillRect(0, 0, 20, this.getHeight());
                        }else if(this.owner == 2){
                            g.drawRect(0, 0, 20, this.getHeight());
                            g.setColor(Color.GREEN);
                            g.fillRect(0, 0, 20, this.getHeight());
                        }else if(this.owner == 3){
                            g.drawRect(0, 0, 20, this.getHeight());
                            g.setColor(Color.ORANGE);
                            g.fillRect(0, 0, 20, this.getHeight());
                        }

		}

	}


}
