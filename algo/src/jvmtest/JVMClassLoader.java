package jvmtest;

/**
 * User: yinkai
 * Date: 2019-12-30
 * Time: 20:01
 */
public class JVMClassLoader {
    public static void main(String[] args) {
        System.out.println(SubClass.value); // 通过子类引用父类的静态变量不会导致子类初始化(只初始化了父类)
    }
}


class SuperClass{

    static {
        System.out.println("super class init!");
    }

    public static int value = 123;

}


class SubClass extends  SuperClass{

    static {
        System.out.println("sub class init!");
    }
}