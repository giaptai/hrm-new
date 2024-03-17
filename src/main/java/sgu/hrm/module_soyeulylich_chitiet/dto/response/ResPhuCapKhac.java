package sgu.hrm.module_soyeulylich_chitiet.dto.response;

import sgu.hrm.module_soyeulylich_chitiet.models.PhuCapKhac;

import java.time.LocalDateTime;

public record ResPhuCapKhac(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String loaiPhuCap,
        int IdLoaiPhuCap,
        float phanTramHuongPhuCap,
        float heSoPhuCap,
        String hinhThucHuong,
        double giaTri,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResPhuCapKhac mapToResPhuCapKhac(PhuCapKhac khac) {
        return khac != null ? new ResPhuCapKhac(
                khac.getId(),
                khac.getBatDau(),
                khac.getKetThuc(),
                khac.getLoaiPhuCap().getName(),
                khac.getLoaiPhuCap().getId(),
                khac.getPhanTramHuongPhuCap(),
                khac.getHeSoPhuCap(),
                khac.getHinhThucHuong(),
                khac.getGiaTri(),
                khac.getCreate_at(),
                khac.getUpdate_at()
        ) : null;
    }

}
