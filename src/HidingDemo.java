class Parent {
    public static void hello() {
        System.out.println("Parent static");
    }

    public void greet() {
        System.out.println("Parent instance");
    }
}

class Child extends Parent {
    public static void hello() {
        System.out.println("Child static");
    }

    @Override
    public void greet() {
        System.out.println("Child instance");
    }
}

public class HidingDemo {
    public static void main(String[] args) {
        Parent p = new Child();
        p.hello();
        p.greet();

        Child c = new Child();
        c.hello();
    }
}