package sgu.hrm.module_heso_luong.models.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResHeSoLuongVienChuc(
        int id,
        float heSo,
        String bacLuong,
        String nhomLoaiVienChuc,
        boolean trangThai,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
