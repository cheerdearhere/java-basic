package step05_designPatterns.interpreter.after;

import java.util.Stack;

public class PostfixParser {
    public static PostfixNotation parse(String expression) {
        Stack<PostfixNotation> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            stack.push(getExpression(c,stack));
        }
        return stack.pop();
    }

    private static PostfixNotation getExpression(char c, Stack<PostfixNotation> stack) {
        switch (c) {
            case '+': return new PlusExpression(stack.pop(),stack.pop());
            case '-':
                PostfixNotation right = stack.pop();
                PostfixNotation left = stack.pop();
                return new MinusExpression(left, right);
            default:
                return new VariableExpression(c);
        }
    }
}
