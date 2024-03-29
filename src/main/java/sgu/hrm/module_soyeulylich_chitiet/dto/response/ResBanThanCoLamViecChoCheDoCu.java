package sgu.hrm.module_soyeulylich_chitiet.dto.response;

import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;

import java.time.LocalDateTime;

public record ResBanThanCoLamViecChoCheDoCu(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String chucDanhDonViDiaDiem,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResBanThanCoLamViecChoCheDoCu maptoResBanThanCoLamViecChoCheDoCu(BanThanCoLamViecChoCheDoCu cu) {
        return cu != null ? new ResBanThanCoLamViecChoCheDoCu(
                cu.getId(),
                cu.getBatDau(),
                cu.getKetThuc(),
                cu.getChucDanhDonViDiaDiem(),
                cu.getCreate_at(),
                cu.getUpdate_at()
        ) : null;
    }
}
