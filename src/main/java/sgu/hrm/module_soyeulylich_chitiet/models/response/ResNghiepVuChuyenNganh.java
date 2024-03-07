package sgu.hrm.module_soyeulylich_chitiet.models.response;

import sgu.hrm.module_soyeulylich_chitiet.models.NghiepVuChuyenNganh;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResNghiepVuChuyenNganh(
        int id,
        UUID maSyll,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        String chungChiDuocCap,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResNghiepVuChuyenNganh mapToResNghiepVuChuyenNganh(NghiepVuChuyenNganh nganh) {
        return nganh != null ? new ResNghiepVuChuyenNganh(
                nganh.getId(),
                nganh.getSoYeuLyLich().getId(),
                nganh.getBatDau(),
                nganh.getKetThuc(),
                nganh.getTenCoSoDaoTao(),
                nganh.getChungChiDuocCap(),
                nganh.getCreate_at(),
                nganh.getUpdate_at()
        ) : null;
    }

}
