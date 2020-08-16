package MainStructure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import Player. Player;
import Questions.questionList;
import java.awt.Toolkit;

public class game {

	private JFrame frame;
	private Player Player_1,Player_2;
	private int state;
	private questionList Questions;

	/*Create the application. */
        
	public game(Player Player_1,Player Player_2) {
		this.Player_1=Player_1;
		this.Player_2=Player_2;
		state=0;
		Questions=new questionList();
		Questions.setQuestions();
		initialise();
	}

	/**Initialise the contents of the frame.*/

	private void initialise() {
		frame = new JFrame();
		frame.setBounds(0,0,500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\MainStructure\\UCLIcon.jpg"));
                /* creat buttons for cheating and skipping */
                
		JButton cheatFunction = new JButton("Cheat");
		JButton skipFunction = new JButton("Skip");
		
		JLabel question = new JLabel(Questions.questions.get(0).getque());
		question.setBounds(50, 50, 450, 20);
		frame.getContentPane().add(question);
		
                /** define A,B,C,D for the four answers
                 * set the spacing between each answer to be 300*/
                
		JRadioButton A = new JRadioButton("A:"+Questions.questions.get(0).getansA());
		A.setBounds(50, 100, 400, 20);
		frame.getContentPane().add(A);
		
		JRadioButton B = new JRadioButton("B:"+Questions.questions.get(0).getansB());
		B.setBounds(50, 130, 400, 20);
		frame.getContentPane().add(B);
		
		JRadioButton C = new JRadioButton("C:"+Questions.questions.get(0).getansC());
		C.setBounds(50, 160, 400, 20);
		frame.getContentPane().add(C);
		
		JRadioButton D = new JRadioButton("D:"+Questions.questions.get(0).getansD());
		D.setBounds(50, 190, 400, 20);
		frame.getContentPane().add(D);
		
		ButtonGroup group = new ButtonGroup();
		group.add(A);
		group.add(B);
		group.add(C);
		group.add(D);
		
		JLabel player1 = new JLabel(Player_1.getName());
		player1.setBounds(50, 300, 90, 30);
		frame.getContentPane().add(player1);
		
                
                /*creat a botton for moving to the next question 
                * set the size and location of the cheat button */
                
		JButton nextFunction = new JButton("Next");
		nextFunction.setBounds(150, 300, 90, 30);
		frame.getContentPane().add(nextFunction);
		nextFunction.addActionListener(new ActionListener(){
                                                                    
                                                /* Error - when no answer is selected */

			public void actionPerformed(ActionEvent error){
				if(!A.isSelected() && !B.isSelected() && !C.isSelected() && !D.isSelected()){
						new JOptionPane();
						JOptionPane.showMessageDialog(null,"Input Is Null");
				}
				else{
					if(A.isSelected()){
						if(Questions.questions.get(state/2).getAnswer()=='A'){
							if(state%2==0) Player_1.incscore();
							else Player_2.incscore();
						}
					}
					else if(B.isSelected()){
						if(Questions.questions.get(state/2).getAnswer()=='B'){
							if(state%2==0) Player_1.incscore();
							else Player_2.incscore();
						}
					}
					else if(C.isSelected()){
						if(Questions.questions.get(state/2).getAnswer()=='C'){
							if(state%2==0) Player_1.incscore();
							else Player_2.incscore();
						}
					}
					else{
						if(Questions.questions.get(state/2).getAnswer()=='D'){
							if(state%2==0) Player_1.incscore();
							else Player_2.incscore();
						}
					}
					state++;
				
				/* when state is 14, and it is greater than 13, it means all 7 questions are answered ( 14/2 = 7) */
                                
				if(state>13){
					new Result(Player_1,Player_2);
					frame.setVisible(false);
				}
				else{
					if(Player_2.getName().equals("computer")){
                                            
                                            /* create a code for computer's answer 
                                               the computer has 25% chance to get the correct answer */
                                            
						if(state%2==1){
							final int NumOfOption = 4;
							int ans = (int) ( Math.random()* NumOfOption + 1);
                                                    switch (ans) {
                                                        case 1:
                                                            if(Questions.questions.get(state/2).getAnswer()=='A') Player_2.incscore();
                                                            break;
                                                        case 2:
                                                            if(Questions.questions.get(state/2).getAnswer()=='B') Player_2.incscore();
                                                            break;
                                                        case 3:
                                                            if(Questions.questions.get(state/2).getAnswer()=='C') Player_2.incscore();
                                                            break;
                                                        default:
                                                            if(Questions.questions.get(state/2).getAnswer()=='D') Player_2.incscore();
                                                            break;
                                                    }
						}
						state++;
						if(state>13){
							new Result(Player_1,Player_2);
							frame.setVisible(false);
						}
						else{
							question.setText(Questions.questions.get(state/2).getque());
							A.setText("A:"+Questions.questions.get(state/2).getansA());
							B.setText("B:"+Questions.questions.get(state/2).getansB());
							C.setText("C:"+Questions.questions.get(state/2).getansC());
							D.setText("D:"+Questions.questions.get(state/2).getansD());
							player1.setText(Player_1.getName());
						}
						
					}
					question.setText(Questions.questions.get(state/2).getque());
					A.setText("A:"+Questions.questions.get(state/2).getansA());
					B.setText("B:"+Questions.questions.get(state/2).getansB());
					C.setText("C:"+Questions.questions.get(state/2).getansC());
					D.setText("D:"+Questions.questions.get(state/2).getansD());
					if(state%2==0) player1.setText(Player_1.getName());
					else{
						player1.setText(Player_2.getName());
					}
				}
				}
				
				
			}
			
		});
                
                /* set the size and location of the cheat button */
		cheatFunction.setBounds(250, 300, 90, 30);
		frame.getContentPane().add(cheatFunction);
		cheatFunction.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				player1.setText("answer:"+Questions.questions.get(state/2).getAnswer());
				cheatFunction.setVisible(false);
				nextFunction.setVisible(false);
				
			}
		});
                /* set the size and location of the skip button */
		skipFunction.setBounds(350, 300, 90, 30);
		frame.getContentPane().add(skipFunction);
		skipFunction.setVisible(true);
                
                /* define skip function */
		skipFunction.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				state++;
				if(state>13){
					new Result(Player_1,Player_2);
					frame.setVisible(false);
				}
				else{
					if(Player_2.getName().equals("computer")){
						if(state%2==1){
							final int NumOfOption = 4;
							int ans = (int) ( Math.random()* NumOfOption + 1);
                                                    switch (ans) {
                                                        case 1:
                                                            if(Questions.questions.get(state/2).getAnswer()=='A') Player_2.incscore();
                                                            break;
                                                        case 2:
                                                            if(Questions.questions.get(state/2).getAnswer()=='B') Player_2.incscore();
                                                            break;
                                                        case 3:
                                                            if(Questions.questions.get(state/2).getAnswer()=='C') Player_2.incscore();
                                                            break;
                                                        default:
                                                            if(Questions.questions.get(state/2).getAnswer()=='D') Player_2.incscore();
                                                            break;
                                                    }
						}
						state++;
						if(state>13){
							new Result(Player_1,Player_2);
							frame.setVisible(false);
						}
						else{
							question.setText(Questions.questions.get(state/2).getque());
							A.setText("A:"+Questions.questions.get(state/2).getansA());
							B.setText("B:"+Questions.questions.get(state/2).getansB());
							C.setText("C:"+Questions.questions.get(state/2).getansC());
							D.setText("D:"+Questions.questions.get(state/2).getansD());
							player1.setText(Player_1.getName());
						}
						
					}
					question.setText(Questions.questions.get(state/2).getque());
					A.setText("A:"+Questions.questions.get(state/2).getansA());
					B.setText("B:"+Questions.questions.get(state/2).getansB());
					C.setText("C:"+Questions.questions.get(state/2).getansC());
					D.setText("D:"+Questions.questions.get(state/2).getansD());
					if(state%2==0) player1.setText(Player_1.getName());
					else{
						player1.setText(Player_2.getName());
					}
				}
				skipFunction.setVisible(true);
				nextFunction.setVisible(true);
				cheatFunction.setVisible(true);
			}
		});
		frame.setVisible(true);
	}

}


