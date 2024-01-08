import java.util.ArrayList;
import java.util.Scanner;
/**@author ryana
 * OOQuizTool is the main class. Calls other classes to perform their specific functions. 
 * Asks the user the file name along with how many questions they would like
 * also includes a do while loop that will continue the quiz or quit from the user choice
 * 
 */
public class OOQuizTool {
    
    public static void printBanner() {                                                      // prints the quiz banner
        System.out.println("***********************************************************");
        System.out.println("             Object-Oriented Theory Quiz Tool              ");
        System.out.println("***********************************************************");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printBanner();
        System.out.println();
        System.out.print("Enter name of questions file: ");                                         // takes in user file name and if file is found reads the text file
        ArrayList<Question> questions = QuestionReader.readQuestionsFromTextFile(scan.next());
        while (questions == null) {         
            System.out.println();                                                        // if file cannot be read it asks the user to reenter the file name
            System.out.println("Invalid file name"); 
            System.out.println();                                                   
            System.out.print("Enter name of questions file: ");
            questions = QuestionReader.readQuestionsFromTextFile(scan.next());
        }      
        System.out.println();                                                                        
        String choice = null;
        int totalCorrect = 0;
        int finalQuestions = 0;
        do {
            System.out.print("How many questions do you want? ");
            int askedQuestions = Integer.parseInt(scan.next());
            System.out.println();
            finalQuestions += askedQuestions;
            Quizzer q = new Quizzer();
            int countCorrect = q.quiz(questions, askedQuestions);                                   // Quizzer class takes in the questions array list and user input to print the correct amount of questions
            totalCorrect += countCorrect; 
            System.out.println();
            System.out.print("Enter c to continue or q to quit: ");
            choice = scan.next();
            System.out.println();
        }  while (!choice.equalsIgnoreCase("q"));                                                        // if user enters q the program will end
                double percentage = 100.0 * totalCorrect / finalQuestions;                               // calculates the total percentage the user gets on the quiz
                System.out.println("You got " + totalCorrect + " out of " + finalQuestions + ".");  
                System.out.printf("That is good for %.2f percent.\n", percentage);
                System.out.println();
                scan.close();
                System.out.println("Before you go, here are all the questions and answers.");
                QuestionPrinter.printQuestionsAndAnswers(questions);                                     // prints questions and answers to the console
                System.out.println();
                System.out.println("We've also written all the questions to an xml file named questions.xml.");
                System.out.println();
                System.out.println("We hope you feel as smart as we are. Good Bye."); 
                QuestionPrinter.printQuestionsToXML(questions, "questions.xml");                            // calls the QuestionPrinter class and the prints the questions and answers to an xml file titled "questions.xml"
                                  
    
    }
}
