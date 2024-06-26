package step05_designPatterns.interpreter.after;

import java.util.Map;

public interface PostfixNotation {
    int interpret(Map<Character,Integer> context);
}
