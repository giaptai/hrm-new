package sgu.hrm.module_soyeulylich_chitiet.models.request;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReqKhenThuong(LocalDateTime nam,
                            String xepLoaiChuyenMon,
                            String xepLoaiThiDua,
                            int hinhThucKhenThuong,
                            String lyDo
) {
}
