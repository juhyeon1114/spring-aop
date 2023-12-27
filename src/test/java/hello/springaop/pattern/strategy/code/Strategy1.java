package hello.springaop.pattern.strategy.code;

public class Strategy1 implements Strategy{
    @Override
    public void run() {
        System.out.println("전략1, 로직 실행");
    }
}
