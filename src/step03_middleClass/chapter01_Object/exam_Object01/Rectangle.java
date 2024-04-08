package step03_middleClass.chapter01_Object.exam_Object01;

import java.util.Objects;

public class Rectangle {
    private Integer width;
    private Integer height;
    
    public Rectangle(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Retangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(width, rectangle.width) && Objects.equals(height, rectangle.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
