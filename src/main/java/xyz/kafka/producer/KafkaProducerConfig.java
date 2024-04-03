package xyz.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Duration;
import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class KafkaProducerConfig {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private final LocalDateTime startTime = LocalDateTime.now();

    @Scheduled(fixedRate = 10000)
    public void sendMessage() {
        // 현재 시간과 시작 시간의 차이를 계산
        Duration duration = Duration.between(startTime, LocalDateTime.now());

        // 30분이 지났는지 확인
        if (duration.toMinutes() < 30) {
            String message = "Test Message " + LocalDateTime.now();
            kafkaTemplate.send(topicName, message);
            System.out.println("Produced message: " + message);
        } else {
            // 30분이 지나면 스케줄러 중단
            // 추가적인 로직 없음. 필요하다면 여기에 중단 로직을 구현할 수 있습니다.
            System.out.println("30 minutes have passed. Stopping message production.");
            // 이 부분은 실제로 스케줄러를 중단하지 않습니다.
        }
    }
}
