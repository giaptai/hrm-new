package sgu.hrm.module_soyeulylich_chitiet.models.response;

import sgu.hrm.module_soyeulylich_chitiet.models.KhenThuong;
import sgu.hrm.module_utilities.models.HinhThucKhenThuong;

import java.time.LocalDateTime;
import java.util.Optional;

public record ResKhenThuong(
        int id,
        LocalDateTime nam,
        String xepLoaiChuyenMon,
        String xepLoaiThiDua,
        String hinhThucKhenThuong,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResKhenThuong maptoResKhenThuong(KhenThuong thuong) {
        return thuong != null ? new ResKhenThuong(
                thuong.getId(),
                thuong.getNam(),
                thuong.getXepLoaiChuyenMon(),
                thuong.getXepLoaiThiDua(),
                Optional.ofNullable(thuong.getHinhThucKhenThuong()).map(HinhThucKhenThuong::getName).orElse(null),
                thuong.getCreate_at(),
                thuong.getUpdate_at()
        ) : null;
    }
}
