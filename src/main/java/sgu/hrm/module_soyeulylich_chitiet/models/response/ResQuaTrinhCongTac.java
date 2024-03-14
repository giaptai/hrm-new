package sgu.hrm.module_soyeulylich_chitiet.models.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import sgu.hrm.module_soyeulylich_chitiet.models.QuaTrinhCongTac;

import java.time.LocalDateTime;

public record ResQuaTrinhCongTac(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String donViCongTac,
        int IdDonViCongTac,
        String chucDanh,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResQuaTrinhCongTac mapToResQuaTrinhCongTac(QuaTrinhCongTac tac) {
        return tac != null ? new ResQuaTrinhCongTac(
                tac.getId(),
                tac.getBatDau(),
                tac.getKetThuc(),
                tac.getDonViCongTac().getName(),
                tac.getDonViCongTac().getId(),
                tac.getChucDanh(),
                tac.getCreate_at(),
                tac.getUpdate_at()
        ) : null;
    }
    public static class ResQuaTrinhCongTacSerializer implements Serializer<ResQuaTrinhCongTac> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, ResQuaTrinhCongTac data) {
            try {
                return data != null ? objectMapper.writeValueAsBytes(data) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }

    public static class ResQuaTrinhCongTacDeserializer implements Deserializer<ResQuaTrinhCongTac> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public ResQuaTrinhCongTac deserialize(String topic, byte[] data) {
            try {
                return data != null ? objectMapper.readValue(data, ResQuaTrinhCongTac.class) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }
}
