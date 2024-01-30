package step02_basic.chapter03_oop.ex.oop1Question;

public class Rectangle {
    int width;
    int height;

    void setRectangle(int width, int height){
        this.width = width;
        this.height = height;
        System.out.println("세팅 완료: \n   높이: "+height+"/ 너비: "+width);
    }
    int calculateArea(){
        return width*height;
    }
    int  calculatePerimeter(){
        return 2*(width+height);
    }
    boolean isSquare(){
        return width == height;
    }

}
