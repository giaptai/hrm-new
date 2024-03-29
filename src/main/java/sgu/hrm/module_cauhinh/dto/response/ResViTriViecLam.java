package sgu.hrm.module_cauhinh.dto.response;

import sgu.hrm.module_cauhinh.models.ViTriViecLam;

import java.time.LocalDateTime;

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
