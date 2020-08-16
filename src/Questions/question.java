package Questions;

public class question {
	private String que,ansA,ansB,ansC,ansD;
	private char answer;
	public question(String que,String ansA,String ansB,String ansC,String ansD,char answer){
		this.que=que;
		this.ansA=ansA;
		this.ansB=ansB;
		this.ansC=ansC;
		this.ansD=ansD;
		this.answer=answer;
	}
	public String getque(){
		return que;
	}
	public String getansA(){
		return ansA;
	}
	public String getansB(){
		return ansB;
	}
	public String getansC(){
		return ansC;
	}
	public String getansD(){
		return ansD;
	}
	public char getAnswer(){
		return answer;
	}
}
