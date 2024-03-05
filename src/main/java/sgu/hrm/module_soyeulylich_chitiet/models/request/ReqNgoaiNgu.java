package sgu.hrm.module_soyeulylich_chitiet.models.request;

import java.time.LocalDateTime;

public record ReqNgoaiNgu(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        String tenNgoaiNgu,
        String chungChiDuocCap,
        float diemSo,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
