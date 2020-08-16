package Questions;

import java.util.ArrayList;
import java.util.List;

public class questionList {
	public List<question> questions=new ArrayList<question>();
	public void setQuestions(){
    question Q1=new question("The inventor of the first disposable chopsticks is :\n", 
                        " Japanese\n", 
                        " Chinese\n", 
                        " Korean\n", 
                        " Malaysian",
                        'A');
    question Q2=new question("In a thunderstorm, can you see the lightning or hear the thunder first?\n" ,
                     " see the lightning first\n", 
                     " hear the thunder first\n", 
                     " both at the same time\n", 
                     " depending on the size of the storm",
                     'A');
    question Q3=new question("What is the capital city of Australia?\n" ,
                     " Sydney\n" ,
                     " Canberra\n" ,
                     " Melbourne\n" ,
                     " Perth",
                     'B');
    question Q4=new question("What is the capital city of USA?\n" ,
                     " New York\n" ,
                     " Washington\n" ,
                     " Los Angeles\n" ,
                     " San Francisco",
                     'B');
    question Q5=new question("What is the capital city of Italy?\n" ,
                     " Milan\n" ,
                     " Venice\n" ,
                     " Rome\n" ,
                     " Florence",
                     'C');
    question Q6=new question("The maximum temperature of the inner core of the Earth is :\n" ,
                     " between 3000 to 4000 degree Celsius\n" ,
                     " between 4000 to 5000 degree Celsius\n" ,
                     " between 5000 to 6000 degree Celsius\n" ,
                     " between 6000 to 7000 degree Celsius",
                     'C');
    question Q7=new question("How long does it take to boil a litre of water in the universe?\n" ,
                     " Instantly\n" ,
                     " about 10 minutes\n" ,
                     " about 10 hours\n" ,
                     " forever",
                     'D');
    questions.add(Q1);
    questions.add(Q2);
    questions.add(Q3);
    questions.add(Q4);
    questions.add(Q5);
    questions.add(Q6);
    questions.add(Q7);
	}
}
