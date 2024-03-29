package sgu.hrm.module_soyeulylich_chitiet.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import sgu.hrm.module_soyeulylich_chitiet.models.LamViecONuocNgoai;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResLamViecONuocNgoai(
        int id,
        UUID maSyll,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String toChucDiaChiCongViec,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResLamViecONuocNgoai mapToResLamViecONuocNgoai(LamViecONuocNgoai ngoai) {
        return ngoai != null ? new ResLamViecONuocNgoai(
                ngoai.getId(),
                ngoai.getSoYeuLyLich().getId(),
                ngoai.getBatDau(),
                ngoai.getKetThuc(),
                ngoai.getToChucDiaChiCongViec(),
                ngoai.getCreate_at(),
                ngoai.getUpdate_at()
        ) : null;
    }

    public static class ResLamViecONuocNgoaiSerializer implements Serializer<ResLamViecONuocNgoai> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, ResLamViecONuocNgoai data) {
            try {
                return data != null ? objectMapper.writeValueAsBytes(data) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }

    public static class ResLamViecONuocNgoaiDeserializer implements Deserializer<ResLamViecONuocNgoai> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public ResLamViecONuocNgoai deserialize(String topic, byte[] data) {
            try {
                return data != null ? objectMapper.readValue(data, ResLamViecONuocNgoai.class) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }
}
