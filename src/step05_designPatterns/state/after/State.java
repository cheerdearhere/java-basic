package step05_designPatterns.state.after;


public interface State {
    void addReview(String review, Student student);
    void addStudent(Student student);
}
