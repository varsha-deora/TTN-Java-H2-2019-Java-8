import java.lang.annotation.*;

@Inherited //for annotation to be used in child classes
@Target(ElementType.TYPE) //meta-annotations to specify the scope and the target
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{
 String os() default "Symbian";
 int version();
}

@SmartPhone(os="Android",version = 5)
class Nokia{
    String model;
    int size;

    public Nokia(String model, int size) {
        this.model = model;
        this.size = size;
    }
}

class NASeries extends Nokia{

    public NASeries(String model, int size) {
        super(model, size);
    }
}

public class CustomAnnotation {
    public static void main(String[] args) {
        Nokia nokia=new Nokia("AA",1);
        Class c=nokia.getClass();
        Annotation an=c.getAnnotation(SmartPhone.class);
        SmartPhone s=(SmartPhone)an;
        System.out.println(s.os()+" "+s.version());
    }
}
