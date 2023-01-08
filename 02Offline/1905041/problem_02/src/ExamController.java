import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Mediator {
    void notify(Component sender, String event, ExamResultData examResultData);
}

public class ExamController implements Mediator {
    private Component examiner;
    private List<Component> examinees;
    private Random random;

    public ExamController() {
        examinees = new ArrayList<Component>();
        random = new Random(System.currentTimeMillis());
    }

    public ExamController(Component examiner, List<Component> examinees) {
        this.examiner = examiner;
        this.examinees = examinees;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void notify(Component sender, String event, ExamResultData examResultData) {
        if (sender.equals(examiner) && event.equalsIgnoreCase("All result sent")) {
            // print all result
            System.out.println("Scripts recieved in exam controller office:");

            for (int i = 0; i < examiner.getExamPackage().size(); i++) {
                System.out.println(examiner.getExamPackage().get(i));
            }
            for (int j = 0; j < 80; j++) {
                System.out.print("=");
            }
            System.out.println("");
            System.out.println("Exam controller checking for mistakes: ");
            // randomly correct mistake
            for (int i = 0; i < examiner.getExamPackage().size(); i++) {
                
                if(random.nextDouble() > 0.5) {
                    //a mistake in this indexed result corrected
                    ExamResultData temp = examiner.getExamPackage().get(i);
                    System.out.println("Correcting mistake in result of Student ID: " +  temp.getStudentID() + ", previous result: ");
                    System.out.println(temp);
                    System.out.print("Corrected result: ");
                    temp.setMarks(random.nextInt(101));
                    System.out.println(temp);
                    //published to that student
                    examinees.get(Integer.parseInt(temp.getStudentID()) - 1).setExamResultData(temp);        
                }
            }
            for (int j = 0; j < 80; j++) {
                System.out.print("=");
            }
            System.out.println("");
            
            // now publish result to all examinee
            for (int i = 0; i < examiner.getExamPackage().size(); i++) {
                ExamResultData temp = examiner.getExamPackage().get(i);
                examinees.get(Integer.parseInt(temp.getStudentID()) - 1).setExamResultData(temp);
            }
            for (int j = 0; j < 80; j++) {
                System.out.print("=");
            }
            System.out.println("");

        } else if (sender.equals(examiner) && event.equalsIgnoreCase("Result Changed")) {
            System.out.println("Result changed for student ID: " + examResultData.getStudentID());
            examinees.get(Integer.parseInt(examResultData.getStudentID()) - 1).setExamResultData(examResultData);

        } else if (sender.equals(examiner) && event.equalsIgnoreCase("Result Unchanged")) {
            System.out.println("Result unchanged for student ID: " + examResultData.getStudentID());
            examinees.get(Integer.parseInt(examResultData.getStudentID()) - 1).setExamResultData(examResultData);

        } else if (!sender.equals(examiner) && event.equalsIgnoreCase("Reexamination")) {
            System.out.println(
                    "Reexamine request recieved from student ID: " + examResultData.getStudentID() + " by exam controller.");
            examiner.doReexamination(examResultData);
        }
    }

    public Component getExaminer() {
        return examiner;
    }

    public void setExaminer(Component examiner) {
        this.examiner = examiner;
    }

    public List<Component> getExaminees() {
        return examinees;
    }

    public void setExaminees(List<Component> examinees) {
        this.examinees = examinees;
    }

}