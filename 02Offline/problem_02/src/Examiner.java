import java.util.List;
import java.util.Random;

public class Examiner extends Component {
    private List<ExamResultData> examPackage;
    private ExamResultData reexaminedScript;

    public Examiner(Mediator controller, List<ExamResultData> scripts) {
        super(controller);
        this.examPackage = scripts;
    }

    @Override
    void sendAllResult() {
        System.out.print("Scripts and marks of student id ");
        for (int i = 0; i < examPackage.size(); i++) {
            System.out.print(i + 1);
            if (i < examPackage.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.print(" sent to exam controller office.\n");

        controller.notify(this, "All result sent", null);
    }

    @Override
    void resultChanged() {
        controller.notify(this, "Result Changed", reexaminedScript);
    }

    @Override
    void requestReexamination() {
    }

    @Override
    List<ExamResultData> getExamPackage() {
        return examPackage;
    }
    
    void resultUnchanged() {
        controller.notify(this, "Result Unchanged", reexaminedScript);
    }

    public void setExamPackage(List<ExamResultData> examPackage) {
        this.examPackage = examPackage;
    }

    public ExamResultData getReexaminedScript() {
        return reexaminedScript;
    }

    public void setReexaminedScript(ExamResultData reexaminedScript) {
        this.reexaminedScript = reexaminedScript;
    }

    public void doReexamination(ExamResultData examResultData) {
        System.out.println(
                "Reexamine request recieved from student ID: " + examResultData.getStudentID() + " by examiner. Recieved data: ");
        // result randomly changed
        this.reexaminedScript = examResultData;
        System.out.println(reexaminedScript);

        Random random = new Random(System.currentTimeMillis());
        if (random.nextDouble() > 0.5) {
            reexaminedScript.setMarks(random.nextInt(101));
            resultChanged();
        } else {
            resultUnchanged();
        }
        
    }

    @Override
    ExamResultData getExamResultData() {
        return null;
    }

    @Override
    void setExamResultData(ExamResultData examResultData) {
        // TODO Auto-generated method stub

    }
}
