package step05_designPatterns.interpreter.after;

import java.util.Map;

public class MinusExpression implements PostfixNotation{
    private final PostfixNotation left, right;
    public MinusExpression(PostfixNotation left, PostfixNotation right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Map<Character, Integer> context) {
        return left.interpret(context) - right.interpret(context);
    }
}
