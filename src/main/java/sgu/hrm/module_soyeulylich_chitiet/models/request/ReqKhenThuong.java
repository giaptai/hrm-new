package sgu.hrm.module_soyeulylich_chitiet.models.request;

import lombok.Builder;
import sgu.hrm.module_utilities.enums.XacNhan;
import sgu.hrm.module_utilities.enums.XepLoaiChuyenMon;
import sgu.hrm.module_utilities.enums.XepLoaiThiDua;

import java.time.LocalDateTime;

@Builder
public record ReqKhenThuong(
        LocalDateTime nam,
        XepLoaiChuyenMon xepLoaiChuyenMon,
        XepLoaiThiDua xepLoaiThiDua,
        int hinhThucKhenThuong,
        String lyDo
) {
}
