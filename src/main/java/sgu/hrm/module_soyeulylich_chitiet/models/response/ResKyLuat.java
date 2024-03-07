package sgu.hrm.module_soyeulylich_chitiet.models.response;

import sgu.hrm.module_soyeulylich_chitiet.models.KyLuat;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResKyLuat(
        int id,
        UUID maSyll,
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
                luat.getSoYeuLyLich().getId(),
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
