package sgu.hrm.module_soyeulylich_chitiet.dto.request;

import sgu.hrm.module_soyeulylich_chitiet.models.LoaiSoYeuLyLichChiTiet;

import java.time.LocalDateTime;

public record ReqQuanHeGiaDinh(
        int moiQuanHe,
        String hoVaTen,
        short namSinh,
        String thongTinThanNhan
) {
}
