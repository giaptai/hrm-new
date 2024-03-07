package sgu.hrm.module_utilities.models.request;

import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;

public record ReqUtilities(
        String name,
        int loaiQuanHamQuanDoi,
        int nhomChucDanhDang,
        int capNhomChucDanhDang,
        int bacLuong,
        double tienLuong
) {
}
