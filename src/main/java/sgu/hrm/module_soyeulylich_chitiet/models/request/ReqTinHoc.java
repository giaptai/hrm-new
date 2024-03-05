package sgu.hrm.module_soyeulylich_chitiet.models.request;

import java.time.LocalDateTime;

public record ReqTinHoc(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        String chungChiDuocCap,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
