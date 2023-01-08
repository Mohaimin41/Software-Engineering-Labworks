import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random random = new Random(System.currentTimeMillis());

        System.out.println("Enter total number of students: ");

        int totalStudent = Integer.parseInt(scn.nextLine());

        List<ExamResultData> scripts = new ArrayList<ExamResultData>();
        List<Component> examineeList = new ArrayList<Component>();

        ExamController examController = new ExamController();

        for (int i = 1; i <= totalStudent; i++) {
            scripts.add(new ExamResultData(Integer.toString(i), random.nextInt(101)));
            examineeList.add(new Examinee(examController, Integer.toString(i)));
        }

        examController.setExaminees(examineeList);
        Component examiner = new Examiner(examController, scripts);
        examController.setExaminer(examiner);
        
        //examiner sends script
        examiner.sendAllResult();

        //controller does mistake correction and publishes to students

        //reexam request
        System.out.println("Enter which student's script to reexamine: ");
        Component temp = examineeList.get(Integer.parseInt(scn.nextLine()) - 1);
        temp.requestReexamination();
        //
        scn.close();
    }
}
