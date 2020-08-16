package MainStructure;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Player.Player;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Result {

	private JFrame frame;
	Player Play_1,Play_2;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Result(Player Play_1,Player Play_2) {
		this.Play_1=Play_1;
		this.Play_2=Play_2;
		initialise();
	}


	private void initialise() {
		frame = new JFrame();
                frame.setVisible(true);
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 40));
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\MainStructure\\UCLIcon.jpg"));
                
		/* define size and location of the title */
		JLabel resultTitle = new JLabel("Leaderboard");
		resultTitle.setFont(new Font("Arial", Font.PLAIN, 40));
		resultTitle.setBounds(120, 30, 400, 30);
		frame.getContentPane().add(resultTitle);
		
                /* define size and location of the winner details */
                JLabel winner = new JLabel("Winner:");
		winner.setBounds(100, 120, 50, 30);
		frame.getContentPane().add(winner);
		JLabel winnerDetail = new JLabel("default");
		winnerDetail.setBounds(200, 120, 300, 30);
		frame.getContentPane().add(winnerDetail);
		winner.setVisible(true);
                
                /* define size and location of the loser details */
		JLabel loser = new JLabel("Loser:");
		loser.setBounds(100, 170, 50, 30);
		frame.getContentPane().add(loser);
                JLabel loserDetail = new JLabel("default");
		loserDetail.setBounds(200, 170, 300, 30);
		frame.getContentPane().add(loserDetail);
                loser.setVisible(true);
                
                /* define size and location of the draw label */
                JLabel drawLabel = new JLabel("Draw !");
		drawLabel.setBounds(100, 120, 50, 30);
                frame.getContentPane().add(drawLabel);
                drawLabel.setVisible(false);
                
                /*Logo*/
                JLabel logo = new JLabel(new ImageIcon("src\\MainStructure\\UCLlogo.png"));
                logo.setBounds(0, 315, 170, 55);
                logo.setVisible(true);
                frame.getContentPane().add(logo);
                
                /* define size and location of the developers details */
                JLabel develop = new JLabel("Developed by:");
		JLabel gp = new JLabel("Guanhao Peng, zcemghp@ucl.ac.uk");
                JLabel jy = new JLabel("Junrong Yao, zcemaox@ucl.ac.uk");
		develop.setBounds(190, 320, 80, 30);
		frame.getContentPane().add(develop);
		gp.setBounds(275, 314, 400, 20);
		frame.getContentPane().add(gp);
		jy.setBounds(275, 335, 400, 20);
		frame.getContentPane().add(jy);

                /*define the results when player1 won*/
		if(Play_1.getscore() >Play_2.getscore()){
			winnerDetail.setText(Play_1.getName()+"         score="+Play_1.getscore());
			loserDetail.setText(Play_2.getName()+"          score="+Play_2.getscore());
		}
                /*define the results when player2 won*/
                else if(Play_2.getscore() > Play_1.getscore()){
			winnerDetail.setText(Play_2.getName()+"         score="+Play_2.getscore());
			loserDetail.setText(Play_1.getName()+"          score="+Play_1.getscore());
		}
                /*define the results when it is a draw*/
                else{
                    winner.setVisible(false);
                    loser.setVisible(false);
                    drawLabel.setVisible(true);
                    winnerDetail.setText(Play_1.getName()+" and "+Play_2.getName()+ " have the same score : "+Play_1.getscore());
                    loserDetail.setText("");          
                }
		JButton playAgainFunction = new JButton("Play Again");
                
                /* set the size and location of the re-play button */
		playAgainFunction.setBounds(100, 230, 100, 40);
		frame.getContentPane().add(playAgainFunction);
                /*set the interface after clicking the back button, so it returns back to the first question */
		playAgainFunction.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new game(new Player(Play_1.getName()),new Player(Play_2.getName()));
				frame.setVisible(false);
			}
		});
                
                /* set the size and location of the exit button */
		JButton exitFunction = new JButton("Exit");
		exitFunction.setBounds(300, 230, 100, 40);
		frame.getContentPane().add(exitFunction);
                /*quit the game when exit button is selected */
		exitFunction.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					File file=new File("Rank.txt");
					
					InputStreamReader read = new InputStreamReader(
		                    new FileInputStream(file));
					BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    
                    /* to get the records
                    */
                    List<Player> palyers=new ArrayList<Player>();
                    while((lineTxt = bufferedReader.readLine()) != null){
                    
                        String[] x=lineTxt.split(" ");
                        palyers.add(new Player(x[0],Integer.parseInt(x[1])));
                        System.out.println(palyers.size());
                    }
                    bufferedReader.close();
                    read.close();
                    palyers.add(new Player(Play_1.getName(),Play_1.getscore()));
                    palyers.add(new Player(Play_2.getName(),Play_2.getscore()));
                    PrintWriter write=new PrintWriter(file);
                    
                    /* rank the players */
                    
                    for(int i=0;i<palyers.size();i++){
                    	System.out.println(palyers.get(i).getName()+" "+palyers.get(i).getscore());
                    	write.println(palyers.get(i).getName()+" "+palyers.get(i).getscore());
                    }
					
					
					write.close();
					
				}
				catch(Exception ex){
					System.out.println("error");
				}
				System.exit(0);
			}
		});

	}

}

