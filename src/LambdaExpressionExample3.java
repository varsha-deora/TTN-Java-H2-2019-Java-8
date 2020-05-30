public class LambdaExpressionExample3 {
    public static void main(String[] args) {
        Sayana s=()->{
            return "I have nothing to say.";
        };
        System.out.println(s.say());
    }
}
