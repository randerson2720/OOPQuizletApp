import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
/**@author ryana
 * QuetsionPrinter prints the quetsions to the console
 * Prints the questions along with the answers once the user exits the quiz
 * Prints the questions with answers to an xml file once the user exitst the quiz
 */
public class QuestionPrinter {

    public static void printQuestion(Question q) {                     // prints the questions with the choices
        System.out.println(q);
    }

    public static void printQuestionsAndAnswers(ArrayList<Question> questions) {          // prints the questions with the answers
        for(Question q : questions) {
            System.out.println("q:\t" + q.getQuestion());
            String textForAnswer = q.getAnswerText();
            System.out.println(q.getAnswer() + ":" + "\t" + textForAnswer);
            System.out.println();
        }
    }
     public static boolean printQuestionsToXML(ArrayList<Question> questions, String fileName) {      // creates xml file for the questions and answers
        try {
            XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File(fileName))));
            enc.writeObject(questions);
            enc.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
        
    }
    
}


