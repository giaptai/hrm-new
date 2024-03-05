package sgu.hrm.module_soyeulylich_chitiet.models.request;

import java.time.LocalDateTime;

public record ReqBanThanCoLamViecChoCheDoCu(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String chucDanhDonViDiaDiem
) {
}
