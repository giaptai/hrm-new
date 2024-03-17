package sgu.hrm.module_soyeulylich_chitiet.dto.response;

import sgu.hrm.module_soyeulylich_chitiet.models.QuanHeGiaDinh;

import java.time.LocalDateTime;

public record ResQuanHeGiaDinh(
        int id,
        String moiQuanHe,
        String hoVaTen,
        short namSinh,
        String thongTinThanNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResQuanHeGiaDinh mapToResQuanHeGiaDinh(QuanHeGiaDinh dinh) {
        return dinh != null ? new ResQuanHeGiaDinh(
                dinh.getId(),
                dinh.getMoiQuanHe().getName(),
                dinh.getHoVaTen(),
                dinh.getNamSinh(),
                dinh.getThongTinThanNhan(),
                dinh.getCreate_at(),
                dinh.getUpdate_at()
        ) : null;
    }
}
