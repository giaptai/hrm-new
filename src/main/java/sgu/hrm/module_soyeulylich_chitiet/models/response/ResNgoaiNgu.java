package sgu.hrm.module_soyeulylich_chitiet.models.response;

import sgu.hrm.module_soyeulylich_chitiet.models.NgoaiNgu;

import java.time.LocalDateTime;

public record ResNgoaiNgu(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        int IdTenCoSoDaoTao,
        String tenNgoaiNgu,
        String chungChiDuocCap,
        float diemSo,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResNgoaiNgu mapToResNgoaiNgu(NgoaiNgu ngu) {
        return ngu != null ? new ResNgoaiNgu(
                ngu.getId(),
                ngu.getBatDau(),
                ngu.getKetThuc(),
                ngu.getTenCoSoDaoTao().getName(),
                ngu.getTenCoSoDaoTao().getId(),
                ngu.getTenNgoaiNgu(),
                ngu.getChungChiDuocCap(),
                ngu.getDiemSo(),
                ngu.getCreate_at(),
                ngu.getUpdate_at()
        ) : null;
    }

}
