package hello.springaop.section4.v2;


public class OrderRepositoryV2 {
    public void save(String itemId) {
        // save logic
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외");
        }
        sleep(1000);
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
