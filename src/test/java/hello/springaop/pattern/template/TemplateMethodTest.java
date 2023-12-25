package hello.springaop.pattern.template;

import hello.springaop.pattern.template.code.AbstractTemplate;
import hello.springaop.pattern.template.code.SomeClass1;
import hello.springaop.pattern.template.code.SomeClass2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TemplateMethodTest {

    @Test
    @DisplayName("templateMethod")
    public void templateMethod() throws Exception {
        SomeClass1 someClass1 = new SomeClass1();
        SomeClass2 someClass2 = new SomeClass2();
        AbstractTemplate someClass3 = new AbstractTemplate() {
            @Override
            protected void run() {
                System.out.println("Good morning");
            }
        };

        someClass1.execute();
        someClass2.execute();
        someClass3.execute();
    }
    
}
