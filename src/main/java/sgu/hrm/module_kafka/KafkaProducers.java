package sgu.hrm.module_kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;
import sgu.hrm.module_soyeulylich_chitiet.models.NgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.services.ISoYeuLyLichChiTietServices;
import sgu.hrm.module_soyeulylich_chitiet.services.SoYeuLyLichChiTietServices;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_utilities.enums.XacNhan;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Component
public class KafkaProducers implements Runnable{
    private final Properties propertiesProducer = new Properties();
    private final ISoYeuLyLichChiTietServices.INgoaiNguSefvice ngoaiNguService;
    private final ISoYeuLyLichChiTietServices.IKhenThuongSefvice khenThuongSefvice;
    private final ISoYeuLyLichChiTietServices.IKyLuatSefvice kyLuatSefvice;
    public KafkaProducers(SoYeuLyLichChiTietServices.NgoaiNguService ngoaiNguService, ISoYeuLyLichChiTietServices.IKhenThuongSefvice khenThuongSefvice, ISoYeuLyLichChiTietServices.IKyLuatSefvice kyLuatSefvice) {
        this.ngoaiNguService = ngoaiNguService;
        this.khenThuongSefvice = khenThuongSefvice;
        this.kyLuatSefvice = kyLuatSefvice;
        propertiesProducer.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.bootstrapServers);
        propertiesProducer.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    }
    public void sendMailProducer(ReqTaiKhoan tk) {
        // create Producer properties
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

    public void ngoaiNguProducer() {
        // create Producer properties
        propertiesProducer.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, NgoaiNgu.NgoaiNguSerializer.class.getName());
        List<ResNgoaiNgu> ngoaiNgus = ngoaiNguService.xemDanhSachEmployee().stream()
                .filter(ngu -> ngu.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))
                .sorted(Comparator.comparingLong(res -> Math.abs(Duration.between(res.getBatDau(), LocalDateTime.now()).toMillis())))
                .map(ResNgoaiNgu::mapToResNgoaiNgu)
                .toList();
        try (KafkaProducer<String, List<ResNgoaiNgu>> producer = new KafkaProducer<>(propertiesProducer)) {
            // create the producer
            ProducerRecord<String, List<ResNgoaiNgu>> producerRecord = new ProducerRecord<>("ngoai_ngu", ngoaiNgus);
            // send data - asynchronous
            producer.send(producerRecord).get();
            //flush + close
            producer.flush();
            producer.close();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void khenThuongProducer() {
        // create Producer properties
        propertiesProducer.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ResKhenThuong.ResKhenThuongSerializer.class.getName());
        List<ResKhenThuong> khenThuongs = khenThuongSefvice.xemDanhSachEmployee().stream()
                .filter(ngu -> ngu.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))
                .sorted(Comparator.comparingLong(res -> Math.abs(Duration.between(res.getNam(), LocalDateTime.now()).toMillis())))
                .map(ResKhenThuong::maptoResKhenThuong)
                .toList();
        try (KafkaProducer<String, List<ResKhenThuong>> producer = new KafkaProducer<>(propertiesProducer)) {
            // create the producer
            ProducerRecord<String, List<ResKhenThuong>> producerRecord = new ProducerRecord<>("khen_thuong", khenThuongs);
            // send data - asynchronous
            producer.send(producerRecord).get();
            //flush + close
            producer.flush();
            producer.close();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void kyLuatProducer() {
        // create Producer properties
        propertiesProducer.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ResKyLuat.ResKyLuatSerializer.class.getName());
        List<ResKyLuat> kyLuats = kyLuatSefvice.xemDanhSachEmployee().stream()
                .filter(ngu -> ngu.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))
                .sorted(Comparator.comparingLong(res -> Math.abs(Duration.between(res.getBatDau(), LocalDateTime.now()).toMillis())))
                .map(ResKyLuat::mapToResKyLuat)
                .toList();
        try (KafkaProducer<String, List<ResKyLuat>> producer = new KafkaProducer<>(propertiesProducer)) {
            // create the producer
            ProducerRecord<String, List<ResKyLuat>> producerRecord = new ProducerRecord<>("ky_luat", kyLuats);
            // send data - asynchronous
            producer.send(producerRecord).get();
            //flush + close
            producer.flush();
            producer.close();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        this.ngoaiNguProducer();
        this.khenThuongProducer();
        this.kyLuatProducer();

    }
}
