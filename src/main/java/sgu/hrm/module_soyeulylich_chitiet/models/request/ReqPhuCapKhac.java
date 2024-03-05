package sgu.hrm.module_soyeulylich_chitiet.models.request;

import java.time.LocalDateTime;

public record ReqPhuCapKhac(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String loaiPhuCap,
        float phanTramHuongPhuCap,
        float heSoPhuCap,
        String hinhThucThuong,
        double giaTri,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
