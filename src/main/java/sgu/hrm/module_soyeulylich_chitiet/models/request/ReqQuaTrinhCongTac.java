package sgu.hrm.module_soyeulylich_chitiet.models.request;

import java.time.LocalDateTime;

public record ReqQuaTrinhCongTac(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String donViCongTac,
        String chucDanh,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
