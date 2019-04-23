/**
 * Project: springboot-parent-pom
 * File created at 2019/4/23 11:15
 */
package zero.springboot.study.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注意，发送者和接收者的 queue name 必须一致，不然不能接收.
 *
 * @author lijianqing
 * @version 1.0
 * @ClassName DirectConfig
 * @date 2019/4/23 11:15
 */
@Configuration
public class DirectConfig {

    @Bean
    public Queue queue() {
        return new Queue("hello");
    }
}
