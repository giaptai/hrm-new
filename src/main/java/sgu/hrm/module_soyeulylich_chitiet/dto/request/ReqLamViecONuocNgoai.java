package sgu.hrm.module_soyeulylich_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqLamViecONuocNgoai(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String toChucDiaChiCongViec,
        String soYeuLyLich
) {
}
