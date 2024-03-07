package sgu.hrm.module_kafka;

public class KafkaService {
    final KafkaConsumers consumers;

    public KafkaService(KafkaConsumers consumers) {
        this.consumers = consumers;
    }
}
