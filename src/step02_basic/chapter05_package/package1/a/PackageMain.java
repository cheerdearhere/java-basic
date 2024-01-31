package step02_basic.chapter05_package.package1.a;

import step02_basic.chapter05_package.package1.a.new2.NewClass;
import step02_basic.chapter05_package.package1.variableClasses.*;

public class PackageMain {
    public static void main(String[] args) {

        SamePackage samePackage = new SamePackage();
        step02_basic.chapter05_package.package1.a.new1.Data data = new step02_basic.chapter05_package.package1.a.new1.Data();
        NewClass useImport = new NewClass();
        UnderClass1 underClass1 = new UnderClass1();
        UnderClass2 underClass2 = new UnderClass2();
        User userA = new User();
        step02_basic.chapter05_package.package1.b.User userB = new step02_basic.chapter05_package.package1.b.User();


    }
}
