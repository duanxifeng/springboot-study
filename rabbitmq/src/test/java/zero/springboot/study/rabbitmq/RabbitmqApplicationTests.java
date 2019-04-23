package zero.springboot.study.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zero.springboot.study.rabbitmq.direct.HelloSender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class RabbitmqApplicationTests {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void testDirect(){
        helloSender.send();
    }

}
