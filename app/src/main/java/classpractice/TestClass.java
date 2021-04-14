package classpractice;

public class TestClass {

    public static void main(String[] args) {
        System.out.println("testtest");
        SonClass sonClass = new SonClass();
        int i = sonClass.var1;
        sonClass.fun1();
        sonClass.fun2();
        sonClass.ahaha();

        BaseClass baseClass = new SonClass();
        baseClass.fun1();
        baseClass.ahaha();
    }
}
