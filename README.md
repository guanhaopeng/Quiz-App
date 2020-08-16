# Quiz-App

## Description 
For this project, we designed a quiz application for interesting facts challenge. The player can enjoy the both battling with friends or battling with a computer. Moreover, the player can save their score in the ranking list to compare with another player’s score. During the challenge, players will be asked to answer seven questions and will acquire one score for answering every question correctly. There is a cheat function in the application which the player can use to see the correct answer. There is also a skip function which the player can use to skip the questions that they do not want to answer. However, the player cannot answer the question again after using the cheat function and they must skip the questions, hence they cannot get any score for the questions that used the cheat function or skip function.


## UML Diagram    

![Image of UML](https://raw.githubusercontent.com/guanhaopeng/Quiz-App/master/UML.png)

The diagram indicates the variables and the methods that we used in each class. From the diagram, we can notice that the main package is the ‘QuizProject’ and three classes sever the main project which is Main, game and Result. Game class is a big class, lots of class sever it in other package. Moreover, the player class sever all the other class except the questionList. The questionList class merely sever the questions class.

## Data and Question Storing
Firstly, we created an array list for the question which is named questions. In addition, we wrote down seven different questions name Q1 to Q7. Then we added it to the empty array list by using the add function.
For the player name, in the ‘Player’ class, we used String to store the names. When the players type their name into the text field then their names will be stored into the String ‘Name’ variable. The players’ scores will be stored in a text file after every game. In the ‘Result’ class, through using the ‘getName’ method, their name will be presented on the ranking list. Besides that, we call the ‘getName’ method in the game class to print the name in the left side corner. 
Eventually, in the Player class, we defined an integer as ‘score’ and utilizing two various methods. The first one is incscore which is used to increase the score when the player gets the correct answer, the another one is ‘getscore’ which will return the current score value. Therefore, we can get the players’ scores by calling the ‘getscore’ method in the Result class.



## Testing and Error Handling
We tested our application in the NetBeans IDE 8.2. Firstly, we checked the name and score store sections when the players are choosing the answer their names should be presented in the left bottom corner. Secondly, once they finish the quiz, the name should be stored in the ranking list. Next, we checked if the ‘incscore’ method is working properly. Consequently, we try to get one correct answer to seven correct answer to ensure the score increasing step by step. Then, the cheat function and the skip function should be checked. The cheat function can be tested by just clicking the cheat button to see if the correct answers appear, if they do then the cheat function is working properly. For the skip function, we need to ensure that the total score should not be changed when the skip function is performed.
In the error handling part, when the player forgets to input the name, there will be a window message to tell them to enter their names. Therefore, they cannot go further until they enter their names. Moreover, when the players do not choose any answer for the questions, the program will remind them as well, unless they used the Cheat or Skip function. 

