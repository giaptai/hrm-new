package sgu.hrm.module_soyeulylich_chitiet.models.response;

import sgu.hrm.module_soyeulylich_chitiet.models.LamViecONuocNgoai;

import java.time.LocalDateTime;

public record ResLamViecONuocNgoai(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String toChucDiaChiCongViec,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResLamViecONuocNgoai mapToResLamViecONuocNgoai(LamViecONuocNgoai ngoai) {
        return ngoai != null ? new ResLamViecONuocNgoai(
                ngoai.getId(),
                ngoai.getBatDau(),
                ngoai.getKetThuc(),
                ngoai.getToChucDiaChiCongViec(),
                ngoai.getCreate_at(),
                ngoai.getUpdate_at()
        ) : null;
    }
}
