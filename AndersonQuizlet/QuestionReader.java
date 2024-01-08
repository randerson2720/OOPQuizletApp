import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/** QuestionReader reads the file the user selects and puts the questions and answers in the proper variables
 * @author ryana
 */
public class QuestionReader {
    public static ArrayList<Question> readQuestionsFromTextFile(String fileName) {
        ArrayList<Question> questionList = new ArrayList<>();
        Scanner fscan;
        try {
            fscan = new Scanner(new File(fileName));
            Question q = null;
            while(fscan.hasNextLine()) {
                String[] line = fscan.nextLine().strip().split("\t");
              
                if(line[0].equals("q")) {
                    q = new Question();
                    q.setQuestion(line[1]);
                    questionList.add(q);
                }
                else if(line[0].equals("?")) {
                    q.setAnswer(line[1]);
                }
                else {
                    q.addChoice(line[0], line[1]);
                }
            }
            fscan.close();
        } catch (Exception ex) {
            return null;
        }
        return questionList;
    }
}
