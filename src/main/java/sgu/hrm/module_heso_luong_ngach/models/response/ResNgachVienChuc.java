package sgu.hrm.module_heso_luong_ngach.models.response;

import lombok.Builder;
import sgu.hrm.module_heso_luong_ngach.models.NgachVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.HeSoLuongVienChuc;

import java.time.LocalDateTime;
import java.util.Optional;

@Builder
public record ResNgachVienChuc(
        String id,
        String name,
        float heSo,
        String bacLuong,
        String nhomLoaiVienChuc,
        boolean trangThai,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResNgachVienChuc mapToResNgachVienChuc(NgachVienChuc v) {
        return new ResNgachVienChuc(
                v.getId(),
                v.getName(),
                Optional.ofNullable(v.getHeSoLuongVienChuc()).map(HeSoLuongVienChuc::getHeSo).orElse(0.0f),
                v.getHeSoLuongVienChuc() != null ? v.getHeSoLuongVienChuc().getBacLuong().getName() : "",
                v.getHeSoLuongVienChuc() != null ? v.getHeSoLuongVienChuc().getNhomVienChuc().getName() : "",
                v.isTrangThai(),
                v.getCreate_at(),
                v.getUpdate_at()
        );
    }
}
