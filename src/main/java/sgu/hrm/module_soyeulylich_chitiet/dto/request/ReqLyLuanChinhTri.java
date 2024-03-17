package sgu.hrm.module_soyeulylich_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqLyLuanChinhTri(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTao,
        String hinhThucDaoTao,
        String vanBangDuocCap
) {
}
