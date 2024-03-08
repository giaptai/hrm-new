package sgu.hrm.module_soyeulylich_chitiet.models.request;

import java.time.LocalDateTime;

public record ReqNghiepVuChuyenNganh(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTao,
        String chungChiDuocCap,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
