package monopolyguiv2.gui;

import java.awt.*;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Board extends JPanel {

	private ArrayList<Square> allSquares = new ArrayList<Square>();
	private ArrayList<Square> publicSquares = new ArrayList<Square>(); 
	private ArrayList<Square> bonusRollSquares = new ArrayList<Square>();
        private ArrayList<Square> taxedSquares = new ArrayList<Square>();
                
	public ArrayList<Square> getPublicSquares(){
		return publicSquares;
	}
	
	public ArrayList<Square> getAllSquares(){
		return allSquares;
	}
        
        public ArrayList<Square> getBonusRollSquares(){
		return bonusRollSquares;
	}
        
        public ArrayList<Square> getTaxedSquares(){
		return taxedSquares;
	}

	public Board(int xCoord, int yCoord, int width, int height) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(xCoord, yCoord, 1212, 1012);
		this.setLayout(null);
		initSquares();
	}

	private void initSquares() {
		// TODO Auto-generated method stub
		String[] squareNames = {
				"Go",
                                "Astro City",
                                "Blue Valley",
                                "Central City",
                                "Income Tax",
                                "Coast City",
				"DuckBurn City",
                                "Gooseville City",
				"Free Parking",
				"Gotham City",
				"Keystone City",
				"Midway City",
				"Income Tax",
				"Metropolis",
				"Star City",
				"Mega-City One",
				"Free Parking",
				"Greendale City",
				"Argo City",
				"Citrusville",
                                "Income Tax",
                                "Champignac City",
                                "Citrusville City",
                                "Doomstadt City",
                                "Free Parking",
                                "Fuxholzen City",
                                "Hootin' Holler Town",
                                "Asgard",
                                "Income Tax",
                                "Kryptonopolis",
                                "Wakanda",
				"Savage Land",
		};
		

		// squares on the bottom
		Square square00 = new Square(806,806,100,100,squareNames[0],0);
		this.add(square00);
		allSquares.add(square00);
		publicSquares.add(square00);
		
		Square square01 = new Square(706,806,100,100,squareNames[1],0);
		this.add(square01);
		allSquares.add(square01);
		
		Square square02 = new Square(606,806,100,100,squareNames[2],0);
		this.add(square02);
		allSquares.add(square02);
		
		Square square03 = new Square(506,806,100,100,squareNames[3],0);
		this.add(square03);
		allSquares.add(square03);
		
		Square square04 = new Square(406,806,100,100,squareNames[4],0);
		this.add(square04);
		allSquares.add(square04);
                publicSquares.add(square04);
                taxedSquares.add(square04);
		
		Square square05 = new Square(306,806,100,100,squareNames[5],0);
		this.add(square05);
		allSquares.add(square05);

		Square square06 = new Square(206,806,100,100,squareNames[6],0);
		this.add(square06);
		allSquares.add(square06);
		
		Square square07 = new Square(106,806,100,100,squareNames[7],0);
		this.add(square07);
		allSquares.add(square07);
		
		Square square08 = new Square(6,806,100,100,squareNames[8],0);
		this.add(square08);
		allSquares.add(square08);
                publicSquares.add(square08);
                //bonusRollSquares.add(square08);
                
                // squares on the left
		
		Square square09 = new Square(6,706,100,100,squareNames[9],0);
		this.add(square09);
		allSquares.add(square09);
		
		Square square10 = new Square(6,606,100,100,squareNames[10],0);
		this.add(square10);
		allSquares.add(square10);

		Square square11 = new Square(6,506,100,100,squareNames[11],0);
		this.add(square11);
		allSquares.add(square11);
		
		Square square12 = new Square(6,406,100,100,squareNames[12],0);
		this.add(square12);
		allSquares.add(square12);
		publicSquares.add(square12);
                taxedSquares.add(square12);
		
		Square square13 = new Square(6,306,100,100,squareNames[13],0);
		this.add(square13);
		allSquares.add(square13);
		
		Square square14 = new Square(6,206,100,100,squareNames[14],0);
		this.add(square14);
		allSquares.add(square14);
		
		Square square15 = new Square(6,106,100,100,squareNames[15],0);
		this.add(square15);
		allSquares.add(square15);
		
		Square square16 = new Square(6,6,100,100,squareNames[16],0);
		this.add(square16);
		allSquares.add(square16);
                publicSquares.add(square16);
                
                //squares on the top
		
		Square square17 = new Square(106,6,100,100,squareNames[17],0);
		this.add(square17);
		allSquares.add(square17);
		
		Square square18 = new Square(206,6,100,100,squareNames[18],0);
		this.add(square18);
		allSquares.add(square18);
		
		Square square19 = new Square(306,6,100,100,squareNames[19],0);
		this.add(square19);
		allSquares.add(square19);
                
                Square square20 = new Square(406,6,100,100,squareNames[20],0);
		this.add(square20);
		allSquares.add(square20);
                publicSquares.add(square20);
                taxedSquares.add(square20);
                
                Square square21 = new Square(506,6,100,100,squareNames[21],0);
		this.add(square21);
		allSquares.add(square21);
                
                Square square22 = new Square(606,6,100,100,squareNames[22],0);
		this.add(square22);
		allSquares.add(square22);
                
                Square square23 = new Square(706,6,100,100,squareNames[23],0);
		this.add(square23);
		allSquares.add(square23);
                
                Square square24 = new Square(806,6,100,100,squareNames[24],0);
		this.add(square24);
		allSquares.add(square24);
                publicSquares.add(square24);
                //bonusRollSquares.add(square08);
		
                //squares on the right
                
                Square square25 = new Square(806,106,100,100,squareNames[25],0);
		this.add(square25);
		allSquares.add(square25);
                
                Square square26 = new Square(806,206,100,100,squareNames[26],0);
		this.add(square26);
		allSquares.add(square26);
                
                Square square27 = new Square(806,306,100,100,squareNames[27],0);
		this.add(square27);
		allSquares.add(square27);
                
                Square square28 = new Square(806,406,100,100,squareNames[28],0);
		this.add(square28);
		allSquares.add(square28);
                publicSquares.add(square28);
                taxedSquares.add(square28);
                
                Square square29 = new Square(806,506,100,100,squareNames[29],0);
		this.add(square29);
		allSquares.add(square29);
                
                Square square30 = new Square(806,606,100,100,squareNames[30],0);
		this.add(square30);
		allSquares.add(square30);
                
                Square square31 = new Square(806,706,100,100,squareNames[31],0);
		this.add(square31);
		allSquares.add(square31);
                
		// setting prices
		square01.setBuyPrice(100);
		square02.setBuyPrice(100);
		square03.setBuyPrice(120);
		
		square05.setBuyPrice(140);
		square06.setBuyPrice(140);
		square07.setBuyPrice(160);
		
		square09.setBuyPrice(180);
		square10.setBuyPrice(180);
		square11.setBuyPrice(200);
		
		square13.setBuyPrice(220);
		square14.setBuyPrice(220);
		square15.setBuyPrice(240);
                
                square17.setBuyPrice(260);
		square18.setBuyPrice(260);
		square19.setBuyPrice(280);
		
		square21.setBuyPrice(300);
		square22.setBuyPrice(300);
		square23.setBuyPrice(320);
		
		square25.setBuyPrice(340);
		square26.setBuyPrice(340);
		square27.setBuyPrice(360);
		
		square29.setBuyPrice(380);
		square30.setBuyPrice(380);
		square31.setBuyPrice(400);
		
		// setting rent prcies
		square01.setRentPrice(6);
		square02.setRentPrice(6);
		square03.setRentPrice(8);
		
		square05.setRentPrice(10);
		square06.setRentPrice(10);
		square07.setRentPrice(12);
		
		square09.setRentPrice(14);
		square10.setRentPrice(14);
		square11.setRentPrice(16);
		
		square13.setRentPrice(18);
		square14.setRentPrice(18);
		square15.setRentPrice(20);
                
                square17.setRentPrice(22);
		square18.setRentPrice(22);
		square19.setRentPrice(24);
		
		square21.setRentPrice(26);
		square22.setRentPrice(26);
		square23.setRentPrice(28);
		
		square25.setRentPrice(30);
		square26.setRentPrice(30);
		square27.setRentPrice(32);
		
		square29.setRentPrice(34);
		square30.setRentPrice(34);
		square31.setRentPrice(36);
		
		
		

		JLabel lblMonopoly = new JLabel("MONOPOLY GAME");
		lblMonopoly.setForeground(Color.WHITE);
		lblMonopoly.setBackground(Color.PINK);
		lblMonopoly.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonopoly.setFont(new Font("NewellsHand", Font.PLAIN, 40));
		lblMonopoly.setBounds(287, 377, 363, 75);
		this.add(lblMonopoly);
		
	}





}
