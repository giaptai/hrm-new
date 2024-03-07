package sgu.hrm.module_kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;

import java.util.Properties;

@Component
public class KafkaProducers {
    private final Properties propertiesProducer = new Properties();
    public void sendMailProducer(ReqTaiKhoan tk) {
        // create Producer properties
        propertiesProducer.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.bootstrapServers);
        propertiesProducer.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        propertiesProducer.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ReqTaiKhoan.ReqTaiKhoanSerializer.class.getName());
        try (KafkaProducer<String, ReqTaiKhoan> producer = new KafkaProducer<>(propertiesProducer)) {
            // create the producer
            ProducerRecord<String, ReqTaiKhoan> producerRecord = new ProducerRecord<>("send_mail", tk);
            // send data - asynchronous
            producer.send(producerRecord);
            //flush + close
            producer.flush();
            producer.close();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
