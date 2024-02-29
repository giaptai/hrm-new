package sgu.hrm.module_soyeulylich_chitiet.models.request;

import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record ReqKyLuatNhanVien(
        ReqKyLuat kyLuat,
        Set<UUID> nhanVienUUIDs

) {
}
