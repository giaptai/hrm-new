package sgu.hrm.module_soyeulylich_chitiet.models.request;

import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record ReqQuaTrinhCongTacNhanVien(
        ReqQuaTrinhCongTac quaTrinhCongTac,
        Set<UUID> danhSachMaHoSo
) {
}
