package step05_designPatterns.interpreter.after;

import java.util.Map;

public interface PostfixExpression {
    int interpret(Map<Character,Integer> context);
    static PostfixExpression plus(PostfixExpression left, PostfixExpression right) {
        return context -> left.interpret(context) + right.interpret(context);
    }
    static PostfixExpression minus(PostfixExpression left, PostfixExpression right) {
        return context -> left.interpret(context) - right.interpret(context);
    }
    static PostfixExpression multiple(PostfixExpression left, PostfixExpression right) {
        return context -> left.interpret(context) * right.interpret(context);
    }
    static PostfixExpression devide(PostfixExpression left, PostfixExpression right) {
        return context -> left.interpret(context) / right.interpret(context);
    }
    static PostfixExpression modulus(PostfixExpression left, PostfixExpression right) {
        return context -> left.interpret(context) % right.interpret(context);
    }
    static PostfixExpression variable(Character c) {
        return context -> context.get(c);
    }
}
