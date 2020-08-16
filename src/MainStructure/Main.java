package MainStructure;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Player.Player;
import javax.swing.ImageIcon;

public class Main {

	private JFrame frame;
	private JTextField firstPlayerNameInput; //the first player details in two-players mode
	private JTextField secondPlayerNameInput; //the second player details in two-players mode
	private JTextField palyerVScompter; //the only player details in two-players mode

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialise();
	}
	public void setFrame(){
		frame.setVisible(true);
	}
	
	private void initialise() {
		frame = new JFrame();
                /* set icon and colour*/
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\MainStructure\\UCLIcon.jpg"));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
                /*define buttons and labels*/
		JButton vsComputerFunction = new JButton("Challenge Computer"); //single player button
		JButton seeRankingFunction = new JButton("Ranking"); //to see the record
                JButton beginFunction = new JButton("Begin"); //to-start button
		JButton goBackFunction = new JButton("back"); //back to homepage button
                JLabel firstPlayerName = new JLabel("First Player Name:"); //label for the first player in two-players mode
		JLabel secondPlayerName = new JLabel("Second Player Name:"); ////label for the second player in two-players mode
                JLabel playerNameLabel = new JLabel("Player Name:"); //label for the only player in single-player mode
                
                /*define the UCLlogo*/
                JLabel logo = new JLabel(new ImageIcon("src\\MainStructure\\UCLlogo.png"));
                logo.setBounds(0, 315, 170, 55);
                logo.setVisible(true);
                frame.getContentPane().add(logo);
                
                /* define developers details */
                JLabel develop = new JLabel("Developed by:");
		JLabel gp = new JLabel("Guanhao Peng, zcemghp@ucl.ac.uk");
                JLabel jy = new JLabel("Junrong Yao, zcemaox@ucl.ac.uk");
		develop.setBounds(190, 320, 80, 30);
		frame.getContentPane().add(develop);
		gp.setBounds(275, 314, 400, 20);
		frame.getContentPane().add(gp);
		jy.setBounds(275, 335, 400, 20);
		frame.getContentPane().add(jy);
                develop.setVisible(true);
                gp.setVisible(true);
                jy.setVisible(true);
                
                /* define location and size of the title*/
		JLabel title = new JLabel("Interesting Facts Challenge");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setBounds(60, 30, 400, 50);
		frame.getContentPane().add(title);
		
                /* define location, size and functions of the two-players mode*/
		JButton twoPlayersFunction = new JButton("Two players");
		twoPlayersFunction.setBounds(110, 130, 250, 50);
		frame.getContentPane().add(twoPlayersFunction);
		twoPlayersFunction.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent anEvent){
		twoPlayersFunction.setVisible(false);
		vsComputerFunction.setVisible(false);
		firstPlayerNameInput.setVisible(true);
		secondPlayerNameInput.setVisible(true);
		firstPlayerName.setVisible(true);
		secondPlayerName.setVisible(true);
		beginFunction.setVisible(true);
		goBackFunction.setVisible(true);
		seeRankingFunction.setVisible(false);
                develop.setVisible(false);
                gp.setVisible(false);
                jy.setVisible(false);
                logo.setVisible(true);
			}
		});
		/*set the interface of name inputs for two players mode*/
		firstPlayerName.setBounds(20, 150, 130, 30);
		frame.getContentPane().add(firstPlayerName);
		firstPlayerName.setVisible(false);
		secondPlayerName.setBounds(20, 200, 130, 30);
		frame.getContentPane().add(secondPlayerName);
		secondPlayerName.setVisible(false);
		firstPlayerNameInput = new JTextField();
		firstPlayerNameInput.setBounds(150, 150, 130, 30);
		frame.getContentPane().add(firstPlayerNameInput);
		firstPlayerNameInput.setColumns(10);
		firstPlayerNameInput.setVisible(false);
		secondPlayerNameInput = new JTextField();
		secondPlayerNameInput.setBounds(150, 200, 130, 30);
		frame.getContentPane().add(secondPlayerNameInput);
		secondPlayerNameInput.setColumns(10);
                
                
		/* define location, size of the single-player button
                  and interface of the single-player mode*/
		vsComputerFunction.setBounds(110, 200, 250, 50);
		frame.getContentPane().add(vsComputerFunction);
		vsComputerFunction.addActionListener(new ActionListener(){
                    /* when play with computer is selected, only one name input field is appeared*/
			public void actionPerformed(ActionEvent anEvent){
				palyerVScompter.setVisible(true);
				twoPlayersFunction.setVisible(false);
				vsComputerFunction.setVisible(false);
				playerNameLabel.setVisible(true);
				beginFunction.setVisible(true);
				goBackFunction.setVisible(true);
				seeRankingFunction.setVisible(false);
                                develop.setVisible(false);
                                gp.setVisible(false);
                                jy.setVisible(false);
                                logo.setVisible(true);
			}
		});
		/*set the inputs for single-player mode*/
		playerNameLabel.setBounds(20, 150, 130, 30);
		frame.getContentPane().add(playerNameLabel);
		playerNameLabel.setVisible(false);
		palyerVScompter = new JTextField();
		palyerVScompter.setBounds(150, 150, 130, 30);
		frame.getContentPane().add(palyerVScompter);
		palyerVScompter.setVisible(false);
		palyerVScompter.setColumns(10);

		
		/* define the size, location and functions of the begin button */
		beginFunction.setBounds(350, 150, 100, 100);
		frame.getContentPane().add(beginFunction);
		beginFunction.setVisible(false);
		beginFunction.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent anEvent){
				String player_1=firstPlayerNameInput.getText().trim();
				String player_2=secondPlayerNameInput.getText().trim();
				String player=palyerVScompter.getText().trim();
				if(player_1.equals("")){
					if(player.equals("")){
						new JOptionPane();
						JOptionPane.showMessageDialog(null,"Error - Wrong input");
					}
					else{
						new game(new Player(player),new Player("computer"));
						frame.setVisible(false);
					}
				}
				else{
					if(player_2.equals("")){
						new JOptionPane();
						JOptionPane.showMessageDialog(null,"Error - Wrong input");
					}
					else{
						new game(new Player(player_1),new Player(player_2));
						frame.setVisible(false);
					}
				}
			}
		});
		
		
		
		/* set the size and location of the back button */
		goBackFunction.setBounds(350, 300, 100, 50);
		frame.getContentPane().add(goBackFunction);
                /*set the interface after clicking the back button, so it returns back to homepage */
		goBackFunction.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent anEvent){
				twoPlayersFunction.setVisible(true);
				vsComputerFunction.setVisible(true);
				playerNameLabel.setVisible(false);
				beginFunction.setVisible(false);
				goBackFunction.setVisible(false);
				firstPlayerNameInput.setVisible(false);
				secondPlayerNameInput.setVisible(false);
				palyerVScompter.setVisible(false);
				firstPlayerName.setVisible(false);
				secondPlayerName.setVisible(false);
				seeRankingFunction.setVisible(true);
                                develop.setVisible(true);
                                gp.setVisible(true);
                                jy.setVisible(true);
                                logo.setVisible(true);
			}
		});
                
                
                /* set the size and location of the ranking button */
                seeRankingFunction.setBounds(110, 270, 250, 25);
		frame.getContentPane().add(seeRankingFunction);
		secondPlayerNameInput.setVisible(false);
		goBackFunction.setVisible(false);
                /*function of the ranking button */
		seeRankingFunction.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent anEvent){
				try{
					File file=new File("Rank.txt");
					InputStreamReader read = new InputStreamReader(
		                    new FileInputStream(file));
					BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    List<Player> people=new ArrayList<Player>();
                 Comparator<Player> comparator = new Comparator<Player>(){  
                    	public int compare(Player s1, Player s2) {  
                    	     return s2.getscore()-s1.getscore();   
                    	}
                    };
                    while((lineTxt = bufferedReader.readLine()) != null){
                        String[] x=lineTxt.split(" ");
                        people.add(new Player(x[0],Integer.parseInt(x[1])));
                    }
                    
                    /* to rank the records */
                    Collections.sort(people,comparator);
                    String[] title = {"Name","Score"};
                    Object[][] info=new Object[people.size()][6];
                    for(int i=0;i<people.size();i++){
                    	info[i][0]=people.get(i).getName();
                    	info[i][1]=people.get(i).getscore();
                    }
                    JTable table=new JTable(info,title);
                    JFrame frame_1=new JFrame();
                    JScrollPane scpDemo;
                    frame_1.setSize(330,400);
                    frame_1.setLayout(null);
                    frame_1.setLocation(100,50);
                    scpDemo=new JScrollPane();
                    scpDemo.setBounds(10,50,300,270);
                    frame_1.add(scpDemo);
                    scpDemo.getViewport().add(table);
                    frame_1.setVisible(true);
                    bufferedReader.close();
                    read.close();
				}
		catch(Exception ex){
                System.out.println("Error");
				 }
			}
		});
		
		frame.setBounds(0, 0, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
