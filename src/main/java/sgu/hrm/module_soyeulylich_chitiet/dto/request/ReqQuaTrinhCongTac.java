package sgu.hrm.module_soyeulylich_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqQuaTrinhCongTac(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int donViCongTac, //CoQuanToChucDonVi
        String chucDanh,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
