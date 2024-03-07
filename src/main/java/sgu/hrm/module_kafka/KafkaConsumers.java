package sgu.hrm.module_kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@Component
public class KafkaConsumers {
    private final Logger log = LoggerFactory.getLogger(KafkaConsumers.class);
    final JavaMailSender javaMailSender;
    final List<String> topics = List.of("send_mail");
    private final Properties propertiesConsumer = new Properties();

    public KafkaConsumers(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public boolean sendMailConsumer() {
        // create Consumer properties
        propertiesConsumer.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.bootstrapServers);
        propertiesConsumer.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        propertiesConsumer.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ReqTaiKhoan.ReqTaiKhoanDeserializer.class.getName());
        propertiesConsumer.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my-first-server");
        propertiesConsumer.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        // create consumer
        try (KafkaConsumer<String, ReqTaiKhoan> consumer = new KafkaConsumer<>(propertiesConsumer)) {
//            // subscribe consumer to our topic(s)
            consumer.subscribe(Collections.singletonList(topics.get(0)));
            // poll for new data
            boolean flag = false;
            ReqTaiKhoan tk = null;
            while (!flag) {
                ConsumerRecords<String, ReqTaiKhoan> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, ReqTaiKhoan> record : records) {
                    log.info("Last Key: " + record.key() + ", Last Value: " + record.value());
                    log.info("Last Partition: " + record.partition() + ",Last Offset:" + record.offset());
                    long offSet = record.offset();
                    if (offSet > 0) {
                        tk = record.value();
                        flag = true;
                        consumer.close();
                    }
                }
            }
            System.out.println(tk.soCCCD());
            return flag;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
