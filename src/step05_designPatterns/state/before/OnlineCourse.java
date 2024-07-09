package step05_designPatterns.state.before;

import java.util.ArrayList;
import java.util.List;

public class OnlineCourse {
    public void changeState(State state) {
        this.state = state;
    }

    public enum State{
        DRAFT, PUBLISHED, PRIVATE
    }
    private State state = State.DRAFT;
    private List<String> reviews = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public void addReview(String review, Student student) {
        if(this.state == State.PUBLISHED){
            this.reviews.add(review);
        }else if(this.state == State.PRIVATE && this.students.contains(student)){
            this.reviews.add(review);
        }else{
            throw new UnsupportedOperationException("드래프트 state에서는 리뷰를 작성할 수 없습니다.");
        }
    }
    public void addStudent(Student student) {
        if(this.state == State.PUBLISHED || this.state == State.DRAFT){
            this.students.add(student);
        }else if(this.state == State.PRIVATE && this.students.contains(student)){
            this.students.add(student);
        }else{
            throw new UnsupportedOperationException(" 학생을 해당 수업에 추가할 수 없습니다.");
        }
        if(this.students.size() > 1){
            this.state = State.PRIVATE;
        }
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
