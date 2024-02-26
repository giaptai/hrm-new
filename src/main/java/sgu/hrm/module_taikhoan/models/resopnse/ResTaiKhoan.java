package sgu.hrm.module_taikhoan.models.resopnse;

import lombok.Builder;

import java.time.LocalDateTime;
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
}
