package sgu.hrm.module_kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import sgu.hrm.module_soyeulylich_chitiet.models.NgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResNgoaiNgu;
import sgu.hrm.module_taikhoan.dto.request.ReqTaiKhoan;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@Component
public class KafkaConsumers {
    private final Logger log = LoggerFactory.getLogger(KafkaConsumers.class);
    final JavaMailSender javaMailSender;
    final List<String> topics = List.of("send_mail", "ngoai_ngu", "khen_thuong", "ky_luat");
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

    public List<ResNgoaiNgu> ngoaiNguConsumer() {
        // create Consumer properties
        propertiesConsumer.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.bootstrapServers);
        propertiesConsumer.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        propertiesConsumer.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, NgoaiNgu.NgoaiNguDeserializer.class.getName());
        propertiesConsumer.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my-second-server");
        propertiesConsumer.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        // create consumer
        try (KafkaConsumer<String, List<ResNgoaiNgu>> consumer = new KafkaConsumer<>(propertiesConsumer)) {
//            // subscribe consumer to our topic(s)
            consumer.subscribe(Collections.singletonList(topics.get(1)));
            // poll for new data
            boolean flag = false;
            List<ResNgoaiNgu> tk = new ArrayList<>();
            while (!flag) {
                ConsumerRecords<String, List<ResNgoaiNgu>> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, List<ResNgoaiNgu>> record : records) {
                    log.info("Last Key: " + record.key() + ", Last Value: " + record.value());
                    log.info("Last Partition: " + record.partition() + ",Last Offset:" + record.offset());
                    log.info("Last Time: " + record.timestampType() + ",Last Timestamp:" + record.timestamp());
                    long offSet = record.offset();
                    if (offSet > 0) {
                        tk = record.value();
                        flag = true;
                        consumer.close();
                    }
                }
            }
//            System.out.println(tk.get(0));
            return tk;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public List<ResKhenThuong> khenThuongConsumer() {
        // create Consumer properties
        propertiesConsumer.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.bootstrapServers);
        propertiesConsumer.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        propertiesConsumer.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ResKhenThuong.ResKhenThuongDeserializer.class.getName());
        propertiesConsumer.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my-third-server");
        propertiesConsumer.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        // create consumer
        try (KafkaConsumer<String, List<ResKhenThuong>> consumer = new KafkaConsumer<>(propertiesConsumer)) {
//            // subscribe consumer to our topic(s)
            consumer.subscribe(Collections.singletonList(topics.get(2)));
            // poll for new data
            boolean flag = false;
            List<ResKhenThuong> tk = new ArrayList<>();
            while (!flag) {
                ConsumerRecords<String, List<ResKhenThuong>> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, List<ResKhenThuong>> record : records) {
                    log.info("Last Key: " + record.key() + ", Last Value: " + record.value());
                    log.info("Last Partition: " + record.partition() + ",Last Offset:" + record.offset());
                    log.info("Last Time: " + record.timestampType() + ",Last Timestamp:" + record.timestamp());
                    long offSet = record.offset();
                    if (offSet > 0) {
                        tk = record.value();
                        flag = true;
                        consumer.close();
                    }
                }
            }
//            System.out.println(tk.get(0));
            return tk;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public List<ResKyLuat> kyLuatConsumer() {
        // create Consumer properties
        propertiesConsumer.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.bootstrapServers);
        propertiesConsumer.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        propertiesConsumer.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ResKyLuat.ResKyLuatDeserializer.class.getName());
        propertiesConsumer.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my-fourth-server");
        propertiesConsumer.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        // create consumer
        try (KafkaConsumer<String, List<ResKyLuat>> consumer = new KafkaConsumer<>(propertiesConsumer)) {
//            // subscribe consumer to our topic(s)
            consumer.subscribe(Collections.singletonList(topics.get(3)));
            // poll for new data
            boolean flag = false;
            List<ResKyLuat> tk = new ArrayList<>();
            while (!flag) {
                ConsumerRecords<String, List<ResKyLuat>> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, List<ResKyLuat>> record : records) {
                    log.info("Last Key: " + record.key() + ", Last Value: " + record.value());
                    log.info("Last Partition: " + record.partition() + ",Last Offset:" + record.offset());
                    log.info("Last Time: " + record.timestampType() + ",Last Timestamp:" + record.timestamp());
                    long offSet = record.offset();
                    if (offSet > 0) {
                        tk = record.value();
                        flag = true;
                        consumer.close();
                    }
                }
            }
            System.out.println(tk.get(0));
            return tk;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
