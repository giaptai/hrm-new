package sgu.hrm.module_utilities.models.response;

import sgu.hrm.module_utilities.models.CapNhomChucDanhDang;
import sgu.hrm.module_utilities.models.ChucDanhDang;
import sgu.hrm.module_utilities.models.ViTriViecLam;

import java.time.LocalDateTime;
import java.util.Optional;

public record ResViTriViecLam(
        int id,
        String name,
        String bacLuong,
        double tienLuong,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResViTriViecLam mapToResViTriViecLam(ViTriViecLam lam) {
        return lam != null ? new ResViTriViecLam(
                lam.getId(),
                lam.getName(),
                lam.getBacLuong().getName(),
                lam.getTienLuong(),
                lam.getCreate_at(),
                lam.getUpdate_at()
        ) : null;
    }
}
