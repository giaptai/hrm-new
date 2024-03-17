package sgu.hrm.module_taikhoan.dto.resopnse;

import lombok.Builder;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_taikhoan.models.TaiKhoan;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Builder
public record ResTaiKhoan(
        int id,
        String hoVaten,
        String soCCCD,
        String username,
        String email,
        UUID maSoYeuLyLich,
        String role,
        boolean trangThai,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResTaiKhoan mapToResTaiKhoan(TaiKhoan taiKhoan) {
        return new ResTaiKhoan(
                taiKhoan.getId(),
                taiKhoan.getHoVaTen(),
                taiKhoan.getSoCCCD(),
                taiKhoan.getUsername(),
                taiKhoan.getEmail(),
                Optional.ofNullable(taiKhoan.getSoYeuLyLich()).map(SoYeuLyLich::getId).orElse(null),
                taiKhoan.getRoleTaiKhoan().getName(),
                taiKhoan.isTrangThai(),
                taiKhoan.getCreate_at(),
                taiKhoan.getUpdate_at()
        );
    }
}
