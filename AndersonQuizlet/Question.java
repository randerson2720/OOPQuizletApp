import java.util.LinkedHashMap;
import java.util.Map;

/** Question creates the hashmap for the questions along with the choices
 * Contains constructors and all getters and setters
 * Uses a string builder to print the questions with choices correctly to the console
 * @author ryana
 */

public class Question {
    
    private  LinkedHashMap<String, String> choices;     
    private String answer;
    private String question;

    public Question() {
        choices = new LinkedHashMap<>();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void addChoice(String letter, String description) {
        choices.put(letter, description);
    }

    public String getAnswerText() {
        return choices.get(answer);
    }

   @Override
   public String toString() {
        StringBuilder printQuestions = new StringBuilder();
        printQuestions.append(question);
        printQuestions.append("\n");
        for(Map.Entry<String, String> entry : choices.entrySet()) {
            printQuestions.append(entry.getKey());
            printQuestions.append("\t");
            printQuestions.append(entry.getValue());
            printQuestions.append("\n");
        }
        return printQuestions.toString();
    } 
    
}



