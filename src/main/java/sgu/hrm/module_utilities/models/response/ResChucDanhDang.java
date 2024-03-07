package sgu.hrm.module_utilities.models.response;

import sgu.hrm.module_utilities.models.CapNhomChucDanhDang;
import sgu.hrm.module_utilities.models.ChucDanhDang;
import sgu.hrm.module_utilities.models.NhomChucDanhDang;

import java.time.LocalDateTime;
import java.util.Optional;

public record ResChucDanhDang(
        int id,
        String name,
        String capNhomChucDanhDang,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResChucDanhDang mapToResChucDanhDang(ChucDanhDang dang) {
        return dang != null ? new ResChucDanhDang(
                dang.getId(),
                dang.getName(),
                Optional.ofNullable(dang.getCapNhomChucDanhDang()).map(CapNhomChucDanhDang::getName).orElse(null),
                dang.getCreate_at(),
                dang.getUpdate_at()
        ) : null;
    }
}
