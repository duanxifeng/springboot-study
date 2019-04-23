/**
 * Project: springboot-parent-pom
 * File created at 2019/4/23 11:42
 */
package zero.springboot.study.rabbitmq.direct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import zero.springboot.study.rabbitmq.model.User;

/**
 * 监听hello队列
 * @author lijianqing
 * @version 1.0
 * @ClassName HelloReceiver
 * @date 2019/4/23 11:42
 */
@Component
@RabbitListener(queues = "hello")
@Slf4j
public class HelloReceiver {

    @RabbitHandler
    public void processUser(User user) {
        log.info("收到消息：{}", user);
    }
}
