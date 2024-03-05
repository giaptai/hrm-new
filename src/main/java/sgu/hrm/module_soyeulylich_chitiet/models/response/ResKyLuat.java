package sgu.hrm.module_soyeulylich_chitiet.models.response;

import sgu.hrm.module_soyeulylich_chitiet.models.KyLuat;

import java.time.LocalDateTime;

public record ResKyLuat(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String hinhThuc,
        String hanhViViPhamChinh,
        String coQuanQuyetDinh,
        LocalDateTime create_at,
        LocalDateTime update_at

) {
    public static ResKyLuat mapToResKyLuat(KyLuat luat) {
        return luat != null ? new ResKyLuat(
                luat.getId(),
                luat.getBatDau(),
                luat.getKetThuc(),
                luat.getHinhThuc(),
                luat.getHanhViViPhamChinh(),
                luat.getCoQuanQuyetDinh(),
                luat.getCreate_at(),
                luat.getUpdate_at()
        ) : null;
    }
}
