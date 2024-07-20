package step05_designPatterns.template.after_template_method;

public class Client {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new PlusProcessor("number.txt");
        fileProcessor.process();
        String result = fileProcessor.getResult();
        System.out.println(result);
    }
}
