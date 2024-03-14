package sgu.hrm.module_soyeulylich_chitiet.models.request;

import sgu.hrm.module_utilities.enums.XacNhan;

import java.time.LocalDateTime;

public record ReqLyLuanChinhTri(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTao,
        String hinhThucDaoTao,
        String vanBangDuocCap
) {
}
