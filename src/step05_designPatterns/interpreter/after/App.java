package step05_designPatterns.interpreter.after;



import java.util.Map;

public class App {
    public static void main(String[] args) {
        PostfixNotation expression = PostfixParser.parse("xyz+-");
        int result = expression.interpret(Map.of( 'x',1, 'y',2,'z',3));
        System.out.println(result);
    }
}
