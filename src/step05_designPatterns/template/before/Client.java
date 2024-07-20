package step05_designPatterns.template.before;

public class Client {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor("number.txt");
        fileProcessor.process();
        String result = fileProcessor.getResult();
        System.out.println(result);
    }
}
