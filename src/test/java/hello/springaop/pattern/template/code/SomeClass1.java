package hello.springaop.pattern.template.code;

public class SomeClass1 extends AbstractTemplate {
    @Override
    protected void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Hello world");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
