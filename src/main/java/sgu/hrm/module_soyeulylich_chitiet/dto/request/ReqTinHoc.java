package sgu.hrm.module_soyeulylich_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqTinHoc(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTao,
        String chungChiDuocCap
) {
}
