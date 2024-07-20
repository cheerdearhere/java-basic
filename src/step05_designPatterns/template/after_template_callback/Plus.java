package step05_designPatterns.template.after_template_callback;

public class Plus implements Operator{

    @Override
    public int setResult(int result, int line) {
        return result += line;
    }
}
