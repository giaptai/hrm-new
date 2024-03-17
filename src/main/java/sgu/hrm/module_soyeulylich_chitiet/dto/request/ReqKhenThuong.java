package sgu.hrm.module_soyeulylich_chitiet.dto.request;

import lombok.Builder;
import sgu.hrm.enums.XepLoaiChuyenMon;
import sgu.hrm.enums.XepLoaiThiDua;

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
