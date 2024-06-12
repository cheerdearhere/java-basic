package step05_designPatterns.builder;

import java.util.stream.Stream;

public class UseStreamBuilder {
    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> names = builder
                .add("kim")
                .add("hong")
                .add("chang")
                .build();
        names.forEach(System.out::println);
        Stream<Integer> scoreStream = Stream.<Integer>builder().add(100).add(23).add(70).build();
    }
}
