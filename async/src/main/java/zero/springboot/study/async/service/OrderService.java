/**
 * Project: springboot-parent-pom
 * File created at 2019/5/16 19:53
 */
package zero.springboot.study.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lijianqing
 * @version 1.0
 * @ClassName OrderService
 * @date 2019/5/16 19:53
 */
@Slf4j
@Service
public class OrderService {

    @Autowired
    private AsyncTask asyncTask;

    public void doShop() {
        try {
            createOrder();
            asyncTask.pay();
            asyncTask.sendSms();
        } catch (InterruptedException e) {
            log.error("异常", e);
        }
    }

    public void createOrder() {
        log.info("开始做任务1：下单成功");
    }
}
