/**
 * Project: springboot-parent-pom
 * File created at 2019/4/23 11:42
 */
package zero.springboot.study.rabbitmq.direct;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import zero.springboot.study.rabbitmq.model.User;

import java.io.IOException;

/**
 * 监听hello队列
 *
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
    public void processUser(User user, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("收到消息：{}", user);
        // 手动ACK
        try {
//            //消息确认
            channel.basicAck(tag, false);
            //否认消息，重新入队列然后一直重新消费
//            channel.basicNack(tag, false, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
