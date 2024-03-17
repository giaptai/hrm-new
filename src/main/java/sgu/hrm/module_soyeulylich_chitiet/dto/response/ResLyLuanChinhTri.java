package sgu.hrm.module_soyeulylich_chitiet.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import sgu.hrm.module_soyeulylich_chitiet.models.LyLuanChinhTri;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResLyLuanChinhTri(
        int id,
        UUID maSyll,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        int IdTenCoSoDaoTao,
        String hinhThucDaoTao,
        String vanBangDuocCap,
        LocalDateTime create_at,
        LocalDateTime update_at

) {
    public static ResLyLuanChinhTri mapToResLyLuanChinhTri(LyLuanChinhTri tri) {
        return tri != null ? new ResLyLuanChinhTri(
                tri.getId(),
                tri.getSoYeuLyLich().getId(),
                tri.getBatDau(),
                tri.getKetThuc(),
                tri.getTenCoSoDaoTao().getName(),
                tri.getTenCoSoDaoTao().getId(),
                tri.getHinhThucDaoTao(),
                tri.getVanBangDuocCap(),
                tri.getCreate_at(),
                tri.getUpdate_at()
        ) : null;
    }
    public static class ResLyLuanChinhTriSerializer implements Serializer<ResLyLuanChinhTri> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, ResLyLuanChinhTri data) {
            try {
                return data != null ? objectMapper.writeValueAsBytes(data) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }

    public static class ResLyLuanChinhTriDeserializer implements Deserializer<ResLyLuanChinhTri> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public ResLyLuanChinhTri deserialize(String topic, byte[] data) {
            try {
                return data != null ? objectMapper.readValue(data, ResLyLuanChinhTri.class) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }
}
