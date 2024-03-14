package sgu.hrm.module_soyeulylich_chitiet.models.request;

import sgu.hrm.module_utilities.enums.XacNhan;

import java.time.LocalDateTime;

public record ReqKyLuat(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String hinhThuc,
        String hanhViViPhamChinh,
        int coQuanQuyetDinh //DonVi
) {
}
