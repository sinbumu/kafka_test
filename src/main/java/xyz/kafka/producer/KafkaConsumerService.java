package xyz.kafka.producer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenGroupFoo(String message, Acknowledgment acknowledgment) {
        System.out.println("Received Message: " + message);
        // 메시지 처리 로직 후
        acknowledgment.acknowledge(); // 수동 커밋
    }

//    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}", batch = "true")
//    public void listenGroupFoo(List<String> messages, Acknowledgment acknowledgment) {
//        System.out.println("Received Messages: " + messages.size());
//        for(String message : messages) {
//            // 각 메시지 처리 로직
//        }
//        acknowledgment.acknowledge(); // 모든 메시지 처리 후 한번에 커밋
//    }
}
