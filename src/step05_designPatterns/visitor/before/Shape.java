package step05_designPatterns.visitor.before;

public interface Shape {
    void printTo(Device device);// 기능추가 > 기존 코드 수정 필수
}
