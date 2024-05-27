package step04_middleClass2.chapter02_CollectionFramework.test.set;

import java.util.Objects;

public class Rectangle {
    private int width;
    private int height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getSize(){
        return width * height;
    }
    public int getRound(){
        return (width + height) * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle rectangle)) return false;
        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return String.format("Rectangle [width=%d, height=%d]", width, height);
    }
}
