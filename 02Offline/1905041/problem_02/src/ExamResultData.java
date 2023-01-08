public class ExamResultData {
    private String studentID;
    private int marks;

    ExamResultData(String studentID, int marks) {
        this.studentID = studentID;
        this.marks = marks;
    }

    int getMarks() {
        return marks;
    }

    void setMarks(int marks) {
        this.marks = marks;
    }

    String getStudentID() {
        return studentID;
    }

    void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student ID =" + studentID + ", marks =" + marks;
    }

}
