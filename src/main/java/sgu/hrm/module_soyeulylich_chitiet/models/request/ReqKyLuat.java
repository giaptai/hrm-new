package sgu.hrm.module_soyeulylich_chitiet.models.request;

import java.time.LocalDateTime;

public record ReqKyLuat(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String hinhThuc,
        String hanhViViPhamChinh,
        String coQuanQuyetDinh,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
