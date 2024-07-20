package step05_designPatterns.template.after_template_method;

public class MultiPleProcessor extends FileProcessor {

    public MultiPleProcessor(String path) {
        super(path);
    }
    @Override
    public int setResult(int result, int line) {
        return result *= line;
    }
}
