package sgu.hrm.module_soyeulylich_chitiet.models.response;

import sgu.hrm.module_soyeulylich_chitiet.models.KienThucAnNinhQuocPhong;

import java.time.LocalDateTime;

public record ResKienThucAnNinhQuocPhong(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        String chungChiDuocCap,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResKienThucAnNinhQuocPhong mapToResKienThucAnNinhQuocPhong(KienThucAnNinhQuocPhong phong) {
        return phong != null ? new ResKienThucAnNinhQuocPhong(
                phong.getId(),
                phong.getBatDau(),
                phong.getKetThuc(),
                phong.getTenCoSoDaoTao().getName(),
                phong.getChungChiDuocCap(),
                phong.getCreate_at(),
                phong.getUpdate_at()
        ) : null;
    }
}
