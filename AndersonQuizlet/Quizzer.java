import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/** Quizzer class asks the user how many questions they would like, tells the user if the answer is correct or incorrect
 *  Gives the user the scores in percentages as well is num out of questionCount
 *  Prints all the questions randomly and will not repeat
 * @author ryana
 */
public class Quizzer {

    public Quizzer() {
    }
    public int quiz(ArrayList<Question> questions, int askedQuestions) {
        int countCorrect = 0;                                        
        boolean[] questionsSeen = new boolean[questions.size()];       // questionsSeen is a boolean that finds whether a questions was printed or not to not repeat any questions
        Random rand = new Random();                         
        Scanner scan = new Scanner(System.in);
        if(askedQuestions <= questions.size()) {                           // askedQuestions is the total amount of questions
            for(int i = 0 ; i < askedQuestions ; i++) {
                while(true) {
                    int q = rand.nextInt(questions.size());             // q is a random number generator that picks a questions in the questions array list
                    if(!questionsSeen[q]) {
                        questionsSeen[q] = true;
                        Question question = questions.get(q);
                        System.out.println(question);
                        System.out.print("Enter the letter of your choice: ");    // user picks their answer
                        String choice = scan.nextLine();
                        if(choice.equalsIgnoreCase(question.getAnswer())) {
                            System.out.println("Congratulations! That is correct");     // tells the user if the answer was correct and if it was it will add it to the count correct
                            countCorrect++;
                        }
                        else {
                            System.out.println("Sorry. The correct answer was (" + question.getAnswer() + ") " + question.getAnswerText());  // prints the correct answer letter and description if user gets it wrong
                            System.out.println();
                        }
                        break;
                    }

                }
            } 
            double percentage = 100.00 * countCorrect / askedQuestions;           // calculates the percentage the user gets correct
            System.out.printf("You got %s out of %s, for percent score of %.2f\n", countCorrect, askedQuestions, percentage);  // prints out the scores correctly
        }
        else {
            System.out.println("All questions asked.");                             // if all questions have been seen the program prints out all questions have been asked. 
        }
        return countCorrect;
    }
}
