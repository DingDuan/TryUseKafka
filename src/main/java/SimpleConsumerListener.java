import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

//创建一个一个用于消息监听的类，当名为”topic-test”的topic接收到消息之后，我们的这个listen方法就会调用
public class SimpleConsumerListener {
    private final static Logger logger = LoggerFactory.getLogger(SimpleConsumerListener.class);
    private final CountDownLatch latch1 = new CountDownLatch(1);
    @KafkaListener(id = "foo", topics = "topic-test")
    public void listen(String records) {
        //do something here
        System.out.println(records);
         this.latch1.countDown();
    }
}