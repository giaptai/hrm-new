package sgu.hrm.module_soyeulylich_chitiet.models.request;

import sgu.hrm.module_soyeulylich_chitiet.models.LoaiSoYeuLyLichChiTiet;

import java.time.LocalDateTime;

public record ReqQuanHeGiaDinh(
        String moiQuanHe,
        String hoVaTen,
        short namSinh,
        String thongTinThanNhan,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
