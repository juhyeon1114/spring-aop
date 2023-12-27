package hello.springaop.pattern.strategy.code;

public class Strategy2 implements Strategy{
    @Override
    public void run() {
        System.out.println("전략2, 로직 실행");
    }
}
