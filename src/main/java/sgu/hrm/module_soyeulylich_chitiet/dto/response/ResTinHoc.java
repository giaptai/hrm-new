package sgu.hrm.module_soyeulylich_chitiet.dto.response;

import sgu.hrm.module_soyeulylich_chitiet.models.TinHoc;
import sgu.hrm.module_cauhinh.models.CoQuanToChucDonVi;

import java.time.LocalDateTime;
import java.util.Optional;

public record ResTinHoc(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        int IdTenCoSoDaoTao,
        String chungChiDuocCap,
        LocalDateTime create_at,
        LocalDateTime update_at

) {
    public static ResTinHoc mapToResTinHoc(TinHoc hoc) {
        String nameCSDT = Optional.ofNullable(hoc.getTenCoSoDaoTao()).map(CoQuanToChucDonVi::getName).orElse(null);
        int idCSDT = Optional.ofNullable(hoc.getTenCoSoDaoTao()).map(CoQuanToChucDonVi::getId).orElse(-1);
        return hoc != null ? new ResTinHoc(
                hoc.getId(),
                hoc.getBatDau(),
                hoc.getKetThuc(),
                nameCSDT,
                idCSDT,
                hoc.getChungChiDuocCap(),
                hoc.getCreate_at(),
                hoc.getUpdate_at()
        ) : null;
    }

}
