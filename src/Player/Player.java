package Player;

public class Player{
	private String Name;
	private int score;
	public  Player(String Name){
            
            /* set the initial score to be 0 */
            
		this.Name=Name;
		score=0;
	}
	public  Player(String Name,int score){
		this.Name=Name;
		this.score=score;
	}
	public void incscore(){
		score++;
	}
	public int getscore(){
		return score;
	}
	public String getName(){
		return Name;
	}
}
