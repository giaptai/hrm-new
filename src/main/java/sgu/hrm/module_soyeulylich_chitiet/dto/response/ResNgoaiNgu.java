package sgu.hrm.module_soyeulylich_chitiet.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import sgu.hrm.module_soyeulylich_chitiet.models.NgoaiNgu;
import sgu.hrm.enums.XacNhan;

import java.time.LocalDateTime;
import java.util.UUID;


public record ResNgoaiNgu(
        int id,
        UUID maSyll,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime batDau,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        int IdTenCoSoDaoTao,
        String tenNgoaiNgu,
        String chungChiDuocCap,
        float diemSo,
        XacNhan xacNhan,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime create_at,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime update_at
) {
    public static ResNgoaiNgu mapToResNgoaiNgu(NgoaiNgu ngu) {
        return ngu != null ? new ResNgoaiNgu(
                ngu.getId(),
                ngu.getSoYeuLyLich().getId(),
                ngu.getBatDau(),
                ngu.getKetThuc(),
                ngu.getTenCoSoDaoTao().getName(),
                ngu.getTenCoSoDaoTao().getId(),
                ngu.getTenNgoaiNgu(),
                ngu.getChungChiDuocCap(),
                ngu.getDiemSo(),
                ngu.getXacNhan(),
                ngu.getCreate_at(),
                ngu.getUpdate_at()
        ) : null;
    }

    public static class ResNgoaiNguSerializer implements Serializer<ResNgoaiNgu> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, ResNgoaiNgu data) {
            try {
                return data != null ? objectMapper.writeValueAsBytes(data) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }

    public static class ResNgoaiNguDeserializer implements Deserializer<ResNgoaiNgu> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public ResNgoaiNgu deserialize(String topic, byte[] data) {
            try {
                return data != null ? objectMapper.readValue(data, ResNgoaiNgu.class) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }
}
