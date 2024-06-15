package step05_designPatterns.composite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaSwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JTextField textField = new JTextField();//텍스트 공간 지정
        textField.setBounds(200,200,200,40);
        frame.add(textField);

        JButton button = new JButton("Click Me");//버튼 공간 지정
        button.setBounds(200,100,60,40);
        button.addActionListener(new ActionListener() {//이벤트 처리
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Hi I'm Swing");
            }
        });
        frame.add(button);

        frame.setSize(600,400);//전체 프레임 크기 지정
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
