package sgu.hrm.module_soyeulylich_chitiet.models.request;

import java.time.LocalDateTime;

public record ReqKyLuat(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String hinhThuc,
        String hanhViViPhamChinh,
        int coQuanQuyetDinh, //CoQuanToChucDonVi
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
