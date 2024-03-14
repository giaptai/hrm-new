package sgu.hrm.module_soyeulylich_chitiet.models.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Set;
import java.util.UUID;

@Builder
public record ReqKhenThuongNhanVien(
        ReqKhenThuong khenThuong,
        Set<UUID> danhSachMaHoSo
) {
}
