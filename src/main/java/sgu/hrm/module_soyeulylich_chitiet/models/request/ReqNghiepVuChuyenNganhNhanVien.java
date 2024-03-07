package sgu.hrm.module_soyeulylich_chitiet.models.request;

import java.util.Set;
import java.util.UUID;

public record ReqNghiepVuChuyenNganhNhanVien(
        ReqNghiepVuChuyenNganh nghiepVuChuyenNganh,
        Set<UUID> danhSachMaHoSo
) {
}
