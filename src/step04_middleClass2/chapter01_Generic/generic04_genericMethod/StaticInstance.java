package step04_middleClass2.chapter01_Generic.generic04_genericMethod;

public class StaticInstance<T> {
    //instance generic method: instance: instance method 자체에 generic 적용
    <U> U instanceGenericMethod(U u){
        return u;
    }
    //instance method using generic type's: instance method에서 class의 generic 사용
    <U> U instanceMethod(U u){
        return u;
    }
    //static generic method : static method 자체에 generic 적용
    static <U> U staticGenericMethod(U u){
        return u;
    }
    //static method using generic type's: static method에서 class의 generic 사용
//    static T staticMethod(T t){//compiler error
//        return t;
//    }
}
