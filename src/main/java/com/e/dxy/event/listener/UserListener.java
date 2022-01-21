package com.e.dxy.event.listener;

import com.e.dxy.event.message.UserMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;


/**
 * <p></p>
 *
 * @author omgzui
 * @date 1/21/22 11:06 AM
 */
@Component
@RocketMQMessageListener(
        topic = UserMessage.TOPIC,
        consumerGroup = "omgzui-group-" + UserMessage.TOPIC
)
@Slf4j
public class UserListener implements RocketMQListener<MessageExt> {


    @Override
    public void onMessage(MessageExt messageExt) {
        String json = new String(messageExt.getBody(), Charset.forName("UTF-8"));

        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), json);
    }
}
