package step05_designPatterns.template.after_template_callback;

import step05_designPatterns.template.after_template_method.PlusProcessor;

public class Client {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor("number.txt");


        System.out.println("####익명클래스####");
        fileProcessor.process(new Operator() {
            @Override
            public int setResult(int result, int line) {
                return result += line;
            }
        });
        String resultMsg = fileProcessor.getResult();
        System.out.println(resultMsg);

        System.out.println("####람다식####");
        fileProcessor.process((result ,line)-> result += line);
        resultMsg = fileProcessor.getResult();
        System.out.println(resultMsg);

        System.out.println("####직접구현####");
        fileProcessor.process(new Plus());
        resultMsg = fileProcessor.getResult();
        System.out.println(resultMsg);
    }
}
