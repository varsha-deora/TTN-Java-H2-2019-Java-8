import java.util.ArrayList;

class A {
    public void keepingMethodNameVeryLongInCaseWeMakeMistake() {
        System.out.println("In A");
    }
}

class B extends A {
    //Method Name is misspelled
    public void keepingMethodNameVeryLongInCaseWeMakemistake() {
        System.out.println("In B");
    }
}

class C extends A {
    @Override
    public void keepingMethodNameVeryLongInCaseWeMakeMistake() {
        System.out.println("In C");
    }
}

class D{
    @Deprecated
    public void myMethod1(){
        ArrayList arrayList=new ArrayList();
    }
}

public class AnnotationDemo {
    public static void main(String[] args) {
        B b = new B();
        b.keepingMethodNameVeryLongInCaseWeMakeMistake();
        //override annotation helps us to identify run time errors
        C c = new C();
        c.keepingMethodNameVeryLongInCaseWeMakeMistake();
        D d=new D();
        d.myMethod1();

    }
}
