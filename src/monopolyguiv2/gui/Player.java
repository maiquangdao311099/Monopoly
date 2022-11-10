package monopolyguiv2.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Player extends JPanel {

	private int playerNumber;
	JLabel playerIcon;
	static int totalPlayers = 0;

        static ArrayList<Integer> allProperties = new ArrayList<Integer>();

	private int playerPosition = 0;
	private ArrayList<Integer> properties = new ArrayList<Integer>();
        
	private int wallet = 3000;
        

	public ArrayList<Integer> getProperties() {
		return properties;
	}
	
        public void setWallet(int money) {
		wallet = money;
	}
        
	public int getWallet() {
		return wallet;
	}

	public void withdraw(int withdrawAmount) {
		if(withdrawAmount > wallet) {
			setVisible(false);
		} else {
			wallet -= withdrawAmount;
		}
	}

	public void deposit(int depositAmount) {
		wallet += depositAmount;
	}

	public int getPlayerPosition() {
		return playerPosition;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void buySquare(int squareNumber) {
		if(allProperties.contains(squareNumber)) {
			System.out.println("It's belong to someone else");
		} else {
			properties.add(this.getPlayerPosition());
                        allProperties.add(this.getPlayerPosition());
		}
	}

	public Player(int playerNumber, Color color) {
		this.playerNumber = playerNumber;
		this.setBackground(color);
		playerIcon = new JLabel(""+playerNumber);
		playerIcon.setFont(new Font("NewellsHand", Font.PLAIN, 15));
		playerIcon.setForeground(Color.WHITE);
		this.add(playerIcon); 
		if(playerNumber == 1){
                    this.setBounds(830, 833, 25, 28);
                }else if(playerNumber == 2){
                    this.setBounds(860, 833, 25, 28);
                }else if(playerNumber == 3){
                    this.setBounds(830, 863, 25, 28);
                }else{
                    this.setBounds(860, 863, 25, 28);
                }
                this.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPlayers++;
	}



	int[] xCoorPlayer1 = {831, 731, 631, 531, 431, 331, 231, 131, 31,
                               31,  31,  31,  31,  31,  31,  31,  31,
                              131, 231, 331, 431, 531, 631, 731, 831,
                              831, 831, 831, 831, 831, 831, 831};

	int[] yCoorPlayer1 = {833, 833, 833, 833, 833, 833, 833, 833, 833,
			      733, 633, 533, 433, 333, 233, 133, 33,
                               33,  33,  33,  33,  33,  33,  33, 33,
                              133, 233, 333, 433, 533, 633, 733};
	
	int[] xCoorPlayer2 = {861, 761, 661, 561, 461, 361, 261, 161, 61,
                               61,  61,  61,  61,  61,  61,  61,  61,
                              161, 261, 361, 461, 561, 661, 761, 861,
                              861, 861, 861, 861, 861, 861, 861};

	int[] yCoorPlayer2 = {833, 833, 833, 833, 833, 833, 833, 833, 833,
                              733, 633, 533, 433, 333, 233, 133, 33,
                               33,  33,  33,  33,  33,  33,  33, 33,
                              133, 233, 333, 433, 533, 633, 733};
        
        int[] xCoorPlayer3 = {831, 731, 631, 531, 431, 331, 231, 131, 31,
                               31,  31,  31,  31,  31,  31,  31,  31,
                              131, 231, 331, 431, 531, 631, 731, 831,
                              831, 831, 831, 831, 831, 831, 831};

	int[] yCoorPlayer3 = {863, 863, 863, 863, 863, 863, 863, 863, 863,
			      763, 663, 563, 463, 363, 263, 163, 63,
                               63,  63,  63,  63,  63,  63,  63, 63,
                              163, 263, 363, 463, 563, 663, 763};
	
	int[] xCoorPlayer4 = {861, 761, 661, 561, 461, 361, 261, 161, 61,
                               61,  61,  61,  61,  61,  61,  61,  61,
                               161, 261, 361, 461, 561, 661, 761, 861,
                               861, 861, 861, 861, 861, 861, 861};

	int[] yCoorPlayer4 = {863, 863, 863, 863, 863, 863, 863, 863, 863,
			      763, 663, 563, 463, 363, 263, 163, 63,
			       63,  63,  63,  63,  63,  63,  63, 63,
			      163, 263, 363, 463, 563, 663, 763};
	

	public void move(int dicesTotal) {
		if(playerPosition + dicesTotal > 31) {
			deposit(200);
		}
		int targetSquare = (playerPosition + dicesTotal) % 32;
		playerPosition = targetSquare;
		
		if(MonopolyGame.nowPlaying == 0) {
			this.setLocation(xCoorPlayer1[targetSquare], yCoorPlayer1[targetSquare]);
		} else if(MonopolyGame.nowPlaying == 1) {
			this.setLocation(xCoorPlayer2[targetSquare], yCoorPlayer2[targetSquare]);
		} else if(MonopolyGame.nowPlaying == 2) {
			this.setLocation(xCoorPlayer3[targetSquare], yCoorPlayer4[targetSquare]);
		} else if(MonopolyGame.nowPlaying == 3) {
			this.setLocation(xCoorPlayer4[targetSquare], yCoorPlayer4[targetSquare]);
		} 
		
	}

}
