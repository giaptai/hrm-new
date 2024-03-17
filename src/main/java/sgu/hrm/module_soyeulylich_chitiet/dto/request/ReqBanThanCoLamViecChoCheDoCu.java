package sgu.hrm.module_soyeulylich_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqBanThanCoLamViecChoCheDoCu(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String chucDanhDonViDiaDiem
) {
}
