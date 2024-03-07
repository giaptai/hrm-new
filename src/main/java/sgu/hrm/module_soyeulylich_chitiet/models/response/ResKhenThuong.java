package sgu.hrm.module_soyeulylich_chitiet.models.response;

import sgu.hrm.module_soyeulylich_chitiet.models.KhenThuong;
import sgu.hrm.module_utilities.enums.XepLoaiChuyenMon;
import sgu.hrm.module_utilities.enums.XepLoaiThiDua;
import sgu.hrm.module_utilities.models.HinhThucKhenThuong;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public record ResKhenThuong(
        int id,
        UUID maSyll,
        LocalDateTime nam,
        String xepLoaiChuyenMon,
        XepLoaiChuyenMon xepLoaiChuyenMonEnum,
        String xepLoaiThiDua,
        XepLoaiThiDua xepLoaiThiDuaEnum,
        String hinhThucKhenThuong,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResKhenThuong maptoResKhenThuong(KhenThuong thuong) {
        return thuong != null ? new ResKhenThuong(
                thuong.getId(),
                thuong.getSoYeuLyLich().getId(),
                thuong.getNam(),
                thuong.getXepLoaiChuyenMon().getName(),
                thuong.getXepLoaiChuyenMon(),
                thuong.getXepLoaiThiDua().getName(),
                thuong.getXepLoaiThiDua(),
                Optional.ofNullable(thuong.getHinhThucKhenThuong()).map(HinhThucKhenThuong::getName).orElse(null),
                thuong.getCreate_at(),
                thuong.getUpdate_at()
        ) : null;
    }
}
