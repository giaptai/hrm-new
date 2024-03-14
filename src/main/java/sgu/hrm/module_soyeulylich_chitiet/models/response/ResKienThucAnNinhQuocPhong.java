package sgu.hrm.module_soyeulylich_chitiet.models.response;

import sgu.hrm.module_soyeulylich_chitiet.models.KienThucAnNinhQuocPhong;
import sgu.hrm.module_utilities.enums.XacNhan;

import java.time.LocalDateTime;

public record ResKienThucAnNinhQuocPhong(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        int IdTenCoSoDaoTao,
        String chungChiDuocCap,
        XacNhan xacNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResKienThucAnNinhQuocPhong mapToResKienThucAnNinhQuocPhong(KienThucAnNinhQuocPhong phong) {
        return phong != null ? new ResKienThucAnNinhQuocPhong(
                phong.getId(),
                phong.getBatDau(),
                phong.getKetThuc(),
                phong.getTenCoSoDaoTao().getName(),
                phong.getTenCoSoDaoTao().getId(),
                phong.getChungChiDuocCap(),
                phong.getXacNhan(),
                phong.getCreate_at(),
                phong.getUpdate_at()
        ) : null;
    }
}
