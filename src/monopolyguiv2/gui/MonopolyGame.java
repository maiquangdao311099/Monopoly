package monopolyguiv2.gui;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class MonopolyGame extends JFrame implements ActionListener{

	Player player1;
	Player player2;
        Player player3;
        Player player4;
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Player> bankruptPlayers = new ArrayList<Player>();
        Board map;
        JPanel gameContent;
	static JTextArea notify;
        JButton nextTurn;
	JButton rollDice;
	JButton payRent;
	JButton buy;
	JPanel player1Assets;
        JPanel player2Assets;
        JPanel player3Assets;
        JPanel player4Assets;
        JTextArea player1Wealth;
	JTextArea player2Wealth;
        JTextArea player3Wealth;
	JTextArea player4Wealth;
	static int turnCounter = 0;
	Boolean doubleDice = false;

	static int nowPlaying = 0;
        
        public static void main(String[] args) {

		MonopolyGame newGame = new MonopolyGame();
		newGame.setVisible(true);
                
                
	}
        
	
	public MonopolyGame() {
		gameContent = new JPanel();
		gameContent.setBorder(new LineBorder(new Color(0, 0, 0)));
		gameContent.setLayout(null);

		JLayeredPane mixedContent = new JLayeredPane();
		mixedContent.setBorder(new LineBorder(new Color(0, 0, 0)));
		mixedContent.setBounds(456,6, 930, 930);
		gameContent.add(mixedContent);

		map = new Board(6,6,912,912);
		map.setBackground(Color.pink);
                map.setBorder(new LineBorder(new Color(0,0,0)));
		mixedContent.add(map, new Integer(0));
                mixedContent.setBorder(new LineBorder(new Color(0, 0, 0)));
                gameContent.add(mixedContent);

		player1 = new Player(1, Color.RED);
		players.add(player1);
		mixedContent.add(player1, new Integer(1));

		player2 = new Player(2, Color.BLUE);
		players.add(player2);
		mixedContent.add(player2, new Integer(1));
                
                player3 = new Player(3, Color.GREEN);
		players.add(player3);
		mixedContent.add(player3, new Integer(1));
                
                player4 = new Player(4, Color.ORANGE);
		players.add(player4);
		mixedContent.add(player4, new Integer(1));

		JPanel rightUI = new JPanel();
		rightUI.setBackground(Color.PINK);
		rightUI.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightUI.setBounds(1400, 6, 450, 900);
		gameContent.add(rightUI);
		rightUI.setLayout(null);
                
                JPanel leftUI = new JPanel();
		leftUI.setBackground(Color.PINK);
		leftUI.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftUI.setBounds(6, 6, 450, 900);
		gameContent.add(leftUI);
		leftUI.setLayout(null);
                
                JPanel instructor = new JPanel();
		instructor.setBounds(46, 330, 376, 137);
		rightUI.add(instructor);
		instructor.setLayout(null);

		notify = new JTextArea();
		notify.setBounds(6, 6, 361, 125);
                notify.setFont(new Font("NewellsHand", Font.PLAIN, 20));
		instructor.add(notify);
		notify.setLineWrap(true);
		notify.setText("Welcome to our Monopoly Game!");
                
                Dice dice1 = new Dice(336, 550, 60, 60);
		mixedContent.add(dice1, new Integer(1));

		Dice dice2 = new Dice(436, 550, 60, 60);
		mixedContent.add(dice2, new Integer(1));
                
                
                
		rollDice = new JButton("Roll The Dice");
                rollDice.setFont(new Font("NewellsHand", Font.PLAIN, 27));
                
		rollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                            Player currentPlayer = players.get(nowPlaying);
                            
					dice1.rollDice();
					dice2.rollDice();
					int dicesTotal = dice1.getDiceValue() + dice2.getDiceValue();
                                        if(dice1.getDiceValue() == dice2.getDiceValue()) {
                                                    doubleDice = true;
                                            } else {
                                                    doubleDice = false;
                                            }
                                        
                                         currentPlayer.move(dicesTotal);
                                            
                                        
					if(Player.allProperties.contains(currentPlayer.getPlayerPosition()) 
						&& map.getAllSquares().get(currentPlayer.getPlayerPosition()).getOwner() != nowPlaying) {
						buy.setEnabled(false);
						rollDice.setEnabled(false);
						nextTurn.setEnabled(false);
						payRent.setEnabled(true);
					} 
					if (Player.allProperties.contains(currentPlayer.getPlayerPosition()) 
						&& map.getAllSquares().get(currentPlayer.getPlayerPosition()).getOwner() == nowPlaying) {
						buy.setEnabled(false);
						payRent.setEnabled(false);
						nextTurn.setEnabled(true);
					}
					if(map.getPublicSquares().contains(map.getAllSquares().get(currentPlayer.getPlayerPosition()))) {
						buy.setEnabled(false);
						nextTurn.setEnabled(true);
					} else if (!Player.allProperties.contains(currentPlayer.getPlayerPosition())) { 
						buy.setEnabled(true);
						nextTurn.setEnabled(true);
						payRent.setEnabled(false);
					} 
                                        if(map.getTaxedSquares().contains(map.getAllSquares().get(currentPlayer.getPlayerPosition()))){
                                            if(currentPlayer.getWallet() < 200){
                                                bankruptPlayers.add(currentPlayer);
                                                notify.setText("Current player went bankrupt!");
                                                currentPlayer.setBackground(Color.BLACK);
                                                currentPlayer.setWallet(0);
                                                //remove the color marks on bankrup player's squares
                                                for(int i = 0; i < map.getAllSquares().size(); i++){
                                                    if(map.getAllSquares().get(i).getOwner() == nowPlaying){
                                                        map.getAllSquares().get(i).setOwner(4);
                                                    }
                                                }    

                                                    Player.allProperties.removeAll(currentPlayer.getProperties());
                                                    

                                                
                                            }else{
                                            currentPlayer.withdraw(200);
                                            notify.setText("Current player paid $200 in taxes");
                                            }
                                        }


				rollDice.setEnabled(false);
                                
				if(!doubleDice) {
					notify.setText("Your turn is over, click Button Next Turn");
				} else {
					notify.setText("You have bonus turn!");
				}
                                
			
				mixedContent.remove(map);
				mixedContent.add(map, new Integer(0));
				
				updatePlayer1Wealth();
                                updatePlayer2Wealth();
                                updatePlayer3Wealth();
                                updatePlayer4Wealth();

			}
		});
                
		rollDice.setBounds(46, 67, 376, 96);
		rightUI.add(rollDice);
                
                nextTurn = new JButton("Next Turn");
                nextTurn.setFont(new Font("NewellsHand", Font.PLAIN, 27));
		nextTurn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
                                
                                if(doubleDice){
                                    nowPlaying = nowPlaying;
                                    notify.setText("Current player has bonus turn!");
                                    doubleDice = false;
                                }else {
					nowPlaying = (nowPlaying + 1) % 4;
                                        if(nowPlaying == 0){
                                            turnCounter++;
                                        }
                                        notify.setText("It's now Player " + (nowPlaying+1) + "'s turn");
				}
                                
                                Player currentPlayer = players.get(nowPlaying);
                                
                                notify.setText("It's now Player " + (nowPlaying+1) + "'s turn");
                                
                                if(bankruptPlayers.contains(currentPlayer)){
                                    notify.setText("Current Player went bankrupt!");
                                    rollDice.setEnabled(false);
                                    buy.setEnabled(false);
                                    payRent.setEnabled(false);
                                    nextTurn.setEnabled(true);
                                }else{
                                    rollDice.setEnabled(true);
                                    buy.setEnabled(false);
                                    payRent.setEnabled(false);
                                    nextTurn.setEnabled(false);
                                }
                                
                                
                                if(turnCounter == 20 || bankruptPlayers.size() == 3){
                                    buy.setEnabled(false);
                                    rollDice.setEnabled(false);
                                    nextTurn.setEnabled(false);
                                    payRent.setEnabled(false);
                                    
                                    String result = "";
                                    int highestBalance = players.get(0).getWallet();
                                    Player winner = players.get(0);
                                    for(int i = 0; i < players.size(); i++){
                                        if(players.get(i).getWallet() > highestBalance){
                                            highestBalance = players.get(i).getWallet();
                                            winner = players.get(i);
                                        }
                                    }
                                    result += "Congratulation! Player " + winner.getPlayerNumber() + " won!\n";
                                    notify.setText(result);
                                }
                                
                                mixedContent.remove(map);
				mixedContent.add(map, new Integer(0));
                                
				updatePlayer1Wealth();
                                updatePlayer2Wealth();
                                updatePlayer3Wealth();
                                updatePlayer4Wealth();
                        
			}

		

		});
                
               
		
		nextTurn.setBounds(46, 196, 376, 96);
		rightUI.add(nextTurn);
		nextTurn.setEnabled(false);

		buy = new JButton("Buy");
                buy.setFont(new Font("NewellsHand", Font.PLAIN, 27));
		buy.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
                                
				Player currentPlayer = players.get(nowPlaying);
                                
                                int withdrawAmount = map.getAllSquares().get(currentPlayer.getPlayerPosition()).getBuyPrice();
                                
                                if(withdrawAmount > currentPlayer.getWallet()){
                                    notify.setText("you don't have enough money to buy this square");
                                    notify.setText("Current Player went bankrupt!");
                                    currentPlayer.setWallet(0);
                                    bankruptPlayers.add(currentPlayer);
                                    currentPlayer.setBackground(Color.BLACK);
                                    //remove the color marks on bankrup player's squares
                                                for(int i = 0; i < map.getAllSquares().size(); i++){
                                                    if(map.getAllSquares().get(i).getOwner() == nowPlaying){
                                                        map.getAllSquares().get(i).setOwner(4);
                                                    }
                                                }    

                                                    Player.allProperties.removeAll(currentPlayer.getProperties());
                                }else{
				notify.setText("You bought "+map.getAllSquares().get(currentPlayer.getPlayerPosition()).getSquareName());                                    
				currentPlayer.buySquare(currentPlayer.getPlayerPosition());
                                map.getAllSquares().get(currentPlayer.getPlayerPosition()).setOwner(nowPlaying);                                
				currentPlayer.withdraw(withdrawAmount);
                                }
                                
				buy.setEnabled(false);
				updatePlayer1Wealth();
                                updatePlayer2Wealth();
                                updatePlayer3Wealth();
                                updatePlayer4Wealth();

                                mixedContent.remove(map);
				mixedContent.add(map, new Integer(0));
			}
		});
		buy.setBounds(46, 509, 376, 96);
		rightUI.add(buy);
		buy.setEnabled(false);

		payRent = new JButton("Pay Rent");
                payRent.setFont(new Font("NewellsHand", Font.PLAIN, 27));
		payRent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Player currentPlayer = players.get(nowPlaying);
                                Player ownerOfTheSquare;
                                
                                int ownerNumber = map.getAllSquares().get(currentPlayer.getPlayerPosition()).getOwner();
                                
                                ownerOfTheSquare = players.get(ownerNumber);
                                
                                int withdrawAmount = map.getAllSquares().get(currentPlayer.getPlayerPosition()).getRentPrice();
                                if(withdrawAmount > currentPlayer.getWallet()){
                                    notify.setText("Current Player went bankrupt!");
                                    bankruptPlayers.add(currentPlayer);
                                    currentPlayer.setWallet(0);
                                    currentPlayer.setBackground(Color.BLACK);
                                    //remove the color marks on bankrup player's squares
                                                for(int i = 0; i < map.getAllSquares().size(); i++){
                                                    if(map.getAllSquares().get(i).getOwner() == nowPlaying){
                                                        map.getAllSquares().get(i).setOwner(4);
                                                    }
                                                }    

                                                    Player.allProperties.removeAll(currentPlayer.getProperties());
                                }else{
                                
				notify.setText("You paid to the player "+ownerOfTheSquare.getPlayerNumber());

				currentPlayer.withdraw(withdrawAmount);
				ownerOfTheSquare.deposit(withdrawAmount);
                                }
				
				nextTurn.setEnabled(true);
				payRent.setEnabled(false);

				updatePlayer1Wealth();
                                updatePlayer2Wealth();
                                updatePlayer3Wealth();
                                updatePlayer4Wealth();
                                
                                mixedContent.remove(map);
				mixedContent.add(map, new Integer(0));

			}

		});
		payRent.setBounds(46, 647, 376, 96);
		rightUI.add(payRent);
		payRent.setEnabled(false);


		player1Assets = new JPanel();
		player1Assets.setBounds(46, 10, 376, 200);
		leftUI.add(player1Assets);
		player1Assets.setLayout(new CardLayout());
                
                player2Assets = new JPanel();
		player2Assets.setBounds(46, 230, 376, 200);
		leftUI.add(player2Assets);
		player2Assets.setLayout(new CardLayout());
                
                player3Assets = new JPanel();
		player3Assets.setBounds(46, 450, 376, 200);
		leftUI.add(player3Assets);
		player3Assets.setLayout(new CardLayout());
                
                player4Assets = new JPanel();
		player4Assets.setBounds(46, 670, 376, 200);
		leftUI.add(player4Assets);
		player4Assets.setLayout(new CardLayout());
                

                
                //player1 info

		JPanel player1Content = new JPanel();
		player1Content.setBackground(Color.RED);
		player1Assets.add(player1Content);
		player1Content.setLayout(null);

		JLabel player1Title = new JLabel("Player 1: ");
		player1Title.setForeground(Color.WHITE);
		player1Title.setHorizontalAlignment(SwingConstants.CENTER);
		player1Title.setBounds(0, 6, 240, 16);
		player1Content.add(player1Title);

		player1Wealth = new JTextArea();
		player1Wealth.setBounds(10, 25, 356, 167);
                player1Wealth.setFont(new Font("NewellsHand", Font.PLAIN, 14));
		player1Content.add(player1Wealth);
                
                //player2 info

		JPanel player2Content = new JPanel();
		player2Content.setBackground(Color.BLUE);
		player2Assets.add(player2Content);
		player2Content.setLayout(null);

		JLabel player2Title = new JLabel("Player 2: ");
		player2Title.setForeground(Color.WHITE);
		player2Title.setHorizontalAlignment(SwingConstants.CENTER);
		player2Title.setBounds(0, 6, 240, 16);
		player2Content.add(player2Title);

		player2Wealth = new JTextArea();
		player2Wealth.setBounds(10, 25, 356, 167);
                player2Wealth.setFont(new Font("NewellsHand", Font.PLAIN, 14));
		player2Content.add(player2Wealth);
                
                //player3 info

		JPanel player3Content = new JPanel();
		player3Content.setBackground(Color.GREEN);
		player3Assets.add(player3Content);
		player3Content.setLayout(null);

		JLabel player3Title = new JLabel("Player 3: ");
		player3Title.setForeground(Color.WHITE);
		player3Title.setHorizontalAlignment(SwingConstants.CENTER);
		player3Title.setBounds(0, 6, 240, 16);
		player3Content.add(player3Title);

		player3Wealth = new JTextArea();
		player3Wealth.setBounds(10, 25, 356, 167);
                player3Wealth.setFont(new Font("NewellsHand", Font.PLAIN, 14));
		player3Content.add(player3Wealth);
                
                //player4 info

		JPanel player4Content = new JPanel();
		player4Content.setBackground(Color.ORANGE);
		player4Assets.add(player4Content);
		player4Content.setLayout(null);

		JLabel player4Title = new JLabel("Player 4: ");
		player4Title.setForeground(Color.WHITE);
		player4Title.setHorizontalAlignment(SwingConstants.CENTER);
		player4Title.setBounds(0, 6, 240, 16);
		player4Content.add(player4Title);

		player4Wealth = new JTextArea();
		player4Wealth.setBounds(10, 25, 356, 167);
                player4Wealth.setFont(new Font("NewellsHand", Font.PLAIN, 14));
		player4Content.add(player4Wealth);
		
		updatePlayer1Wealth();
                updatePlayer2Wealth();
                updatePlayer3Wealth();
                updatePlayer4Wealth();
                
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setSize(1900,1000);
                this.setContentPane(gameContent);
              
                
                

	}
        
        public void updatePlayer1Wealth() {
		String result = "";
		result += "Balance: $"+player1.getWallet()+"\n";
		
		result += "Properties: \n";
		for(int i = 0; i < player1.getProperties().size(); i++) {
			result += " - "+map.getAllSquares().get(player1.getProperties().get(i)).getSquareName()+"\n";
		}
		
		
		player1Wealth.setText(result);
	}
	
	public void updatePlayer2Wealth() {
		String result = "";
		result += "Balance: $"+player2.getWallet()+"\n";
		
		result += "Properties: \n";
		for(int i = 0; i < player2.getProperties().size(); i++) {
			result += " - "+map.getAllSquares().get(player2.getProperties().get(i)).getSquareName()+"\n";
		}
		
		player2Wealth.setText(result);
	}
        
        public void updatePlayer3Wealth() {
		String result = "";
             
		result += "Balance: $"+player3.getWallet()+"\n";
		
		result += "Properties: \n";
		for(int i = 0; i < player3.getProperties().size(); i++) {
			result += " - "+map.getAllSquares().get(player3.getProperties().get(i)).getSquareName()+"\n";
		}
		
		player3Wealth.setText(result);
	}
        
        public void updatePlayer4Wealth() {
		String result = "";
		result += "Balance: $"+player4.getWallet()+"\n";
		
		result += "Properties: \n";
		for(int i = 0; i < player4.getProperties().size(); i++) {
			result += " - "+map.getAllSquares().get(player4.getProperties().get(i)).getSquareName()+"\n";
		}
		
		player4Wealth.setText(result);
	}



    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}