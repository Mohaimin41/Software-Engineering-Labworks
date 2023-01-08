import java.util.List;

public abstract class Component {
    protected Mediator controller;

    public Component(Mediator controller) {
        this.controller = controller;
    }
    abstract List<ExamResultData> getExamPackage();

    abstract ExamResultData getExamResultData();

    abstract void setExamResultData(ExamResultData examResultData);

    abstract void doReexamination(ExamResultData examResultData);
    
    abstract void sendAllResult();

    abstract void resultChanged();

    abstract void requestReexamination();
}
