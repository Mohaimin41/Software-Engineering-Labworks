import java.util.List;

public class Examinee extends Component {
    private String studentID;
    private ExamResultData examResultData;

    public Examinee(Mediator controller, String studentID) {
        super(controller);
        this.studentID = studentID;
    }

    @Override
    void sendAllResult() {
    }

    @Override
    void resultChanged() {
    }

    @Override
    void requestReexamination() {
        System.out.println("Reexamine request sent from student id " + studentID);
        controller.notify(this, "Reexamination", examResultData);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    @Override
    ExamResultData getExamResultData() {
        return examResultData;
    }

    @Override
    public void setExamResultData(ExamResultData examResultData) {
        this.examResultData = examResultData;
        System.out.println("Student " + studentID + " recieved result : ");
        System.out.println(examResultData);
        for (int j = 0; j < 80; j++) {
            System.out.print("=");
        }
        System.out.println("");
    }

    @Override
    List<ExamResultData> getExamPackage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    void doReexamination(ExamResultData examResultData) {
        // TODO Auto-generated method stub
        
    }

}
